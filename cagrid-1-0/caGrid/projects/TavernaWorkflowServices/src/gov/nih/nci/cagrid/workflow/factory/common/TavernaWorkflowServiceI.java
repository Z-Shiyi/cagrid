package gov.nih.nci.cagrid.workflow.factory.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface TavernaWorkflowServiceI {

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * Creates a resource to handle a workflow for a given scufl document.
   *
   * @param wMSInputElement
   * @throws WorkflowException
   *	
   */
  public workflowmanagementfactoryservice.WMSOutputType createWorkflow(workflowmanagementfactoryservice.WMSInputType wMSInputElement) throws RemoteException, gov.nih.nci.cagrid.workflow.factory.stubs.types.WorkflowException ;

}

