package gov.nih.nci.cagrid.gts.service.globus;

import gov.nih.nci.cagrid.gts.common.GridTrustServiceI;
import gov.nih.nci.cagrid.gts.service.GridTrustServiceImpl;

import java.rmi.RemoteException;

/** 
 *  DO NOT EDIT:  This class is autogenerated!
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class GridTrustServiceProviderImpl{
	
	GridTrustServiceI impl;
	
	
	public GridTrustServiceProviderImpl() {
		impl = new GridTrustServiceImpl();
	}

	






	public gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse addTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse();
		boxedResult.setTrustedAuthority(impl.addTrustedAuthority(params.getTa().getTrustedAuthority()));
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse findTrustedAuthorities(gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthorities params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse();
		boxedResult.setTrustedAuthority(impl.findTrustedAuthorities(params.getF().getTrustedAuthorityFilter()));
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse removeTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse();
				return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse addPermission(gov.nih.nci.cagrid.gts.stubs.AddPermission params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalPermissionFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse();
				return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse findPermissions(gov.nih.nci.cagrid.gts.stubs.FindPermissions params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse();
		boxedResult.setPermission(impl.findPermissions(params.getF().getPermissionFilter()));
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse revokePermission(gov.nih.nci.cagrid.gts.stubs.RevokePermission params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidPermissionFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse();
				return boxedResult;
	}

}
