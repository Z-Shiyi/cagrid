package org.cagrid.gaards.dorian.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.cagrid.gaards.dorian.stubs.DorianPortType;
import org.cagrid.gaards.dorian.stubs.service.DorianServiceAddressingLocator;
import org.cagrid.gaards.dorian.common.DorianI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.3
 */
public class DorianClient extends DorianClientBase implements DorianI {	

	public DorianClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public DorianClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public DorianClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public DorianClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(DorianClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  DorianClient client = new DorianClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

  public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getServiceSecurityMetadata");
    gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest params = new gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest();
    gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataResponse boxedResult = portType.getServiceSecurityMetadata(params);
    return boxedResult.getServiceSecurityMetadata();
    }
  }

  public java.lang.String registerWithIdP(org.cagrid.gaards.dorian.idp.Application application) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserPropertyFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"registerWithIdP");
    org.cagrid.gaards.dorian.stubs.RegisterWithIdPRequest params = new org.cagrid.gaards.dorian.stubs.RegisterWithIdPRequest();
    org.cagrid.gaards.dorian.stubs.RegisterWithIdPRequestApplication applicationContainer = new org.cagrid.gaards.dorian.stubs.RegisterWithIdPRequestApplication();
    applicationContainer.setApplication(application);
    params.setApplication(applicationContainer);
    org.cagrid.gaards.dorian.stubs.RegisterWithIdPResponse boxedResult = portType.registerWithIdP(params);
    return boxedResult.getResponse();
    }
  }

  public org.cagrid.gaards.dorian.idp.LocalUser[] findLocalUsers(org.cagrid.gaards.dorian.idp.LocalUserFilter f) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"findLocalUsers");
    org.cagrid.gaards.dorian.stubs.FindLocalUsersRequest params = new org.cagrid.gaards.dorian.stubs.FindLocalUsersRequest();
    org.cagrid.gaards.dorian.stubs.FindLocalUsersRequestF fContainer = new org.cagrid.gaards.dorian.stubs.FindLocalUsersRequestF();
    fContainer.setLocalUserFilter(f);
    params.setF(fContainer);
    org.cagrid.gaards.dorian.stubs.FindLocalUsersResponse boxedResult = portType.findLocalUsers(params);
    return boxedResult.getLocalUser();
    }
  }

  public void updateLocalUser(org.cagrid.gaards.dorian.idp.LocalUser user) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.NoSuchUserFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"updateLocalUser");
    org.cagrid.gaards.dorian.stubs.UpdateLocalUserRequest params = new org.cagrid.gaards.dorian.stubs.UpdateLocalUserRequest();
    org.cagrid.gaards.dorian.stubs.UpdateLocalUserRequestUser userContainer = new org.cagrid.gaards.dorian.stubs.UpdateLocalUserRequestUser();
    userContainer.setLocalUser(user);
    params.setUser(userContainer);
    org.cagrid.gaards.dorian.stubs.UpdateLocalUserResponse boxedResult = portType.updateLocalUser(params);
    }
  }

  public void removeLocalUser(java.lang.String userId) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"removeLocalUser");
    org.cagrid.gaards.dorian.stubs.RemoveLocalUserRequest params = new org.cagrid.gaards.dorian.stubs.RemoveLocalUserRequest();
    params.setUserId(userId);
    org.cagrid.gaards.dorian.stubs.RemoveLocalUserResponse boxedResult = portType.removeLocalUser(params);
    }
  }

  public org.cagrid.gaards.dorian.X509Certificate[] createProxy(org.cagrid.gaards.dorian.SAMLAssertion saml,org.cagrid.gaards.dorian.federation.PublicKey publicKey,org.cagrid.gaards.dorian.federation.ProxyLifetime lifetime,org.cagrid.gaards.dorian.federation.DelegationPathLength delegation) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidAssertionFault, org.cagrid.gaards.dorian.stubs.types.InvalidProxyFault, org.cagrid.gaards.dorian.stubs.types.UserPolicyFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"createProxy");
    org.cagrid.gaards.dorian.stubs.CreateProxyRequest params = new org.cagrid.gaards.dorian.stubs.CreateProxyRequest();
    org.cagrid.gaards.dorian.stubs.CreateProxyRequestSaml samlContainer = new org.cagrid.gaards.dorian.stubs.CreateProxyRequestSaml();
    samlContainer.setSAMLAssertion(saml);
    params.setSaml(samlContainer);
    org.cagrid.gaards.dorian.stubs.CreateProxyRequestPublicKey publicKeyContainer = new org.cagrid.gaards.dorian.stubs.CreateProxyRequestPublicKey();
    publicKeyContainer.setPublicKey(publicKey);
    params.setPublicKey(publicKeyContainer);
    org.cagrid.gaards.dorian.stubs.CreateProxyRequestLifetime lifetimeContainer = new org.cagrid.gaards.dorian.stubs.CreateProxyRequestLifetime();
    lifetimeContainer.setProxyLifetime(lifetime);
    params.setLifetime(lifetimeContainer);
    org.cagrid.gaards.dorian.stubs.CreateProxyRequestDelegation delegationContainer = new org.cagrid.gaards.dorian.stubs.CreateProxyRequestDelegation();
    delegationContainer.setDelegationPathLength(delegation);
    params.setDelegation(delegationContainer);
    org.cagrid.gaards.dorian.stubs.CreateProxyResponse boxedResult = portType.createProxy(params);
    return boxedResult.getX509Certificate();
    }
  }

  public org.cagrid.gaards.dorian.X509Certificate getCACertificate() throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getCACertificate");
    org.cagrid.gaards.dorian.stubs.GetCACertificateRequest params = new org.cagrid.gaards.dorian.stubs.GetCACertificateRequest();
    org.cagrid.gaards.dorian.stubs.GetCACertificateResponse boxedResult = portType.getCACertificate(params);
    return boxedResult.getX509Certificate();
    }
  }

  public org.cagrid.gaards.dorian.federation.TrustedIdP[] getTrustedIdPs() throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getTrustedIdPs");
    org.cagrid.gaards.dorian.stubs.GetTrustedIdPsRequest params = new org.cagrid.gaards.dorian.stubs.GetTrustedIdPsRequest();
    org.cagrid.gaards.dorian.stubs.GetTrustedIdPsResponse boxedResult = portType.getTrustedIdPs(params);
    return boxedResult.getTrustedIdP();
    }
  }

  public org.cagrid.gaards.dorian.federation.TrustedIdP addTrustedIdP(org.cagrid.gaards.dorian.federation.TrustedIdP idp) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidTrustedIdPFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"addTrustedIdP");
    org.cagrid.gaards.dorian.stubs.AddTrustedIdPRequest params = new org.cagrid.gaards.dorian.stubs.AddTrustedIdPRequest();
    org.cagrid.gaards.dorian.stubs.AddTrustedIdPRequestIdp idpContainer = new org.cagrid.gaards.dorian.stubs.AddTrustedIdPRequestIdp();
    idpContainer.setTrustedIdP(idp);
    params.setIdp(idpContainer);
    org.cagrid.gaards.dorian.stubs.AddTrustedIdPResponse boxedResult = portType.addTrustedIdP(params);
    return boxedResult.getTrustedIdP();
    }
  }

  public void updateTrustedIdP(org.cagrid.gaards.dorian.federation.TrustedIdP trustedIdP) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidTrustedIdPFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"updateTrustedIdP");
    org.cagrid.gaards.dorian.stubs.UpdateTrustedIdPRequest params = new org.cagrid.gaards.dorian.stubs.UpdateTrustedIdPRequest();
    org.cagrid.gaards.dorian.stubs.UpdateTrustedIdPRequestTrustedIdP trustedIdPContainer = new org.cagrid.gaards.dorian.stubs.UpdateTrustedIdPRequestTrustedIdP();
    trustedIdPContainer.setTrustedIdP(trustedIdP);
    params.setTrustedIdP(trustedIdPContainer);
    org.cagrid.gaards.dorian.stubs.UpdateTrustedIdPResponse boxedResult = portType.updateTrustedIdP(params);
    }
  }

  public void removeTrustedIdP(org.cagrid.gaards.dorian.federation.TrustedIdP trustedIdP) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidTrustedIdPFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"removeTrustedIdP");
    org.cagrid.gaards.dorian.stubs.RemoveTrustedIdPRequest params = new org.cagrid.gaards.dorian.stubs.RemoveTrustedIdPRequest();
    org.cagrid.gaards.dorian.stubs.RemoveTrustedIdPRequestTrustedIdP trustedIdPContainer = new org.cagrid.gaards.dorian.stubs.RemoveTrustedIdPRequestTrustedIdP();
    trustedIdPContainer.setTrustedIdP(trustedIdP);
    params.setTrustedIdP(trustedIdPContainer);
    org.cagrid.gaards.dorian.stubs.RemoveTrustedIdPResponse boxedResult = portType.removeTrustedIdP(params);
    }
  }

  public org.cagrid.gaards.dorian.federation.GridUser[] findGridUsers(org.cagrid.gaards.dorian.federation.GridUserFilter filter) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"findGridUsers");
    org.cagrid.gaards.dorian.stubs.FindGridUsersRequest params = new org.cagrid.gaards.dorian.stubs.FindGridUsersRequest();
    org.cagrid.gaards.dorian.stubs.FindGridUsersRequestFilter filterContainer = new org.cagrid.gaards.dorian.stubs.FindGridUsersRequestFilter();
    filterContainer.setGridUserFilter(filter);
    params.setFilter(filterContainer);
    org.cagrid.gaards.dorian.stubs.FindGridUsersResponse boxedResult = portType.findGridUsers(params);
    return boxedResult.getGridUser();
    }
  }

  public void updateGridUser(org.cagrid.gaards.dorian.federation.GridUser user) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"updateGridUser");
    org.cagrid.gaards.dorian.stubs.UpdateGridUserRequest params = new org.cagrid.gaards.dorian.stubs.UpdateGridUserRequest();
    org.cagrid.gaards.dorian.stubs.UpdateGridUserRequestUser userContainer = new org.cagrid.gaards.dorian.stubs.UpdateGridUserRequestUser();
    userContainer.setGridUser(user);
    params.setUser(userContainer);
    org.cagrid.gaards.dorian.stubs.UpdateGridUserResponse boxedResult = portType.updateGridUser(params);
    }
  }

  public void removeGridUser(org.cagrid.gaards.dorian.federation.GridUser user) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"removeGridUser");
    org.cagrid.gaards.dorian.stubs.RemoveGridUserRequest params = new org.cagrid.gaards.dorian.stubs.RemoveGridUserRequest();
    org.cagrid.gaards.dorian.stubs.RemoveGridUserRequestUser userContainer = new org.cagrid.gaards.dorian.stubs.RemoveGridUserRequestUser();
    userContainer.setGridUser(user);
    params.setUser(userContainer);
    org.cagrid.gaards.dorian.stubs.RemoveGridUserResponse boxedResult = portType.removeGridUser(params);
    }
  }

  public org.cagrid.gaards.dorian.federation.GridUserPolicy[] getGridUserPolicies() throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getGridUserPolicies");
    org.cagrid.gaards.dorian.stubs.GetGridUserPoliciesRequest params = new org.cagrid.gaards.dorian.stubs.GetGridUserPoliciesRequest();
    org.cagrid.gaards.dorian.stubs.GetGridUserPoliciesResponse boxedResult = portType.getGridUserPolicies(params);
    return boxedResult.getGridUserPolicy();
    }
  }

  public gov.nih.nci.cagrid.authentication.bean.SAMLAssertion authenticate(gov.nih.nci.cagrid.authentication.bean.Credential credential) throws RemoteException, gov.nih.nci.cagrid.authentication.stubs.types.InvalidCredentialFault, gov.nih.nci.cagrid.authentication.stubs.types.InsufficientAttributeFault, gov.nih.nci.cagrid.authentication.stubs.types.AuthenticationProviderFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"authenticate");
    gov.nih.nci.cagrid.authentication.AuthenticateRequest params = new gov.nih.nci.cagrid.authentication.AuthenticateRequest();
    gov.nih.nci.cagrid.authentication.AuthenticateRequestCredential credentialContainer = new gov.nih.nci.cagrid.authentication.AuthenticateRequestCredential();
    credentialContainer.setCredential(credential);
    params.setCredential(credentialContainer);
    gov.nih.nci.cagrid.authentication.AuthenticateResponse boxedResult = portType.authenticate(params);
    return boxedResult.getSAMLAssertion();
    }
  }

  public gov.nih.nci.cagrid.opensaml.SAMLAssertion authenticateUser(org.cagrid.gaards.authentication.Credential credential) throws RemoteException, org.cagrid.gaards.authentication.faults.AuthenticationProviderFault, org.cagrid.gaards.authentication.faults.CredentialNotSupportedFault, org.cagrid.gaards.authentication.faults.InsufficientAttributeFault, org.cagrid.gaards.authentication.faults.InvalidCredentialFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"authenticateUser");
    org.cagrid.gaards.authentication.stubs.AuthenticateUserRequest params = new org.cagrid.gaards.authentication.stubs.AuthenticateUserRequest();
    org.cagrid.gaards.authentication.stubs.AuthenticateUserRequestCredential credentialContainer = new org.cagrid.gaards.authentication.stubs.AuthenticateUserRequestCredential();
    credentialContainer.setCredential(credential);
    params.setCredential(credentialContainer);
    org.cagrid.gaards.authentication.stubs.AuthenticateUserResponse boxedResult = portType.authenticateUser(params);
    return boxedResult.getAssertion();
    }
  }

  public void addAdmin(java.lang.String gridIdentity) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"addAdmin");
    org.cagrid.gaards.dorian.stubs.AddAdminRequest params = new org.cagrid.gaards.dorian.stubs.AddAdminRequest();
    params.setGridIdentity(gridIdentity);
    org.cagrid.gaards.dorian.stubs.AddAdminResponse boxedResult = portType.addAdmin(params);
    }
  }

  public void removeAdmin(java.lang.String gridIdentity) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"removeAdmin");
    org.cagrid.gaards.dorian.stubs.RemoveAdminRequest params = new org.cagrid.gaards.dorian.stubs.RemoveAdminRequest();
    params.setGridIdentity(gridIdentity);
    org.cagrid.gaards.dorian.stubs.RemoveAdminResponse boxedResult = portType.removeAdmin(params);
    }
  }

  public java.lang.String[] getAdmins() throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getAdmins");
    org.cagrid.gaards.dorian.stubs.GetAdminsRequest params = new org.cagrid.gaards.dorian.stubs.GetAdminsRequest();
    org.cagrid.gaards.dorian.stubs.GetAdminsResponse boxedResult = portType.getAdmins(params);
    return boxedResult.getResponse();
    }
  }

  public org.cagrid.gaards.dorian.federation.HostCertificateRecord requestHostCertificate(org.cagrid.gaards.dorian.federation.HostCertificateRequest req) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidHostCertificateRequestFault, org.cagrid.gaards.dorian.stubs.types.InvalidHostCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"requestHostCertificate");
    org.cagrid.gaards.dorian.stubs.RequestHostCertificateRequest params = new org.cagrid.gaards.dorian.stubs.RequestHostCertificateRequest();
    org.cagrid.gaards.dorian.stubs.RequestHostCertificateRequestReq reqContainer = new org.cagrid.gaards.dorian.stubs.RequestHostCertificateRequestReq();
    reqContainer.setHostCertificateRequest(req);
    params.setReq(reqContainer);
    org.cagrid.gaards.dorian.stubs.RequestHostCertificateResponse boxedResult = portType.requestHostCertificate(params);
    return boxedResult.getHostCertificateRecord();
    }
  }

  public org.cagrid.gaards.dorian.federation.HostCertificateRecord[] getOwnedHostCertificates() throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getOwnedHostCertificates");
    org.cagrid.gaards.dorian.stubs.GetOwnedHostCertificatesRequest params = new org.cagrid.gaards.dorian.stubs.GetOwnedHostCertificatesRequest();
    org.cagrid.gaards.dorian.stubs.GetOwnedHostCertificatesResponse boxedResult = portType.getOwnedHostCertificates(params);
    return boxedResult.getHostCertificateRecord();
    }
  }

  public org.cagrid.gaards.dorian.federation.HostCertificateRecord approveHostCertificate(java.math.BigInteger recordId) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidHostCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"approveHostCertificate");
    org.cagrid.gaards.dorian.stubs.ApproveHostCertificateRequest params = new org.cagrid.gaards.dorian.stubs.ApproveHostCertificateRequest();
    params.setRecordId(recordId);
    org.cagrid.gaards.dorian.stubs.ApproveHostCertificateResponse boxedResult = portType.approveHostCertificate(params);
    return boxedResult.getHostCertificateRecord();
    }
  }

  public org.cagrid.gaards.dorian.federation.HostCertificateRecord[] findHostCertificates(org.cagrid.gaards.dorian.federation.HostCertificateFilter hostCertificateFilter) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"findHostCertificates");
    org.cagrid.gaards.dorian.stubs.FindHostCertificatesRequest params = new org.cagrid.gaards.dorian.stubs.FindHostCertificatesRequest();
    org.cagrid.gaards.dorian.stubs.FindHostCertificatesRequestHostCertificateFilter hostCertificateFilterContainer = new org.cagrid.gaards.dorian.stubs.FindHostCertificatesRequestHostCertificateFilter();
    hostCertificateFilterContainer.setHostCertificateFilter(hostCertificateFilter);
    params.setHostCertificateFilter(hostCertificateFilterContainer);
    org.cagrid.gaards.dorian.stubs.FindHostCertificatesResponse boxedResult = portType.findHostCertificates(params);
    return boxedResult.getHostCertificateRecord();
    }
  }

  public void updateHostCertificateRecord(org.cagrid.gaards.dorian.federation.HostCertificateUpdate hostCertificateUpdate) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidHostCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"updateHostCertificateRecord");
    org.cagrid.gaards.dorian.stubs.UpdateHostCertificateRecordRequest params = new org.cagrid.gaards.dorian.stubs.UpdateHostCertificateRecordRequest();
    org.cagrid.gaards.dorian.stubs.UpdateHostCertificateRecordRequestHostCertificateUpdate hostCertificateUpdateContainer = new org.cagrid.gaards.dorian.stubs.UpdateHostCertificateRecordRequestHostCertificateUpdate();
    hostCertificateUpdateContainer.setHostCertificateUpdate(hostCertificateUpdate);
    params.setHostCertificateUpdate(hostCertificateUpdateContainer);
    org.cagrid.gaards.dorian.stubs.UpdateHostCertificateRecordResponse boxedResult = portType.updateHostCertificateRecord(params);
    }
  }

  public org.cagrid.gaards.dorian.federation.HostCertificateRecord renewHostCertificate(java.math.BigInteger recordId) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidHostCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"renewHostCertificate");
    org.cagrid.gaards.dorian.stubs.RenewHostCertificateRequest params = new org.cagrid.gaards.dorian.stubs.RenewHostCertificateRequest();
    params.setRecordId(recordId);
    org.cagrid.gaards.dorian.stubs.RenewHostCertificateResponse boxedResult = portType.renewHostCertificate(params);
    return boxedResult.getHostCertificateRecord();
    }
  }

  public void changeIdPUserPassword(org.cagrid.gaards.dorian.idp.BasicAuthCredential credential,java.lang.String newPassword) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserPropertyFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"changeIdPUserPassword");
    org.cagrid.gaards.dorian.stubs.ChangeIdPUserPasswordRequest params = new org.cagrid.gaards.dorian.stubs.ChangeIdPUserPasswordRequest();
    org.cagrid.gaards.dorian.stubs.ChangeIdPUserPasswordRequestCredential credentialContainer = new org.cagrid.gaards.dorian.stubs.ChangeIdPUserPasswordRequestCredential();
    credentialContainer.setBasicAuthCredential(credential);
    params.setCredential(credentialContainer);
    params.setNewPassword(newPassword);
    org.cagrid.gaards.dorian.stubs.ChangeIdPUserPasswordResponse boxedResult = portType.changeIdPUserPassword(params);
    }
  }

  public boolean doesLocalUserExist(java.lang.String userId) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"doesLocalUserExist");
    org.cagrid.gaards.dorian.stubs.DoesLocalUserExistRequest params = new org.cagrid.gaards.dorian.stubs.DoesLocalUserExistRequest();
    params.setUserId(userId);
    org.cagrid.gaards.dorian.stubs.DoesLocalUserExistResponse boxedResult = portType.doesLocalUserExist(params);
    return boxedResult.isResponse();
    }
  }

  public void changeLocalUserPassword(org.cagrid.gaards.authentication.BasicAuthentication credential,java.lang.String newPassword) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserPropertyFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"changeLocalUserPassword");
    org.cagrid.gaards.dorian.stubs.ChangeLocalUserPasswordRequest params = new org.cagrid.gaards.dorian.stubs.ChangeLocalUserPasswordRequest();
    org.cagrid.gaards.dorian.stubs.ChangeLocalUserPasswordRequestCredential credentialContainer = new org.cagrid.gaards.dorian.stubs.ChangeLocalUserPasswordRequestCredential();
    credentialContainer.setBasicAuthentication(credential);
    params.setCredential(credentialContainer);
    params.setNewPassword(newPassword);
    org.cagrid.gaards.dorian.stubs.ChangeLocalUserPasswordResponse boxedResult = portType.changeLocalUserPassword(params);
    }
  }

  public void updateUserCertificate(org.cagrid.gaards.dorian.federation.UserCertificateUpdate update) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"updateUserCertificate");
    org.cagrid.gaards.dorian.stubs.UpdateUserCertificateRequest params = new org.cagrid.gaards.dorian.stubs.UpdateUserCertificateRequest();
    org.cagrid.gaards.dorian.stubs.UpdateUserCertificateRequestUpdate updateContainer = new org.cagrid.gaards.dorian.stubs.UpdateUserCertificateRequestUpdate();
    updateContainer.setUserCertificateUpdate(update);
    params.setUpdate(updateContainer);
    org.cagrid.gaards.dorian.stubs.UpdateUserCertificateResponse boxedResult = portType.updateUserCertificate(params);
    }
  }

  public org.cagrid.gaards.dorian.X509Certificate requestUserCertificate(gov.nih.nci.cagrid.opensaml.SAMLAssertion saml,org.cagrid.gaards.dorian.federation.PublicKey key,org.cagrid.gaards.dorian.federation.CertificateLifetime lifetime) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidAssertionFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault, org.cagrid.gaards.dorian.stubs.types.UserPolicyFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"requestUserCertificate");
    org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequest params = new org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequest();
    org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequestSaml samlContainer = new org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequestSaml();
    samlContainer.setAssertion(saml);
    params.setSaml(samlContainer);
    org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequestKey keyContainer = new org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequestKey();
    keyContainer.setPublicKey(key);
    params.setKey(keyContainer);
    org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequestLifetime lifetimeContainer = new org.cagrid.gaards.dorian.stubs.RequestUserCertificateRequestLifetime();
    lifetimeContainer.setCertificateLifetime(lifetime);
    params.setLifetime(lifetimeContainer);
    org.cagrid.gaards.dorian.stubs.RequestUserCertificateResponse boxedResult = portType.requestUserCertificate(params);
    return boxedResult.getX509Certificate();
    }
  }

  public org.cagrid.gaards.dorian.federation.UserCertificateRecord[] findUserCertificates(org.cagrid.gaards.dorian.federation.UserCertificateFilter userCertificateFilter) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"findUserCertificates");
    org.cagrid.gaards.dorian.stubs.FindUserCertificatesRequest params = new org.cagrid.gaards.dorian.stubs.FindUserCertificatesRequest();
    org.cagrid.gaards.dorian.stubs.FindUserCertificatesRequestUserCertificateFilter userCertificateFilterContainer = new org.cagrid.gaards.dorian.stubs.FindUserCertificatesRequestUserCertificateFilter();
    userCertificateFilterContainer.setUserCertificateFilter(userCertificateFilter);
    params.setUserCertificateFilter(userCertificateFilterContainer);
    org.cagrid.gaards.dorian.stubs.FindUserCertificatesResponse boxedResult = portType.findUserCertificates(params);
    return boxedResult.getUserCertificateRecord();
    }
  }

  public void removeUserCertificate(java.lang.String serialNumber) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserCertificateFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"removeUserCertificate");
    org.cagrid.gaards.dorian.stubs.RemoveUserCertificateRequest params = new org.cagrid.gaards.dorian.stubs.RemoveUserCertificateRequest();
    params.setSerialNumber(serialNumber);
    org.cagrid.gaards.dorian.stubs.RemoveUserCertificateResponse boxedResult = portType.removeUserCertificate(params);
    }
  }

  public org.cagrid.gaards.dorian.federation.FederationAuditRecord[] performFederationAudit(org.cagrid.gaards.dorian.federation.FederationAuditFilter f) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"performFederationAudit");
    org.cagrid.gaards.dorian.stubs.PerformFederationAuditRequest params = new org.cagrid.gaards.dorian.stubs.PerformFederationAuditRequest();
    org.cagrid.gaards.dorian.stubs.PerformFederationAuditRequestF fContainer = new org.cagrid.gaards.dorian.stubs.PerformFederationAuditRequestF();
    fContainer.setFederationAuditFilter(f);
    params.setF(fContainer);
    org.cagrid.gaards.dorian.stubs.PerformFederationAuditResponse boxedResult = portType.performFederationAudit(params);
    return boxedResult.getFederationAuditRecord();
    }
  }

  public org.cagrid.gaards.dorian.idp.IdentityProviderAuditRecord[] performIdentityProviderAudit(org.cagrid.gaards.dorian.idp.IdentityProviderAuditFilter f) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"performIdentityProviderAudit");
    org.cagrid.gaards.dorian.stubs.PerformIdentityProviderAuditRequest params = new org.cagrid.gaards.dorian.stubs.PerformIdentityProviderAuditRequest();
    org.cagrid.gaards.dorian.stubs.PerformIdentityProviderAuditRequestF fContainer = new org.cagrid.gaards.dorian.stubs.PerformIdentityProviderAuditRequestF();
    fContainer.setIdentityProviderAuditFilter(f);
    params.setF(fContainer);
    org.cagrid.gaards.dorian.stubs.PerformIdentityProviderAuditResponse boxedResult = portType.performIdentityProviderAudit(params);
    return boxedResult.getIdentityProviderAuditRecord();
    }
  }

  public java.lang.String registerLocalUser(org.cagrid.gaards.dorian.idp.Application a) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.InvalidUserPropertyFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"registerLocalUser");
    org.cagrid.gaards.dorian.stubs.RegisterLocalUserRequest params = new org.cagrid.gaards.dorian.stubs.RegisterLocalUserRequest();
    org.cagrid.gaards.dorian.stubs.RegisterLocalUserRequestA aContainer = new org.cagrid.gaards.dorian.stubs.RegisterLocalUserRequestA();
    aContainer.setApplication(a);
    params.setA(aContainer);
    org.cagrid.gaards.dorian.stubs.RegisterLocalUserResponse boxedResult = portType.registerLocalUser(params);
    return boxedResult.getResponse();
    }
  }

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getMultipleResourceProperties");
    return portType.getMultipleResourceProperties(params);
    }
  }

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getResourceProperty");
    return portType.getResourceProperty(params);
    }
  }

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"queryResourceProperties");
    return portType.queryResourceProperties(params);
    }
  }

  public org.cagrid.gaards.dorian.federation.GridUserRecord[] userSearch(org.cagrid.gaards.dorian.federation.GridUserSearchCriteria gridUserSearchCriteria) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"userSearch");
    org.cagrid.gaards.dorian.stubs.UserSearchRequest params = new org.cagrid.gaards.dorian.stubs.UserSearchRequest();
    org.cagrid.gaards.dorian.stubs.UserSearchRequestGridUserSearchCriteria gridUserSearchCriteriaContainer = new org.cagrid.gaards.dorian.stubs.UserSearchRequestGridUserSearchCriteria();
    gridUserSearchCriteriaContainer.setGridUserSearchCriteria(gridUserSearchCriteria);
    params.setGridUserSearchCriteria(gridUserSearchCriteriaContainer);
    org.cagrid.gaards.dorian.stubs.UserSearchResponse boxedResult = portType.userSearch(params);
    return boxedResult.getGridUserRecord();
    }
  }

  public org.cagrid.gaards.dorian.federation.HostRecord[] hostSearch(org.cagrid.gaards.dorian.federation.HostSearchCriteria hostSearchCriteria) throws RemoteException, org.cagrid.gaards.dorian.stubs.types.DorianInternalFault, org.cagrid.gaards.dorian.stubs.types.PermissionDeniedFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"hostSearch");
    org.cagrid.gaards.dorian.stubs.HostSearchRequest params = new org.cagrid.gaards.dorian.stubs.HostSearchRequest();
    org.cagrid.gaards.dorian.stubs.HostSearchRequestHostSearchCriteria hostSearchCriteriaContainer = new org.cagrid.gaards.dorian.stubs.HostSearchRequestHostSearchCriteria();
    hostSearchCriteriaContainer.setHostSearchCriteria(hostSearchCriteria);
    params.setHostSearchCriteria(hostSearchCriteriaContainer);
    org.cagrid.gaards.dorian.stubs.HostSearchResponse boxedResult = portType.hostSearch(params);
    return boxedResult.getHostRecord();
    }
  }

}
