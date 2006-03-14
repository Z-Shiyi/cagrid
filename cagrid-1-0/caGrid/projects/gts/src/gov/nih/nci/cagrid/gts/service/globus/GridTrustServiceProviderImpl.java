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
	








































	public gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse revokePermission(gov.nih.nci.cagrid.gts.stubs.RevokePermission params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidPermissionFault {
		impl.revokePermission(params.getPermission().getPermission());
		return new gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse();
	}
	public gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse removeTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault {
		impl.removeTrustedAuthority();
		return new gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse();
	}
	public gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse addTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault {
		impl.addTrustedAuthority(params.getTrustedAuthority().getTrustedAuthority());
		return new gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse();
	}
	public gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse findTrustedAuthorities(gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthorities params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse();
		boxedResult.setTrustedAuthority(impl.findTrustedAuthorities(params.getTrustedAuthorityFilter().getTrustedAuthorityFilter()));
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse addPermission(gov.nih.nci.cagrid.gts.stubs.AddPermission params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalPermissionFault {
		impl.addPermission(params.getPermission().getPermission());
		return new gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse();
	}
	public gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse findPermissions(gov.nih.nci.cagrid.gts.stubs.FindPermissions params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse();
		boxedResult.setPermission(impl.findPermissions(params.getPermissionFilter().getPermissionFilter()));
		return boxedResult;
	}

}
