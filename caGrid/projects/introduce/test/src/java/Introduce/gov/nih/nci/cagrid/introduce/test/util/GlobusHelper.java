/*
 * Created on Apr 22, 2006
 */
package gov.nih.nci.cagrid.introduce.test.util;

import gov.nih.nci.cagrid.common.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.Address;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.oasis.wsrf.lifetime.Destroy;

import com.counter.CounterPortType;
import com.counter.CreateCounter;
import com.counter.CreateCounterResponse;
import com.counter.service.CounterServiceAddressingLocator;


public class GlobusHelper {
    private File tmpDir;
    private boolean secure;
    private File tmpGlobusLocation;
    private int port;
    private Process globusProcess;


    public GlobusHelper(boolean secure, File tmpDir, int port) {
        this.secure = secure;
        this.tmpDir = tmpDir;
        this.port = port;
    }


    public void createTempGlobus() throws IOException {
        // get globus location
        String globusLocation = System.getenv("GLOBUS_LOCATION");
        if ((globusLocation == null) || globusLocation.equals("")) {
            throw new IllegalArgumentException("GLOBUS_LOCATION not set");
        }

        // create tmp globus location
        tmpGlobusLocation = createTempDir("Globus", "dir", tmpDir);

        // copy globus to tmp location
        Utils.copyDirectory(new File(globusLocation), tmpGlobusLocation);
    }


    public void deployService(File serviceDir) throws IOException, InterruptedException {
        deployService(serviceDir, "deployGlobus");
    }


    public void deployService(File serviceDir, String target) 
        throws IOException, InterruptedException {
        String antHome = System.getenv("ANT_HOME");
        if ((antHome == null) || antHome.equals("")) {
            throw new IllegalArgumentException("ANT_HOME not set");
        }
        File ant = new File(antHome, "bin" + File.separator + "ant");

        String[] cmd = new String[]{ant.toString(), "deployGlobus"};
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            cmd = new String[]{"cmd", "/c", ant + ".bat", target,};
        }
        String[] envp = new String[]{"GLOBUS_LOCATION=" + tmpGlobusLocation.getAbsolutePath()};
        envp = EnvUtils.overrideEnv(envp);

        Process deployProcess = Runtime.getRuntime().exec(cmd, envp, serviceDir);
        new StdIOThread(deployProcess.getInputStream()).start();
        new StdIOThread(deployProcess.getErrorStream()).start();
        deployProcess.waitFor();

        if (deployProcess.exitValue() != 0) {
            throw new IOException("deployService ant command failed: "
                + deployProcess.exitValue());
        }
    }


    public void startGlobus() throws IOException {
        globusProcess = runGlobusCommand("org.globus.wsrf.container.ServiceContainer");

        // make sure it is running
        sleep(2000);
        for (int i = 0; i < 10; i++) {
            if (isGlobusRunning()) {
                return;
            }
            sleep(500);
        }
        throw new IOException("could not start Globus");
    }


    private Process runGlobusCommand(String clName) throws IOException {
        File java = new File(System.getProperty("java.home"), "bin" + File.separator + "java");
        File libDir = new File(tmpGlobusLocation, "lib");
        String classpath = libDir.getAbsolutePath() + File.separator + "bootstrap.jar" 
            + File.pathSeparator + libDir.getAbsolutePath() + File.separator + "cog-url.jar" 
            + File.pathSeparator + libDir.getAbsolutePath() + File.separator + "axis-url.jar";

        // build command
        ArrayList cmd = new ArrayList();
        cmd.add(java.toString());
        cmd.add("-Dlog4j.configuration=container-log4j.properties");
        cmd.add("-DGLOBUS_LOCATION=" + tmpGlobusLocation.getAbsolutePath());
        cmd.add("-Djava.endorsed.dirs=" + tmpGlobusLocation.getAbsolutePath() 
            + File.separator + "endorsed");
        cmd.add("-classpath");
        cmd.add(classpath);
        cmd.add("org.globus.bootstrap.Bootstrap");
        cmd.add(clName);
        if (new Integer(port) != null) {
            cmd.add("-p");
            cmd.add(String.valueOf(port));
        }
        if (!secure) {
            cmd.add("-nosec");
        }

        cmd.add("-debug");

        // build environment
        String[] envp = new String[]{
            // "ANT_HOME", System.getenv("ANT_HOME"),
            // "JAVA_HOME", System.getProperty("java.home"),
            "GLOBUS_LOCATION=" + tmpGlobusLocation};
        envp = EnvUtils.overrideEnv(envp);

        // start globus
        Process p = Runtime.getRuntime().exec((String[]) cmd.toArray(new String[0]), envp,
            new File(tmpGlobusLocation.getAbsolutePath()));
        new StdIOThread(p.getInputStream()).start();
        new StdIOThread(p.getErrorStream()).start();
        return p;
    }


    public boolean isGlobusRunning() {
        try {
            CounterServiceAddressingLocator locator = new CounterServiceAddressingLocator();
            EngineConfiguration engineConfig = new FileProvider(System.getenv("GLOBUS_LOCATION") 
                + File.separator + "client-config.wsdd");
            locator.setEngine(new AxisClient(engineConfig));

            CounterPortType counter = locator.getCounterPortTypePort(new EndpointReferenceType(
                new Address("http://localhost:" + port + "/wsrf/services/CounterService")));
            CreateCounterResponse response = counter.createCounter(new CreateCounter());
            EndpointReferenceType endpoint = response.getEndpointReference();
            // endpoint.getProperties().get_any()[0].getValue();
            counter = locator.getCounterPortTypePort(endpoint);
            counter.add(0);
            counter.destroy(new Destroy());
            return true;
        } catch (IOException e) {
            return false;
        } catch (ServiceException e) {
            return false;
        }
    }


    public void stopGlobus() throws IOException {
        if (globusProcess == null) {
            return;
        }
        globusProcess.destroy();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void cleanupTempGlobus() {
        if (tmpGlobusLocation != null) {
            Utils.deleteDir(tmpGlobusLocation.getAbsoluteFile());
        }
    }


    public File getTempGlobusLocation() {
        return tmpGlobusLocation;
    }


    private static void sleep(long ms) {
        Object sleep = new Object();
        try {
            synchronized (sleep) {
                sleep.wait(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private static File createTempDir(String prefix, String suffix, File dir) throws IOException {
        File temp = null;
        if (dir == null) {
            temp = File.createTempFile(prefix, suffix);
        } else {
            dir.mkdirs();
            temp = File.createTempFile(prefix, suffix, dir);
        }
        temp.delete();
        temp.mkdirs();
        return temp;
    }
}
