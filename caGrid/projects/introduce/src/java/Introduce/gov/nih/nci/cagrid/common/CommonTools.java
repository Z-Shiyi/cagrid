package gov.nih.nci.cagrid.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.projectmobius.common.MobiusException;
import org.projectmobius.common.XMLUtilities;

public class CommonTools {

	public static Process createAndOutputProcess(String cmd) throws Exception {
		final Process p;

		p = Runtime.getRuntime().exec(cmd);

		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				try {

					System.out.println(XMLUtilities.streamToString(p
							.getInputStream()));
				} catch (MobiusException e) {
					e.printStackTrace();
				}

			}
		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
					System.err.println(XMLUtilities.streamToString(p
							.getErrorStream()));
				} catch (MobiusException e) {
					e.printStackTrace();
				}

			}
		});
		thread2.start();

		return p;
	}

	public static String getAntCommand(String antCommand, String buildFileDir)
			throws Exception {
		String cmd = " " + antCommand;
		cmd = getAntCommandCall(buildFileDir) + cmd;
		return cmd;
	}

	public static String getAntFlattenCommand(String buildFileDir)
			throws Exception {
		return getAntCommand("flatten", buildFileDir);
	}

	public static String getAntSkeletonResyncCommand(String buildFileDir)
			throws Exception {
		return getAntCommand("resync", buildFileDir);
	}

	public static String getAntSkeletonCreationCommand(String buildFileDir,
			String name, String dir, String packagename, String namespacedomain)
			throws Exception {
		String cmd = " -Dintroduce.skeleton.destination.dir=" + dir
				+ " -Dintroduce.skeleton.service.name=" + name
				+ " -Dintroduce.skeleton.package=" + packagename
				+ " -Dintroduce.skeleton.package.dir="
				+ packagename.replace('.', File.separatorChar)
				+ " -Dintroduce.skeleton.namespace.domain=" + namespacedomain
				+ " createService";
		cmd = getAntCommandCall(buildFileDir) + cmd;
		return cmd;
	}

	static String getAntCommandCall(String buildFileDir) throws Exception {
		String os = System.getProperty("os.name");
		String cmd = "";
		if ((os.indexOf("Windows") >= 0) || (os.indexOf("windows") >= 0)) {
			cmd = "-classpath "
					+ CommonTools.getAntLauncherJarLocation(System
							.getProperty("java.class.path"), true)
					+ " org.apache.tools.ant.launch.Launcher -lib "
					+ System.getProperty("java.class.path") + " -buildfile "
					+ buildFileDir + File.separator + "build.xml" + cmd;
			cmd = "java.exe " + cmd;
		} else if ((os.indexOf("Linux") >= 0) || (os.indexOf("linux") >= 0)) {
			cmd = "-classpath "
					+ CommonTools.getAntLauncherJarLocation(System
							.getProperty("java.class.path"), false)
					+ " org.apache.tools.ant.launch.Launcher -lib "
					+ System.getProperty("java.class.path") + " -buildfile "
					+ buildFileDir + File.separator + "build.xml" + cmd;
			cmd = "java " + cmd;
		} else {
			throw new Exception(
					"Cannot create grid service, your operatingsystem, " + os
							+ " is not supported.");
		}
		return cmd;
	}

	static String getAntLauncherJarLocation(String path, boolean isWindows) {
		String separator = isWindows ? ";" : ":";
		StringTokenizer pathTokenizer = new StringTokenizer(path, separator);
		while (pathTokenizer.hasMoreTokens()) {
			String pathElement = pathTokenizer.nextToken();
			if (pathElement.indexOf("ant-launcher") != -1
					&& pathElement.endsWith(".jar")) {
				return pathElement;
			}
		}
		return null;
	}
	
	public static StringBuffer fileToStringBuffer(File file) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		try {
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}
		} catch (Exception e) {
			throw new Exception("Error reading the buffer: " + e.getMessage());
		}

		return sb;
	}

}
