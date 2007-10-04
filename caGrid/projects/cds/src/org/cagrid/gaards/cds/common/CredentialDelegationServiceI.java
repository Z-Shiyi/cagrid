package org.cagrid.gaards.cds.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public interface CredentialDelegationServiceI {

  /**
   * Allows a party to initate the delegation of their credential such that other parties may access their credential to act on their behalf.
   *
   * @param policy
   * @param keyLength
   * @throws CDSInternalFault
   *	
   * @throws InvalidPolicyFault
   *	
   * @throws PermissionDeniedFault
   *	
   * @throws DelegationFault
   *	
   */
  public void delegateCredential(org.cagrid.gaards.cds.common.DelegationPolicy policy,int keyLength) throws RemoteException, org.cagrid.gaards.cds.stubs.types.CDSInternalFault, org.cagrid.gaards.cds.stubs.types.InvalidPolicyFault, org.cagrid.gaards.cds.stubs.types.PermissionDeniedFault, org.cagrid.gaards.cds.stubs.types.DelegationFault ;

}

