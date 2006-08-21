package gov.nih.nci.cagrid.bdt.service;

import gov.nih.nci.cagrid.bdt.service.globus.resource.BDTResource;

import java.rmi.RemoteException;

import org.globus.wsrf.ResourceContext;
import org.xmlsoap.schemas.ws._2004._09.enumeration.EnumerateResponse;


/**
 * gov.nih.nci.cagrid.bdtI TODO:DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class BulkDataHandlerImpl extends BulkDataHandlerImplBase {

	public BulkDataHandlerImpl() throws RemoteException {
		super();
	}


	public org.xmlsoap.schemas.ws._2004._09.enumeration.EnumerateResponse createEnumeration() throws RemoteException {
		BDTResource bdtResource = (BDTResource) ResourceContext.getResourceContext().getResource();
		EnumerateResponse response = new EnumerateResponse();
		response.setEnumerationContext(bdtResource.createEnumeration());
		return response;
	}


	public transfer.AnyXmlType get(transfer.EmptyType empty) throws RemoteException {
		BDTResource bdtResource = (BDTResource) ResourceContext.getResourceContext().getResource();
		return bdtResource.get();
	}

}
