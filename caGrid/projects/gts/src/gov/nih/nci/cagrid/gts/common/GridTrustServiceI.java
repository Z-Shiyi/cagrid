package gov.nih.nci.cagrid.gts.common;

import java.rmi.RemoteException;


/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public interface GridTrustServiceI {






















































































































     public gov.nih.nci.cagrid.gts.bean.TrustedAuthority addTrustedAuthority(gov.nih.nci.cagrid.gts.bean.TrustedAuthority ta) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault ;
     public gov.nih.nci.cagrid.gts.bean.TrustedAuthority[] findTrustedAuthorities(gov.nih.nci.cagrid.gts.bean.TrustedAuthorityFilter f) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault ;
     public void removeTrustedAuthority(java.lang.String trustedAuthorityName) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault ;
     public void addPermission(gov.nih.nci.cagrid.gts.bean.Permission permission) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalPermissionFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault ;
     public gov.nih.nci.cagrid.gts.bean.Permission[] findPermissions(gov.nih.nci.cagrid.gts.bean.PermissionFilter f) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault ;
     public void revokePermission(gov.nih.nci.cagrid.gts.bean.Permission permission) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidPermissionFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault ;
     public void updateTrustedAuthority(gov.nih.nci.cagrid.gts.bean.TrustedAuthority ta) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault ;
     public void addTrustLevel() throws RemoteException, gov.nih.nci.cagrid.gts.stubs.IllegalTrustLevelFault ;
     public void updateTrustLevel() throws RemoteException, gov.nih.nci.cagrid.gts.stubs.InvalidTrustLevelFault ;
     public gov.nih.nci.cagrid.gts.bean.TrustLevel[] getTrustLevels() throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault ;

}
