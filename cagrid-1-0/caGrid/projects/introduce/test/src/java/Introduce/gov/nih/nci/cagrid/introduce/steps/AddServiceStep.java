package gov.nih.nci.cagrid.introduce.steps;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.introduce.TestCaseInfo;
import gov.nih.nci.cagrid.introduce.beans.ServiceDescription;
import gov.nih.nci.cagrid.introduce.beans.method.MethodType;
import gov.nih.nci.cagrid.introduce.beans.method.MethodTypeInputs;
import gov.nih.nci.cagrid.introduce.beans.method.MethodTypeInputsInput;
import gov.nih.nci.cagrid.introduce.beans.method.MethodTypeOutput;
import gov.nih.nci.cagrid.introduce.beans.method.MethodsType;
import gov.nih.nci.cagrid.introduce.beans.service.ServiceType;
import gov.nih.nci.cagrid.introduce.beans.service.ServicesType;
import gov.nih.nci.cagrid.introduce.codegen.SyncTools;
import gov.nih.nci.cagrid.introduce.common.CommonTools;

import java.io.File;

import javax.xml.namespace.QName;

import com.atomicobject.haste.framework.Step;


public class AddServiceStep extends BaseStep {
	private TestCaseInfo tci;
	private File baseDir;

	public AddServiceStep(TestCaseInfo tci, boolean build) throws Exception {
		super(tci.getDir(),build);
		this.tci = tci;
	}


	public void runStep() throws Throwable {
		System.out.println("Adding a service.");

		ServiceDescription introService = (ServiceDescription) Utils.deserializeDocument(getBaseDir() + File.separator
			+ tci.getDir() + File.separator + "introduce.xml", ServiceDescription.class);
		ServicesType servicesType = introService.getServices();

		ServiceType service = new ServiceType();
		service.setName(tci.getName());
		service.setNamespace(tci.getNamespace());
		service.setPackageName(tci.getPackageName());
		service.setResourceFrameworkType(tci.getResourceFrameworkType());

		// add new service to array in bean
		// this seems to be a wierd way be adding things....
		ServiceType[] newMethods;
		int newLength = 0;
		if (servicesType!=null && servicesType.getService() != null) {
			newLength = servicesType.getService().length + 1;
			newMethods = new ServiceType[newLength];
			System.arraycopy(servicesType.getService(), 0, newMethods, 0, servicesType.getService().length);
		} else {
			newLength = 1;
			newMethods = new ServiceType[newLength];
		}
		ServicesType newservicesType = new ServicesType();
		newMethods[newLength - 1] = service;
		newservicesType.setService(newMethods);
		introService.setServices(newservicesType);

		Utils.serializeDocument(getBaseDir() + File.separator + tci.getDir() + File.separator + "introduce.xml",
			introService, new QName("gme://gov.nih.nci.cagrid/1/Introduce", "ServiceSkeleton"));

		try {
			SyncTools sync = new SyncTools(new File(getBaseDir() + File.separator + tci.getDir()));
			sync.sync();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	
		buildStep();
	}

}
