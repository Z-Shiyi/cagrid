package gov.nih.nci.cagrid.workflow.factory.service;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.workflow.service.impl.service.globus.resource.TavernaWorkflowServiceImplResource;
import gov.nih.nci.cagrid.workflow.service.impl.service.globus.resource.TavernaWorkflowServiceImplResourceHome;

import org.apache.axis.message.addressing.EndpointReferenceType;
import org.globus.wsrf.Constants;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.container.ServiceHost;
import org.globus.wsrf.utils.AddressingUtils;

import workflowmanagementfactoryservice.WMSOutputType;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class TavernaWorkflowServiceImpl extends TavernaWorkflowServiceImplBase {

	public TavernaWorkflowServiceImpl() throws RemoteException {
		super();
	}

  public workflowmanagementfactoryservice.WMSOutputType createWorkflow(workflowmanagementfactoryservice.WMSInputType wMSInputElement) throws RemoteException, gov.nih.nci.cagrid.workflow.factory.stubs.types.WorkflowException {

	  TavernaWorkflowServiceImplResourceHome home = null;
		ResourceKey key = null;
		try {
			Context ctx = new InitialContext();
			String lookupString = Constants.JNDI_SERVICES_BASE_NAME +
			"cagrid/TavernaWorkflowServiceImpl"+ "/home";
			home = (TavernaWorkflowServiceImplResourceHome) ctx.lookup(lookupString);

			key = home.createResource();

			TavernaWorkflowServiceImplResource workflowResource = home.getResource(key);

			EndpointReferenceType epr = AddressingUtils.createEndpointReference(ServiceHost
					.getBaseURL() + "cagrid/TavernaWorkflowServiceImpl", key);
			//System.out.println("EPR :" + epr.getAddress().toString());
			
			workflowResource.createWorkflow(wMSInputElement);
			WMSOutputType wMSOutputElement = new WMSOutputType();
			wMSOutputElement.setWorkflowEPR(epr);
			return wMSOutputElement;
			
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return null;  }

}

