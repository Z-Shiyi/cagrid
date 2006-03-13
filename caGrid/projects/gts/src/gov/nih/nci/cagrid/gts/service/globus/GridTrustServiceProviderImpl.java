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
	


















	public gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse findTrustedAuthorities(gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthorities params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault {
		gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse boxedResult = new gov.nih.nci.cagrid.gts.stubs.FindTrustedAuthoritiesResponse();
		boxedResult.setResponse(impl.findTrustedAuthorities(params.getTrustedAuthorityFilter()));
		return boxedResult;
	}
	public gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse removeTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.InvalidTrustedAuthorityFault {
		impl.removeTrustedAuthority();
		return new gov.nih.nci.cagrid.gts.stubs.RemoveTrustedAuthorityResponse();
	}
	public gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse addTrustedAuthority(gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthority params) throws RemoteException, gov.nih.nci.cagrid.gts.stubs.GTSInternalFault, gov.nih.nci.cagrid.gts.stubs.IllegalTrustedAuthorityFault {
		impl.addTrustedAuthority(params.getTrustedAuthority());
		return new gov.nih.nci.cagrid.gts.stubs.AddTrustedAuthorityResponse();
	}

}
