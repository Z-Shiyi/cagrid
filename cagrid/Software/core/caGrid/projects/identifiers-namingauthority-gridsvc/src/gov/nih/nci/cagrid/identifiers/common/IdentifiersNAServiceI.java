package gov.nih.nci.cagrid.identifiers.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public interface IdentifiersNAServiceI {

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * Creates a new identifier using the provided metadata (IdentifierValues)
   *
   * @param identifierValues
   * @throws NamingAuthorityConfigurationFault
   *	
   * @throws InvalidIdentifierValuesFault
   *	
   */
  public org.apache.axis.types.URI createIdentifier(namingauthority.IdentifierValues identifierValues) throws RemoteException, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthorityConfigurationFault, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierValuesFault ;

  /**
   * Returns metadata (IdentifierValues) associated with the provided identifier
   *
   * @param identifier
   * @throws NamingAuthorityConfigurationFault
   *	
   * @throws InvalidIdentifierFault
   *	
   */
  public namingauthority.IdentifierValues resolveIdentifier(org.apache.axis.types.URI identifier) throws RemoteException, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthorityConfigurationFault, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierFault ;

  /**
   * Deletes keys from an identifier
   *
   * @param identifier
   *	The identifier to be modified
   * @param keyList
   *	List of key names to be deleted from the identifier
   * @throws InvalidIdentifierFault
   *	
   * @throws NamingAuthorityConfigurationFault
   *	
   * @throws NamingAuthoritySecurityFault
   *	
   * @throws InvalidIdentifierValuesFault
   *	
   */
  public void deleteKeys(org.apache.axis.types.URI identifier,java.lang.String[] keyList) throws RemoteException, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthorityConfigurationFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthoritySecurityFault, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierValuesFault ;

  /**
   * Creates new keys on an existing identifier
   *
   * @param identifier
   * @param identifierValues
   * @throws InvalidIdentifierFault
   *	
   * @throws NamingAuthorityConfigurationFault
   *	
   * @throws NamingAuthoritySecurityFault
   *	
   * @throws InvalidIdentifierValuesFault
   *	
   */
  public void createKeys(org.apache.axis.types.URI identifier,namingauthority.IdentifierValues identifierValues) throws RemoteException, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthorityConfigurationFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthoritySecurityFault, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierValuesFault ;

  /**
   * Replaces the values associated with the specified keys on an existing identifier
   *
   * @param identifier
   * @param identifierValues
   * @throws InvalidIdentifierFault
   *	
   * @throws NamingAuthorityConfigurationFault
   *	
   * @throws NamingAuthoritySecurityFault
   *	
   * @throws InvalidIdentifierValuesFault
   *	
   */
  public void replaceKeys(org.apache.axis.types.URI identifier,namingauthority.IdentifierValues identifierValues) throws RemoteException, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthorityConfigurationFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthoritySecurityFault, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierValuesFault ;

  /**
   * Deletes all keys (except admin keys) on an existing identifier
   *
   * @param identifier
   * @throws InvalidIdentifierFault
   *	
   * @throws NamingAuthorityConfigurationFault
   *	
   * @throws NamingAuthoritySecurityFault
   *	
   */
  public void deleteAllKeys(org.apache.axis.types.URI identifier) throws RemoteException, gov.nih.nci.cagrid.identifiers.stubs.types.InvalidIdentifierFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthorityConfigurationFault, gov.nih.nci.cagrid.identifiers.stubs.types.NamingAuthoritySecurityFault ;

}

