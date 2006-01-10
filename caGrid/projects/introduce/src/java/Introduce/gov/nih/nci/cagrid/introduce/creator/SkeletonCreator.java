package gov.nih.nci.cagrid.introduce.creator;

import gov.nih.nci.cagrid.common.CommonTools;
import gov.nih.nci.cagrid.introduce.ServiceInformation;
import gov.nih.nci.cagrid.introduce.beans.metadata.ServiceMetadataListType;
import gov.nih.nci.cagrid.introduce.beans.method.MethodsType;

import java.io.File;
import java.util.Properties;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class SkeletonCreator extends Task {

	public SkeletonCreator() {
	}

	public void execute() throws BuildException {
		super.execute();
		Properties properties = new Properties();
		properties.putAll(this.getProject().getProperties());
		
		File baseDirectory = new File(properties.getProperty(
		"introduce.skeleton.destination.dir"));
		
		ServiceMetadataListType metadatas = null;
		MethodsType methods = null;
		try {
			methods = (MethodsType) CommonTools
			.deserializeDocument(baseDirectory + File.separator
					+ "introduceMethods.xml",
					MethodsType.class);
			metadatas = (ServiceMetadataListType) CommonTools
			.deserializeDocument(baseDirectory + File.separator
					+ "introduceMetadata.xml",
					ServiceMetadataListType.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		ServiceInformation info = new ServiceInformation(methods, metadatas, properties);
		
		SkeletonBaseCreator sbc = new SkeletonBaseCreator();
		SkeletonSourceCreator ssc = new SkeletonSourceCreator();
		SkeletonSchemaCreator sscc = new SkeletonSchemaCreator();
		SkeletonEtcCreator sec = new SkeletonEtcCreator();
		SkeletonDocsCreator sdc = new SkeletonDocsCreator();

		String service = properties
				.getProperty("introduce.skeleton.service.name");
		if (!service.matches("[A-Z]++[A-Za-z0-9\\_\\$]*")) {
			System.err
					.println("Service Name can only contain [A-Z]++[A-Za-z0-9\\_\\$]*");
			return;
		}
		if (service.substring(0, 1).toLowerCase().equals(
				service.substring(0, 1))) {
			System.err
					.println("Service Name cannnot start with lower case letters.");
			return;
		}

		//create the dirs to the basedir if needed
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
			throw be;
		}
	}
}