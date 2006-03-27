package gov.nih.nci.cagrid.gts.client;

import gov.nih.nci.cagrid.gts.common.GridTrustServiceI;
import gov.nih.nci.cagrid.gts.stubs.GridTrustServicePortType;
import gov.nih.nci.cagrid.gts.stubs.service.GridTrustServiceAddressingLocator;

import java.rmi.RemoteException;

import org.apache.axis.message.addressing.Address;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.globus.axis.util.Util;
import org.globus.gsi.GlobusCredential;


/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class GridTrustServiceClient implements GridTrustServiceI {

	private GlobusCredential proxy;

	private String url;

	static {
		Util.registerTransport();
	}


	public GridTrustServiceClient(String url) {
		this(url, null);
	}


	public GridTrustServiceClient(String url, GlobusCredential proxy) {
		this.proxy = proxy;
		this.url = url;
	}


	private GridTrustServicePortType getPortType() {
		try {
			GridTrustServiceAddressingLocator locator = new GridTrustServiceAddressingLocator();
			EndpointReferenceType endpoint = new EndpointReferenceType();
			endpoint.setAddress(new Address(url));
			GridTrustServicePortType port = locator.getGridTrustServicePortTypePort(endpoint);
			return port;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void usage() {
		System.out.println(GridTrustServiceClient.class.getName() + " -gsh [gsh]");
	}


	public static void main(String[] args) {
		try {
			if (!(args.length < 2)) {
				if (args[0].equals("-gsh")) {
					GridTrustServiceClient client = new GridTrustServiceClient(args[1]);
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
		}
	}


	public gov.nih.nci.cagrid.gts.bean.TrustedAuthority addTrustedAuthority(
		gov.nih.nci.cagrid.gts.bean.TrustedAuthority ta) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault,
		gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		if (proxy != null) {
			try {
				org.ietf.jgss.GSSCredential gss = new org.globus.gsi.gssapi.GlobusGSSCredentialImpl(proxy,
					org.ietf.jgss.GSSCredential.INITIATE_AND_ACCEPT);
				stub._setProperty(org.globus.axis.gsi.GSIConstants.GSI_CREDENTIALS, gss);
			} catch (org.ietf.jgss.GSSException ex) {
				throw new RemoteException(ex.getMessage());
			}
		}
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthority params = new gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthority();
		gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityTa taContainer = new gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityTa();
		taContainer.setTrustedAuthority(ta);
		params.setTa(taContainer);
		gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse boxedResult = port.addTrustedAuthority(params);
		return boxedResult.getTrustedAuthority();

	}


	public gov.nih.nci.cagrid.gts.bean.TrustedAuthority[] findTrustedAuthorities(
		gov.nih.nci.cagrid.gts.bean.TrustedAuthorityFilter f) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_ANONYMOUS, Boolean.TRUE);
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthorities params = new gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthorities();
		gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesF fContainer = new gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesF();
		fContainer.setTrustedAuthorityFilter(f);
		params.setF(fContainer);
		gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse boxedResult = port.findTrustedAuthorities(params);
		return boxedResult.getTrustedAuthority();

	}


	public void removeTrustedAuthority(java.lang.String trustedAuthorityName) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault,
		gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		if (proxy != null) {
			try {
				org.ietf.jgss.GSSCredential gss = new org.globus.gsi.gssapi.GlobusGSSCredentialImpl(proxy,
					org.ietf.jgss.GSSCredential.INITIATE_AND_ACCEPT);
				stub._setProperty(org.globus.axis.gsi.GSIConstants.GSI_CREDENTIALS, gss);
			} catch (org.ietf.jgss.GSSException ex) {
				throw new RemoteException(ex.getMessage());
			}
		}
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthority params = new gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthority();
		params.setTrustedAuthorityName(trustedAuthorityName);
		gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse boxedResult = port.removeTrustedAuthority(params);

	}


	public void addPermission(gov.nih.nci.cagrid.gts.bean.Permission permission) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalPermissionFault,
		gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		if (proxy != null) {
			try {
				org.ietf.jgss.GSSCredential gss = new org.globus.gsi.gssapi.GlobusGSSCredentialImpl(proxy,
					org.ietf.jgss.GSSCredential.INITIATE_AND_ACCEPT);
				stub._setProperty(org.globus.axis.gsi.GSIConstants.GSI_CREDENTIALS, gss);
			} catch (org.ietf.jgss.GSSException ex) {
				throw new RemoteException(ex.getMessage());
			}
		}
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.AddPermission params = new gov.nih.nci.cagrid.gts.stubs.AddPermission();
		gov.nih.nci.cagrid.gts.stubs.AddPermissionPermission permissionContainer = new gov.nih.nci.cagrid.gts.stubs.AddPermissionPermission();
		permissionContainer.setPermission(permission);
		params.setPermission(permissionContainer);
		gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse boxedResult = port.addPermission(params);

	}


	public gov.nih.nci.cagrid.gts.bean.Permission[] findPermissions(gov.nih.nci.cagrid.gts.bean.PermissionFilter f)
		throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault,
		gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		if (proxy != null) {
			try {
				org.ietf.jgss.GSSCredential gss = new org.globus.gsi.gssapi.GlobusGSSCredentialImpl(proxy,
					org.ietf.jgss.GSSCredential.INITIATE_AND_ACCEPT);
				stub._setProperty(org.globus.axis.gsi.GSIConstants.GSI_CREDENTIALS, gss);
			} catch (org.ietf.jgss.GSSException ex) {
				throw new RemoteException(ex.getMessage());
			}
		}
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.FindPermissions params = new gov.nih.nci.cagrid.gts.stubs.FindPermissions();
		gov.nih.nci.cagrid.gts.stubs.FindPermissionsF fContainer = new gov.nih.nci.cagrid.gts.stubs.FindPermissionsF();
		fContainer.setPermissionFilter(f);
		params.setF(fContainer);
		gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse boxedResult = port.findPermissions(params);
		return boxedResult.getPermission();

	}


	public void revokePermission(gov.nih.nci.cagrid.gts.bean.Permission permission) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidPermissionFault,
		gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		if (proxy != null) {
			try {
				org.ietf.jgss.GSSCredential gss = new org.globus.gsi.gssapi.GlobusGSSCredentialImpl(proxy,
					org.ietf.jgss.GSSCredential.INITIATE_AND_ACCEPT);
				stub._setProperty(org.globus.axis.gsi.GSIConstants.GSI_CREDENTIALS, gss);
			} catch (org.ietf.jgss.GSSException ex) {
				throw new RemoteException(ex.getMessage());
			}
		}
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.RevokePermission params = new gov.nih.nci.cagrid.gts.stubs.RevokePermission();
		gov.nih.nci.cagrid.gts.stubs.RevokePermissionPermission permissionContainer = new gov.nih.nci.cagrid.gts.stubs.RevokePermissionPermission();
		permissionContainer.setPermission(permission);
		params.setPermission(permissionContainer);
		gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse boxedResult = port.revokePermission(params);

	}

}
