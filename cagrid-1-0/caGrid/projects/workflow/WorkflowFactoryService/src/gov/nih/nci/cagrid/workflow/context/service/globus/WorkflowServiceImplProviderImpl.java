package gov.nih.nci.cagrid.workflow.context.service.globus;

import gov.nih.nci.cagrid.workflow.context.service.WorkflowServiceImplImpl;

import java.rmi.RemoteException;

/** 
 *  DO NOT EDIT:  This class is autogenerated!
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class WorkflowServiceImplProviderImpl{
	
	WorkflowServiceImplImpl impl;
	
	public WorkflowServiceImplProviderImpl() throws RemoteException {
		impl = new WorkflowServiceImplImpl();
	}
	
	protected String getCallerIdentity() {
		String caller = org.globus.wsrf.security.SecurityManager.getManager().getCaller();
		if ((caller == null) || (caller.equals("<anonymous>"))) {
			return null;
		} else {
			return caller;
		}
	}
	

    public gov.nih.nci.cagrid.workflow.context.stubs.StartResponse start(gov.nih.nci.cagrid.workflow.context.stubs.StartRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.StartCalledOnStartedWorkflowFaultType {
    gov.nih.nci.cagrid.workflow.context.stubs.StartResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.StartResponse();
    boxedResult.setWorkflowStatusElement(impl.start(params.getStartInputElement().getStartInputElement()));
    return boxedResult;
  }

    public gov.nih.nci.cagrid.workflow.context.stubs.GetStatusResponse getStatus(gov.nih.nci.cagrid.workflow.context.stubs.GetStatusRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType {
    gov.nih.nci.cagrid.workflow.context.stubs.GetStatusResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.GetStatusResponse();
    boxedResult.setWorkflowStatusElement(impl.getStatus());
    return boxedResult;
  }

    public gov.nih.nci.cagrid.workflow.context.stubs.PauseResponse pause(gov.nih.nci.cagrid.workflow.context.stubs.PauseRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotPauseWorkflowFaultType {
    gov.nih.nci.cagrid.workflow.context.stubs.PauseResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.PauseResponse();
    boxedResult.setWorkflowStatusElement(impl.pause());
    return boxedResult;
  }

    public gov.nih.nci.cagrid.workflow.context.stubs.ResumeResponse resume(gov.nih.nci.cagrid.workflow.context.stubs.ResumeRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotResumeWorkflowFaultType {
    gov.nih.nci.cagrid.workflow.context.stubs.ResumeResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.ResumeResponse();
    boxedResult.setWorkflowStatusElement(impl.resume());
    return boxedResult;
  }

    public gov.nih.nci.cagrid.workflow.context.stubs.CancelResponse cancel(gov.nih.nci.cagrid.workflow.context.stubs.CancelRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotCancelWorkflowFaultType {
    gov.nih.nci.cagrid.workflow.context.stubs.CancelResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.CancelResponse();
    impl.cancel();
    return boxedResult;
  }

    public gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputResponse getWorkflowOutput(gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType {
    gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputResponse();
    boxedResult.setWorkflowOutputElement(impl.getWorkflowOutput());
    return boxedResult;
  }

    public gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusResponse getDetailedStatus(gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusRequest params) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType {
    gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusResponse boxedResult = new gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusResponse();
    boxedResult.setDetailedStatusOutputElement(impl.getDetailedStatus());
    return boxedResult;
  }

}
