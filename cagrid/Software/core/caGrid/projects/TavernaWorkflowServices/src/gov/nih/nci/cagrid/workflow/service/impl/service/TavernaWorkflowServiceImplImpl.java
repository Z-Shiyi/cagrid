package gov.nih.nci.cagrid.workflow.service.impl.service;

import gov.nih.nci.cagrid.workflow.service.impl.service.globus.resource.TavernaWorkflowServiceImplResource;

import java.rmi.RemoteException;

import org.globus.wsrf.InvalidResourceKeyException;
import org.globus.wsrf.NoResourceHomeException;
import org.globus.wsrf.NoSuchResourceException;
import org.globus.wsrf.RemoveNotSupportedException;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceHome;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.ResourceContextException;
import org.globus.wsrf.ResourceException;

//import src.gov.nih.nci.cagrid.workflow.context.service.ResourceContextException;
//import src.gov.nih.nci.cagrid.workflow.context.service.ResourceException;
//import src.gov.nih.nci.cagrid.workflow.context.service.WorkflowResource;

import workflowmanagementfactoryservice.WorkflowOutputType;
import workflowmanagementfactoryservice.WorkflowStatusType;

/** 
 * 
 * 
 * @created Sulakhe
 * 
 */
public class TavernaWorkflowServiceImplImpl extends TavernaWorkflowServiceImplImplBase {

	public TavernaWorkflowServiceImplImpl() throws RemoteException {
		super();
	}

	private TavernaWorkflowServiceImplResource getWorkflowResource() throws ResourceException, ResourceContextException {
		ResourceContext resourceContext = ResourceContext.getResourceContext();
		ResourceHome resourceHome = resourceContext.getResourceHome();
		ResourceKey resourceKey = resourceContext.getResourceKey();
		TavernaWorkflowServiceImplResource resource = (TavernaWorkflowServiceImplResource) resourceHome.find(resourceKey);
		return resource;
	}

  public void cancel() throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.CannotCancelWorkflowFault {
		//TODO: Implement this autogenerated method
		throw new RemoteException("Not yet implemented");
	}

  public workflowmanagementfactoryservice.WorkflowStatusEventType[] getDetailedStatus() throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.WorkflowException {
		//TODO: Implement this autogenerated method
		throw new RemoteException("Not yet implemented");
	}

  public workflowmanagementfactoryservice.WorkflowStatusType getStatus() throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.WorkflowException {
		return this.getWorkflowResource().getStatus();
	}

  public workflowmanagementfactoryservice.WorkflowOutputType getWorkflowOutput() throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.WorkflowException {

		return this.getWorkflowResource().getWorkflowOutput();
	}

  public workflowmanagementfactoryservice.WorkflowStatusType pause() throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.WorkflowException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.CannotPauseWorkflowFault {
		//TODO: Implement this autogenerated method
		throw new RemoteException("Not yet implemented");
	}

  public workflowmanagementfactoryservice.WorkflowStatusType resume() throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.WorkflowException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.CannotResumeWorkflowFault {
		//TODO: Implement this autogenerated method
		throw new RemoteException("Not yet implemented");
	}

  public workflowmanagementfactoryservice.WorkflowStatusType start(workflowmanagementfactoryservice.StartInputType startInputElement) throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.CannotStartWorkflowFault {
		return this.getWorkflowResource().start(startInputElement);
	}

  public workflowmanagementfactoryservice.WorkflowStatusType startWorkflow(workflowmanagementfactoryservice.StartInputType startInputElement) throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.CannotStartWorkflowFault {
		return this.getWorkflowResource().start(startInputElement);
	  }

  public void setDelegatedCredential(org.cagrid.gaards.cds.delegated.stubs.types.DelegatedCredentialReference delegatedCredentialReference) throws RemoteException, gov.nih.nci.cagrid.workflow.service.impl.stubs.types.CannotSetCredential {
		this.getWorkflowResource().setDelegatedCredential(delegatedCredentialReference);
	}

  public org.cagrid.transfer.context.stubs.types.TransferServiceContextReference putInputData(java.lang.String filename) throws RemoteException {
		return this.getWorkflowResource().putInputData(filename);
	}

  public org.cagrid.transfer.context.stubs.types.TransferServiceContextReference getOutputData() throws RemoteException {
		return this.getWorkflowResource().getOutputData();
	}
	// remove can be used along with Cancel operation (once implemented). The remove operations destroys a resource.
	// Currently, setTerminationTime can be used to destroy it.
	public boolean remove() {
		try {

			ResourceContext.getResourceContext().getResourceHome().remove( ResourceContext.getResourceContext().getResourceKey());

		} catch (NoSuchResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvalidResourceKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (RemoveNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NoResourceHomeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ResourceContextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;	

	}

}

