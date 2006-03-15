package gov.nih.nci.cagrid.introduce.creator;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.introduce.ServiceInformation;
import gov.nih.nci.cagrid.introduce.beans.ServiceDescription;

import java.io.File;
import java.util.Properties;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella </A>
 * 
 */
public class SkeletonCreator extends Task {

	public SkeletonCreator() {
	}


	public void execute() throws BuildException {
		super.execute();

		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());

		Properties properties = new Properties();
		properties.putAll(this.getProject().getProperties());

		File baseDirectory = new File(properties.getProperty("introduce.skeleton.destination.dir"));

		ServiceDescription introService = null;
		try {

			introService = (ServiceDescription) Utils.deserializeDocument(baseDirectory + File.separator
				+ "introduce.xml", ServiceDescription.class);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		ServiceInformation info = new ServiceInformation(introService, properties, baseDirectory);
		SkeletonBaseCreator sbc = new SkeletonBaseCreator();
		SkeletonSourceCreator ssc = new SkeletonSourceCreator();
		SkeletonSchemaCreator sscc = new SkeletonSchemaCreator();
		SkeletonEtcCreator sec = new SkeletonEtcCreator();
		SkeletonDocsCreator sdc = new SkeletonDocsCreator();

		String service = properties.getProperty("introduce.skeleton.service.name");
		if (!service.matches("[A-Z]++[A-Za-z0-9\\_\\$]*")) {
			System.err.println("Service Name can only contain [A-Z]++[A-Za-z0-9\\_\\$]*");
			return;
		}
		if (service.substring(0, 1).toLowerCase().equals(service.substring(0, 1))) {
			System.err.println("Service Name cannnot start with lower case letters.");
			return;
		}

		// create the dirs to the basedir if needed
		baseDirectory.mkdirs();

		// Generate the source
		try {
			sbc.createSkeleton(info);
			ssc.createSkeleton(info);
			sscc.createSkeleton(info);
			sec.createSkeleton(info);
			sdc.createSkeleton(info);
		} catch (Exception e) {
			BuildException be = new BuildException(e.getMessage());
			be.setStackTrace(e.getStackTrace());
			be.printStackTrace();
			throw be;
		}
	}
}