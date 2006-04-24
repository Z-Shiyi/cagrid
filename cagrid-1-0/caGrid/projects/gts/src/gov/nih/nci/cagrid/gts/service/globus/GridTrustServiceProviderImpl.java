package gov.nih.nci.cagrid.gts.service.globus;

import gov.nih.nci.cagrid.gts.common.GridTrustServiceI;
import gov.nih.nci.cagrid.gts.service.GridTrustServiceImpl;

import java.rmi.RemoteException;


/**
 * DO NOT EDIT: This class is autogenerated!
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class GridTrustServiceProviderImpl {

	GridTrustServiceI impl;


	public GridTrustServiceProviderImpl() throws RemoteException{
		impl = new GridTrustServiceImpl();
	}














































































































































































	public gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityResponse updateAuthority(gov.nih.nci.cagrid.gts.stubs.UpdateAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.InvalidAuthorityFault {
		gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.UpdateAuthorityResponse();
		impl.updateAuthority();
		return boxedResult;
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
		impl.removeTrustedAuthority(params.getTrustedAuthorityName());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse addPermission(gov.nih.nci.cagrid.gts.stubs.AddPermission params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalPermissionFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.AddPermissionResponse();
		impl.addPermission(params.getPermission().getPermission());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse findPermissions(gov.nih.nci.cagrid.gts.stubs.FindPermissions params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.FindPermissionsResponse();
		boxedResult.setPermission(impl.findPermissions(params.getF().getPermissionFilter()));
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse revokePermission(gov.nih.nci.cagrid.gts.stubs.RevokePermission params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidPermissionFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.RevokePermissionResponse();
		impl.revokePermission(params.getPermission().getPermission());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthorityResponse updateTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthorityResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.UpdateTrustedAuthorityResponse();
		impl.updateTrustedAuthority(params.getTa().getTrustedAuthority());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.AddTrustLevelResponse addTrustLevel(gov.nih.nci.cagrid.gts.stubs.AddTrustLevel params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustLevelFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.AddTrustLevelResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.AddTrustLevelResponse();
		impl.addTrustLevel(params.getTrustLevel().getTrustLevel());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevelResponse updateTrustLevel(gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevel params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustLevelFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevelResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.UpdateTrustLevelResponse();
		impl.updateTrustLevel(params.getTrustLevel().getTrustLevel());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.GetTrustLevelsResponse getTrustLevels(gov.nih.nci.cagrid.gts.stubs.GetTrustLevels params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		gov.nih.nci.cagrid.gts.stubs.GetTrustLevelsResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.GetTrustLevelsResponse();
		boxedResult.setTrustLevel(impl.getTrustLevels());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevelResponse removeTrustLevel(gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevel params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustLevelFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustLevelFault, gov.nih.nci.cagrid.gts.stubs.PermissionDeniedFault {
		gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevelResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.RemoveTrustLevelResponse();
		impl.removeTrustLevel(params.getString());
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.AddAuthorityResponse addAuthority(gov.nih.nci.cagrid.gts.stubs.AddAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.IllegalAuthorityFault {
		gov.nih.nci.cagrid.gts.stubs.AddAuthorityResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.AddAuthorityResponse();
		impl.addAuthority();
		return boxedResult;
	}

}
