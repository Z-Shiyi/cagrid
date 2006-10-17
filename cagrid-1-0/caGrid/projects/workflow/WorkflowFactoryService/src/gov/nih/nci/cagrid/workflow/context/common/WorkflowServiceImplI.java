package gov.nih.nci.cagrid.workflow.context.common;

import gov.nih.nci.cagrid.workflow.stubs.types.StartInputType;
import gov.nih.nci.cagrid.workflow.stubs.types.WorkflowOutputType;
import gov.nih.nci.cagrid.workflow.stubs.types.WorkflowStatusType;

import java.rmi.RemoteException;

/** 
 *   This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public interface WorkflowServiceImplI {

    public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException ;

    public WorkflowStatusType start(StartInputType startInputElement) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.StartCalledOnStartedWorkflowFaultType ;

    public WorkflowStatusType getStatus() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType ;

    public WorkflowStatusType pause() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotPauseWorkflowFaultType ;

    public WorkflowStatusType resume() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotResumeWorkflowFaultType ;

    public void cancel() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotCancelWorkflowFaultType ;

    public WorkflowOutputType getWorkflowOutput() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowExceptionType ;

}

