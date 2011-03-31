package org.cagrid.gaards.dorian.service.globus;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.xml.namespace.QName;
import javax.xml.rpc.handler.MessageContext;

import org.globus.wsrf.config.ContainerConfig;
import org.globus.wsrf.impl.security.authorization.exceptions.AuthorizationException;
import org.globus.wsrf.impl.security.authorization.exceptions.CloseException;
import org.globus.wsrf.impl.security.authorization.exceptions.InitializeException;
import org.globus.wsrf.impl.security.authorization.exceptions.InvalidPolicyException;
import org.globus.wsrf.security.authorization.PDP;
import org.globus.wsrf.security.authorization.PDPConfig;
import org.w3c.dom.Node;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This is a PDP for use with the globus authorization callout.
 * This class will have a authorize method for each method on this grid service.
 * The method is responsible for making any authorization callouts required to satisfy the 
 * authorization requirements placed on each method call.  Each method will either return
 * upon a successful authorization or will throw an exception upon a failed authorization.
 * 
 * @created by Introduce Toolkit version 1.4
 * 
 */
public class DorianAuthorization implements PDP {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String SERVICE_NAMESPACE = "http://cagrid.nci.nih.gov/Dorian";
	
	Map authorizationClassMap = new HashMap();
	
	
	public DorianAuthorization() {
	}
	
	protected String getServiceNamespace(){
		return SERVICE_NAMESPACE;
	}
	
	public static String getCallerIdentity() {
		String caller = org.globus.wsrf.security.SecurityManager.getManager().getCaller();
		if ((caller == null) || (caller.equals("<anonymous>"))) {
			return null;
		} else {
			return caller;
		}
	}
					
	public void authorizeGetServiceSecurityMetadata(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRegisterWithIdP(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeFindLocalUsers(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUpdateLocalUser(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRemoveLocalUser(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeCreateProxy(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetCACertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetTrustedIdPs(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeAddTrustedIdP(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUpdateTrustedIdP(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRemoveTrustedIdP(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeFindGridUsers(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUpdateGridUser(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRemoveGridUser(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetGridUserPolicies(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeAuthenticate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeAuthenticateUser(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeAddAdmin(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRemoveAdmin(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetAdmins(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRequestHostCertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetOwnedHostCertificates(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeApproveHostCertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeFindHostCertificates(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUpdateHostCertificateRecord(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRenewHostCertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeChangeIdPUserPassword(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeDoesLocalUserExist(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeChangeLocalUserPassword(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUpdateUserCertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRequestUserCertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeFindUserCertificates(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRemoveUserCertificate(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizePerformFederationAudit(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizePerformIdentityProviderAudit(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeRegisterLocalUser(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetMultipleResourceProperties(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetResourceProperty(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeQueryResourceProperties(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUserSearch(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeHostSearch(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetAccountProfile(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeUpdateAccountProfile(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSetPublish(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetPublish(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   
	
	public boolean isPermitted(Subject peerSubject, MessageContext context, QName operation)
		throws AuthorizationException {
		
		if(!operation.getNamespaceURI().equals(getServiceNamespace())){
		  return false;
		}
		if(operation.getLocalPart().equals("getServiceSecurityMetadata")){
			authorizeGetServiceSecurityMetadata(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("registerWithIdP")){
			authorizeRegisterWithIdP(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("findLocalUsers")){
			authorizeFindLocalUsers(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("updateLocalUser")){
			authorizeUpdateLocalUser(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("removeLocalUser")){
			authorizeRemoveLocalUser(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("createProxy")){
			authorizeCreateProxy(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getCACertificate")){
			authorizeGetCACertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getTrustedIdPs")){
			authorizeGetTrustedIdPs(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("addTrustedIdP")){
			authorizeAddTrustedIdP(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("updateTrustedIdP")){
			authorizeUpdateTrustedIdP(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("removeTrustedIdP")){
			authorizeRemoveTrustedIdP(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("findGridUsers")){
			authorizeFindGridUsers(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("updateGridUser")){
			authorizeUpdateGridUser(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("removeGridUser")){
			authorizeRemoveGridUser(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getGridUserPolicies")){
			authorizeGetGridUserPolicies(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("authenticate")){
			authorizeAuthenticate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("authenticateUser")){
			authorizeAuthenticateUser(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("addAdmin")){
			authorizeAddAdmin(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("removeAdmin")){
			authorizeRemoveAdmin(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getAdmins")){
			authorizeGetAdmins(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("requestHostCertificate")){
			authorizeRequestHostCertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getOwnedHostCertificates")){
			authorizeGetOwnedHostCertificates(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("approveHostCertificate")){
			authorizeApproveHostCertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("findHostCertificates")){
			authorizeFindHostCertificates(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("updateHostCertificateRecord")){
			authorizeUpdateHostCertificateRecord(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("renewHostCertificate")){
			authorizeRenewHostCertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("changeIdPUserPassword")){
			authorizeChangeIdPUserPassword(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("doesLocalUserExist")){
			authorizeDoesLocalUserExist(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("changeLocalUserPassword")){
			authorizeChangeLocalUserPassword(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("updateUserCertificate")){
			authorizeUpdateUserCertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("requestUserCertificate")){
			authorizeRequestUserCertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("findUserCertificates")){
			authorizeFindUserCertificates(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("removeUserCertificate")){
			authorizeRemoveUserCertificate(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("performFederationAudit")){
			authorizePerformFederationAudit(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("performIdentityProviderAudit")){
			authorizePerformIdentityProviderAudit(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("registerLocalUser")){
			authorizeRegisterLocalUser(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getMultipleResourceProperties")){
			authorizeGetMultipleResourceProperties(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getResourceProperty")){
			authorizeGetResourceProperty(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("queryResourceProperties")){
			authorizeQueryResourceProperties(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("userSearch")){
			authorizeUserSearch(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("hostSearch")){
			authorizeHostSearch(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getAccountProfile")){
			authorizeGetAccountProfile(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("updateAccountProfile")){
			authorizeUpdateAccountProfile(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("setPublish")){
			authorizeSetPublish(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getPublish")){
			authorizeGetPublish(peerSubject, context, operation);
			return true;
		} 		
		return false;
	}
	

	public Node getPolicy(Node query) throws InvalidPolicyException {
		return null;
	}


	public String[] getPolicyNames() {
		return null;
	}


	public Node setPolicy(Node policy) throws InvalidPolicyException {
		return null;
	}


	public void close() throws CloseException {


	}


	public void initialize(PDPConfig config, String name, String id) throws InitializeException {
    	try{
    		String serviceName = (String)config.getProperty(name, "serviceName");
    	    String etcPath = ContainerConfig.getBaseDirectory() + File.separator + (String)config.getProperty(name, "etcDirectoryPath");

    	
    	} catch (Exception e){
        	throw new InitializeException(e.getMessage(),e);
		}
	}
	
	
}
