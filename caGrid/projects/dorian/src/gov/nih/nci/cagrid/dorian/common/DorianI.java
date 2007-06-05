package gov.nih.nci.cagrid.dorian.common;

import java.rmi.RemoteException;

/** 
 *   This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public interface DorianI {

    public gov.nih.nci.cagrid.dorian.ifs.bean.HostCertificateRecord[] getOwnedHostCertificates() throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException ;

    public java.lang.String registerWithIdP(gov.nih.nci.cagrid.dorian.idp.bean.Application application) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidUserPropertyFault ;

    public gov.nih.nci.cagrid.dorian.idp.bean.IdPUser[] findIdPUsers(gov.nih.nci.cagrid.dorian.idp.bean.IdPUserFilter filter) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void updateIdPUser(gov.nih.nci.cagrid.dorian.idp.bean.IdPUser user) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.NoSuchUserFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void removeIdPUser(java.lang.String userId) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.bean.SAMLAssertion authenticateWithIdP(gov.nih.nci.cagrid.dorian.idp.bean.BasicAuthCredential cred) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.bean.X509Certificate[] createProxy(gov.nih.nci.cagrid.dorian.bean.SAMLAssertion saml,gov.nih.nci.cagrid.dorian.ifs.bean.PublicKey publicKey,gov.nih.nci.cagrid.dorian.ifs.bean.ProxyLifetime lifetime,gov.nih.nci.cagrid.dorian.ifs.bean.DelegationPathLength delegation) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidAssertionFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidProxyFault, gov.nih.nci.cagrid.dorian.stubs.types.UserPolicyFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.bean.X509Certificate getCACertificate() throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault ;

    public gov.nih.nci.cagrid.dorian.ifs.bean.TrustedIdP[] getTrustedIdPs() throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.ifs.bean.TrustedIdP addTrustedIdP(gov.nih.nci.cagrid.dorian.ifs.bean.TrustedIdP idp) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidTrustedIdPFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void updateTrustedIdP(gov.nih.nci.cagrid.dorian.ifs.bean.TrustedIdP trustedIdP) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidTrustedIdPFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void removeTrustedIdP(gov.nih.nci.cagrid.dorian.ifs.bean.TrustedIdP trustedIdP) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidTrustedIdPFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.ifs.bean.IFSUser[] findIFSUsers(gov.nih.nci.cagrid.dorian.ifs.bean.IFSUserFilter filter) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void updateIFSUser(gov.nih.nci.cagrid.dorian.ifs.bean.IFSUser user) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidUserFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void removeIFSUser(gov.nih.nci.cagrid.dorian.ifs.bean.IFSUser user) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidUserFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.ifs.bean.IFSUser renewIFSUserCredentials(gov.nih.nci.cagrid.dorian.ifs.bean.IFSUser user) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidUserFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.ifs.bean.IFSUserPolicy[] getIFSUserPolicies() throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.authentication.bean.SAMLAssertion authenticate(gov.nih.nci.cagrid.authentication.bean.Credential credential) throws RemoteException, gov.nih.nci.cagrid.authentication.stubs.types.InvalidCredentialFault, gov.nih.nci.cagrid.authentication.stubs.types.InsufficientAttributeFault, gov.nih.nci.cagrid.authentication.stubs.types.AuthenticationProviderFault ;

    public void addAdmin(java.lang.String gridIdentity) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public void removeAdmin(java.lang.String gridIdentity) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public java.lang.String[] getAdmins() throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

    public gov.nih.nci.cagrid.dorian.ifs.bean.HostCertificateRecord requestHostCertificate(gov.nih.nci.cagrid.dorian.ifs.bean.HostCertificateRequest req) throws RemoteException, gov.nih.nci.cagrid.dorian.stubs.types.DorianInternalFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidHostCertificateRequestFault, gov.nih.nci.cagrid.dorian.stubs.types.InvalidHostCertificateFault, gov.nih.nci.cagrid.dorian.stubs.types.PermissionDeniedFault ;

}

