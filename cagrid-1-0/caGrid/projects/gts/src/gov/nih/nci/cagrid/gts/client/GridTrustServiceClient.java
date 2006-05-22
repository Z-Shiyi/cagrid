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


	public boolean validate(gov.nih.nci.cagrid.gts.bean.X509Certificate[] chain,
		gov.nih.nci.cagrid.gts.bean.TrustedAuthorityFilter filter) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.CertificateValidationFault {
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
		gov.nih.nci.cagrid.gts.stubs.Validate params = new gov.nih.nci.cagrid.gts.stubs.Validate();
		gov.nih.nci.cagrid.gts.stubs.ValidateChain chainContainer = new gov.nih.nci.cagrid.gts.stubs.ValidateChain();
		chainContainer.setX509Certificate(chain);
		params.setChain(chainContainer);
		gov.nih.nci.cagrid.gts.stubs.ValidateFilter filterContainer = new gov.nih.nci.cagrid.gts.stubs.ValidateFilter();
		filterContainer.setTrustedAuthorityFilter(filter);
		params.setFilter(filterContainer);
		gov.nih.nci.cagrid.gts.stubs.ValidateResponse boxedResult = port.validate(params);
		return boxedResult.isResponse();

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


	public void updateTrustedAuthority(gov.nih.nci.cagrid.gts.bean.TrustedAuthority ta) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault,
		gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
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
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthority params = new gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthority();
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthorityTa taContainer = new gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthorityTa();
		taContainer.setTrustedAuthority(ta);
		params.setTa(taContainer);
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthorityResponse boxedResult = port.updateTrustedAuthority(params);

	}


	public void addTrustLevel(gov.nih.nci.cagrid.gts.bean.TrustLevel trustLevel) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustLevelFault,
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
		gov.nih.nci.cagrid.gts.stubs.AddTrustLevel params = new gov.nih.nci.cagrid.gts.stubs.AddTrustLevel();
		gov.nih.nci.cagrid.gts.stubs.AddTrustLevelTrustLevel trustLevelContainer = new gov.nih.nci.cagrid.gts.stubs.AddTrustLevelTrustLevel();
		trustLevelContainer.setTrustLevel(trustLevel);
		params.setTrustLevel(trustLevelContainer);
		gov.nih.nci.cagrid.gts.stubs.AddTrustLevelResponse boxedResult = port.addTrustLevel(params);

	}


	public void updateTrustLevel(gov.nih.nci.cagrid.gts.bean.TrustLevel trustLevel) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustLevelFault,
		gov.nih.nci.cagrid.gts.stubs.IllegalTrustLevelFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
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
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevel params = new gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevel();
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevelTrustLevel trustLevelContainer = new gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevelTrustLevel();
		trustLevelContainer.setTrustLevel(trustLevel);
		params.setTrustLevel(trustLevelContainer);
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevelResponse boxedResult = port.updateTrustLevel(params);

	}


	public gov.nih.nci.cagrid.gts.bean.TrustLevel[] getTrustLevels() throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		stub._setProperty(org.globus.wsrf.security.Constants.GSI_ANONYMOUS, Boolean.TRUE);
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.GetTrustLevels params = new gov.nih.nci.cagrid.gts.stubs.GetTrustLevels();
		gov.nih.nci.cagrid.gts.stubs.GetTrustLevelsResponse boxedResult = port.getTrustLevels(params);
		return boxedResult.getTrustLevel();

	}


	public void removeTrustLevel(java.lang.String string) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustLevelFault,
		gov.nih.nci.cagrid.gts.stubs.IllegalTrustLevelFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
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
		gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevel params = new gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevel();
		params.setString(string);
		gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevelResponse boxedResult = port.removeTrustLevel(params);

	}


	public void addAuthority(gov.nih.nci.cagrid.gts.bean.AuthorityGTS authorityGTS) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalAuthorityFault,
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
		gov.nih.nci.cagrid.gts.stubs.AddAuthority params = new gov.nih.nci.cagrid.gts.stubs.AddAuthority();
		gov.nih.nci.cagrid.gts.stubs.AddAuthorityAuthorityGTS authorityGTSContainer = new gov.nih.nci.cagrid.gts.stubs.AddAuthorityAuthorityGTS();
		authorityGTSContainer.setAuthorityGTS(authorityGTS);
		params.setAuthorityGTS(authorityGTSContainer);
		gov.nih.nci.cagrid.gts.stubs.AddAuthorityResponse boxedResult = port.addAuthority(params);

	}


	public void updateAuthority(gov.nih.nci.cagrid.gts.bean.AuthorityGTS authorityGTS) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalAuthorityFault,
		gov.nih.nci.cagrid.gts.stubs.InvalidAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
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
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthority params = new gov.nih.nci.cagrid.gts.stubs.UpdateAuthority();
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityAuthorityGTS authorityGTSContainer = new gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityAuthorityGTS();
		authorityGTSContainer.setAuthorityGTS(authorityGTS);
		params.setAuthorityGTS(authorityGTSContainer);
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityResponse boxedResult = port.updateAuthority(params);

	}


	public void updateAuthorityPriorities(gov.nih.nci.cagrid.gts.bean.AuthorityPriorityUpdate authorityPriorityUpdate)
		throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault,
		gov.nih.nci.cagrid.gts.stubs.IllegalAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
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
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityPriorities params = new gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityPriorities();
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityPrioritiesAuthorityPriorityUpdate authorityPriorityUpdateContainer = new gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityPrioritiesAuthorityPriorityUpdate();
		authorityPriorityUpdateContainer.setAuthorityPriorityUpdate(authorityPriorityUpdate);
		params.setAuthorityPriorityUpdate(authorityPriorityUpdateContainer);
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityPrioritiesResponse boxedResult = port
			.updateAuthorityPriorities(params);

	}


	public gov.nih.nci.cagrid.gts.bean.AuthorityGTS[] getAuthorities() throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		GridTrustServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		stub._setProperty(org.globus.wsrf.security.Constants.GSI_TRANSPORT,
			org.globus.wsrf.security.Constants.ENCRYPTION);
		stub._setProperty(org.globus.wsrf.security.Constants.GSI_ANONYMOUS, Boolean.TRUE);
		stub._setProperty(org.globus.wsrf.security.Constants.AUTHORIZATION,
			org.globus.wsrf.impl.security.authorization.NoAuthorization.getInstance());
		gov.nih.nci.cagrid.gts.stubs.GetAuthorities params = new gov.nih.nci.cagrid.gts.stubs.GetAuthorities();
		gov.nih.nci.cagrid.gts.stubs.GetAuthoritiesResponse boxedResult = port.getAuthorities(params);
		return boxedResult.getAuthorityGTS();

	}


	public void removeAuthority(java.lang.String serviceURI) throws RemoteException,
		gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidAuthorityFault,
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
		gov.nih.nci.cagrid.gts.stubs.RemoveAuthority params = new gov.nih.nci.cagrid.gts.stubs.RemoveAuthority();
		params.setServiceURI(serviceURI);
		gov.nih.nci.cagrid.gts.stubs.RemoveAuthorityResponse boxedResult = port.removeAuthority(params);

	}


	public void updateCRL(java.lang.String trustedAuthorityName, gov.nih.nci.cagrid.gts.bean.X509CRL crl)
		throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault,
		gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault,
		gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
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
		gov.nih.nci.cagrid.gts.stubs.UpdateCRL params = new gov.nih.nci.cagrid.gts.stubs.UpdateCRL();
		params.setTrustedAuthorityName(trustedAuthorityName);
		gov.nih.nci.cagrid.gts.stubs.UpdateCRLCrl crlContainer = new gov.nih.nci.cagrid.gts.stubs.UpdateCRLCrl();
		crlContainer.setX509CRL(crl);
		params.setCrl(crlContainer);
		gov.nih.nci.cagrid.gts.stubs.UpdateCRLResponse boxedResult = port.updateCRL(params);

	}

}
