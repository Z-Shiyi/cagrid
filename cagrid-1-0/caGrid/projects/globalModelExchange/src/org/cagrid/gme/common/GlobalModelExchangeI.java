package org.cagrid.gme.common;

import java.rmi.RemoteException;

/**
 * The Global Model Exchange (GME) acts as an authoritative source
 *         for XML Schemas, providing a robust type management system for
 *         use in Grids and other XML-based environments.
 *
 * This class is autogenerated, DO NOT EDIT.
 * This interface represents the API
 * which is accessable on the grid service from the client.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public interface GlobalModelExchangeI {

    public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata()
        throws RemoteException;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

}
