package gov.nih.nci.cagrid.fqp.results.common;

import java.rmi.RemoteException;

/**
 * The resource-qualified results service
 *
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface FederatedQueryResultsI {

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException ;

  public org.oasis.wsn.SubscribeResponse subscribe(org.oasis.wsn.Subscribe params) throws RemoteException ;

  /**
   * Returns the results of the query managed by this resource
   *
   * @throws ProcessingNotCompleteFault
   *	Indicates the query has not yet completed.
   * @throws FederatedQueryProcessingFault
   *	Indicates an error occured processing the query.
   * @throws InternalErrorFault
   *	Indicates an unrecoverable internal error.
   */
  public gov.nih.nci.cagrid.dcqlresult.DCQLQueryResultsCollection getResults() throws RemoteException, gov.nih.nci.cagrid.fqp.results.stubs.types.ProcessingNotCompleteFault, gov.nih.nci.cagrid.fqp.stubs.types.FederatedQueryProcessingFault, gov.nih.nci.cagrid.fqp.results.stubs.types.InternalErrorFault ;

  /**
   * Indicates whether or not the query processing is complete; until this is true, any results retrieval methods will fail.
   *
   */
  public boolean isProcessingComplete() throws RemoteException ;

  /**
   * Gets the results of the DCQL query aggregated as a single CQL query result.
   *
   * @throws FederatedQueryProcessingFault
   *	Indicates an error occured processing the query.
   * @throws ProcessingNotCompleteFault
   *	Indicates the query has not yet completed.
   * @throws InternalErrorFault
   *	Indicates an unrecoverable internal error.
   */
  public gov.nih.nci.cagrid.cqlresultset.CQLQueryResults getAggregateResults() throws RemoteException, gov.nih.nci.cagrid.fqp.stubs.types.FederatedQueryProcessingFault, gov.nih.nci.cagrid.fqp.results.stubs.types.ProcessingNotCompleteFault, gov.nih.nci.cagrid.fqp.results.stubs.types.InternalErrorFault ;

  /**
   * Creates a WS-Enumeration resource for retrieving the query results and returns a reference to them.
   *
   * @throws FederatedQueryProcessingFault
   *	Indicates an error occured processing the query.
   * @throws ProcessingNotCompleteFault
   *	Indicates the query has not yet completed.
   * @throws InternalErrorFault
   *	Indicates an unrecoverable internal error.
   */
  public gov.nih.nci.cagrid.enumeration.stubs.response.EnumerationResponseContainer enumerate() throws RemoteException, gov.nih.nci.cagrid.fqp.stubs.types.FederatedQueryProcessingFault, gov.nih.nci.cagrid.fqp.results.stubs.types.ProcessingNotCompleteFault, gov.nih.nci.cagrid.fqp.results.stubs.types.InternalErrorFault ;

  /**
   * Creates a caGrid Transfer resource for retrieving the results and returns a reference to them.
   *
   * @throws FederatedQueryProcessingFault
   *	Indicates an error occured processing the query.
   * @throws ProcessingNotCompleteFault
   *	Indicates the query has not yet completed.
   * @throws InternalErrorFault
   *	Indicates an unrecoverable internal error.
   */
  public org.cagrid.transfer.context.stubs.types.TransferServiceContextReference transfer() throws RemoteException, gov.nih.nci.cagrid.fqp.stubs.types.FederatedQueryProcessingFault, gov.nih.nci.cagrid.fqp.results.stubs.types.ProcessingNotCompleteFault, gov.nih.nci.cagrid.fqp.results.stubs.types.InternalErrorFault ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * Gets the current federated query execution status.
   *
   */
  public org.cagrid.fqp.results.metadata.FederatedQueryExecutionStatus getExecutionStatus() throws RemoteException ;

}

