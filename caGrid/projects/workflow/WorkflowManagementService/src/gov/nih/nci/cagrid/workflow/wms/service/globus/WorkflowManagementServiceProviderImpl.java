package gov.nih.nci.cagrid.workflow.wms.service.globus;

import gov.nih.nci.cagrid.workflow.wms.service.WorkflowManagementServiceImpl;

import java.rmi.RemoteException;

/** 
 *  DO NOT EDIT:  This class is autogenerated!
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class WorkflowManagementServiceProviderImpl{
	
	WorkflowManagementServiceImpl impl;
	
	public WorkflowManagementServiceProviderImpl() throws RemoteException {
		impl = new WorkflowManagementServiceImpl();
	}
	

	public gov.nih.nci.cagrid.workflow.wms.stubs.RunWorkflowResponse runWorkflow(gov.nih.nci.cagrid.workflow.wms.stubs.RunWorkflowRequest params) throws RemoteException {
		gov.nih.nci.cagrid.workflow.wms.stubs.RunWorkflowResponse boxedResult = new gov.nih.nci.cagrid.workflow.wms.stubs.RunWorkflowResponse();
		boxedResult.setWMSOutputElement(impl.runWorkflow(params.getWmsInput().getWMSInputElement()));
		return boxedResult;
	}

}
