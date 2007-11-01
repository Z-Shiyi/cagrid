package gov.nih.nci.cagrid.metadata.xmi;

import gov.nih.nci.cagrid.common.StreamGobbler;
import gov.nih.nci.cagrid.common.Utils;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/** 
 *  FixXmiExecutor
 *  Executes SDK 3.1 / 3.2 / 3.2.1's fix-xmi ant target
 * 
 * @author David Ervin
 * 
 * @created Oct 29, 2007 2:11:31 PM
 * @version $Id: FixXmiExecutor.java,v 1.2 2007-11-01 16:33:39 dervin Exp $ 
 */
public class FixXmiExecutor {
    public static final Logger LOG = Logger.getLogger(FixXmiExecutor.class);
    
    // problematic elements in the original XMI
    public static final String DOCTYPE_UML_EA = "<!DOCTYPE XMI SYSTEM \"UML_EA.dtd\">";

    // ant tasks
    public static final String FIX_XMI_TASK = "fix-xmi";
    public static final String COMPILE_GENERATOR_TASK = "compile-generator";
    
    // properties for the ant tasks
    public static final String MODEL_DIR_PROPERTY = "dir.model";
    public static final String MODEL_FILENAME_PROPERTY = "model_filename";
    public static final String FIXED_MODEL_FILENAME_PROPERTY = "fixed_filename";
    public static final String PREPROCESSOR_PROPERTY = "xmi_preprocessor";
    
    // the EA xmi preprocessor class
    public static final String EA_XMI_PREPROCESSOR = 
        "gov.nih.nci.codegen.core.util.EAXMIPreprocessor";
    
    /**
     * Runs the SDK's fix-xmi target against the specified model
     * @param originalModel
     *      The file containing the original XMI model from EA
     * @param sdkDir
     *      The caCORE SDK base directory
     * @return
     *      The file containing the 'fixed' model
     */
    public static File fixEaXmiModel(File originalModel, File sdkDir) throws IOException,
        InterruptedException {
        File cleanModelFile = cleanXmi(originalModel);
        StringBuilder command = new StringBuilder();
        // get the base ant command
        command.append(getAntCall(sdkDir.getAbsolutePath())).append(" ");
        // add properties and their values
        command.append("-D").append(MODEL_DIR_PROPERTY)
            .append("=\"").append(cleanModelFile.getAbsoluteFile().getParent()).append("\" ");
        command.append("-D").append(MODEL_FILENAME_PROPERTY)
            .append("=").append(cleanModelFile.getName()).append(" ");
        command.append("-D").append(FIXED_MODEL_FILENAME_PROPERTY)
            .append("=").append("fixed_").append(originalModel.getName()).append(" ");
        command.append("-D").append(PREPROCESSOR_PROPERTY)
            .append("=").append(EA_XMI_PREPROCESSOR);
        // execute the command
        System.out.println("Executing " + command.toString());
        Process proc = Runtime.getRuntime().exec(command.toString());
        new StreamGobbler(proc.getInputStream(), StreamGobbler.TYPE_OUT,
            LOG, Priority.DEBUG).start();
        new StreamGobbler(proc.getErrorStream(), StreamGobbler.TYPE_ERR,
            LOG, Priority.DEBUG).start();
        System.out.println("Waiting");
        proc.waitFor();
        if (proc.exitValue() == 0) {
            return new File(originalModel.getParent() + File.separator + "fixed_" + originalModel.getName());
        } else {
            throw new RuntimeException("Error executing fix-xmi command:\n" + command.toString());
        }
    }
    
    
    private static String getAntCall(String buildFileDir) {
        String os = System.getProperty("os.name").toLowerCase();
        StringBuilder cmd = new StringBuilder();
        if (os.indexOf("windows") >= 0) {
            cmd.append("java.exe ");
            cmd.append("-classpath \"").append(getAntLauncherJarLocation(System.getProperty("java.class.path")));
            cmd.append("\" org.apache.tools.ant.launch.Launcher -buildfile \"").append(buildFileDir);
            cmd.append(File.separator).append("build.xml\"");
        } else {
            // escape out the spaces.....
            buildFileDir = buildFileDir.replaceAll("\\s", "\\ ");
            cmd.append("java ");
            cmd.append("-classpath ").append(getAntLauncherJarLocation(System.getProperty("java.class.path")));
            cmd.append(" org.apache.tools.ant.launch.Launcher -buildfile ").append(buildFileDir);
            cmd.append(File.separator).append("build.xml");
        }
        // add targets
        cmd.append(" ").append(COMPILE_GENERATOR_TASK).append(" ").append(FIX_XMI_TASK);
        return cmd.toString();
    }
    
    
    private static String getAntLauncherJarLocation(String path) {
        StringTokenizer pathTokenizer = new StringTokenizer(path, File.pathSeparator);
        while (pathTokenizer.hasMoreTokens()) {
            String pathElement = pathTokenizer.nextToken();
            if ((pathElement.indexOf("ant-launcher") != -1) && pathElement.endsWith(".jar")) {
                return pathElement;
            }
        }
        return null;
    }
    
    
    private static File cleanXmi(File originalXmi) throws IOException {
        System.out.println("Clean XMI");
        File cleanedFile = null;
        StringBuffer xmiContents = Utils.fileToStringBuffer(originalXmi);
        int start = xmiContents.indexOf(DOCTYPE_UML_EA); 
        if (start != -1) {
            System.out.println("OFFENDING DOCTYPE ELEMENT FOUND");
            xmiContents.delete(start, start + DOCTYPE_UML_EA.length());
            File temp = new File(originalXmi.getParentFile(), "cleaned_" + originalXmi.getName());
            System.out.println("Saving cleaned to " + temp.getAbsolutePath());
            Utils.stringBufferToFile(xmiContents, temp.getAbsolutePath());
            cleanedFile = temp;
        } else {
            // no processing to do, return the original
            cleanedFile = originalXmi;
        }
        return cleanedFile;
    }
}
