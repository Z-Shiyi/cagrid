package gov.nih.nci.cagrid.evsgridservice.service.globus;

import gov.nih.nci.cagrid.evsgridservice.service.EVSGridServiceImpl;

import java.rmi.RemoteException;

/** 
 *  DO NOT EDIT:  This class is autogenerated!
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class EVSGridServiceProviderImpl{
	
	EVSGridServiceImpl impl;
	
	public EVSGridServiceProviderImpl() throws RemoteException {
		impl = new EVSGridServiceImpl();
	}
	
	protected String getCallerIdentity() {
		String caller = org.globus.wsrf.security.SecurityManager.getManager().getCaller();
		if ((caller == null) || (caller.equals("<anonymous>"))) {
			return null;
		} else {
			return caller;
		}
	}
	

	public gov.nih.nci.cagrid.evsgridservice.stubs.GetVocabularyNamesResponse getVocabularyNames(gov.nih.nci.cagrid.evsgridservice.stubs.GetVocabularyNamesRequest params) throws RemoteException {
		EVSGridServiceAuthorization.authorizeGetVocabularyNames();
		gov.nih.nci.cagrid.evsgridservice.stubs.GetVocabularyNamesResponse boxedResult = new gov.nih.nci.cagrid.evsgridservice.stubs.GetVocabularyNamesResponse();
		boxedResult.setDescLogicConceptVocabularyName(impl.getVocabularyNames());
		return boxedResult;
	}

	public gov.nih.nci.cagrid.evsgridservice.stubs.GetMetaSourcesResponse getMetaSources(gov.nih.nci.cagrid.evsgridservice.stubs.GetMetaSourcesRequest params) throws RemoteException {
		EVSGridServiceAuthorization.authorizeGetMetaSources();
		gov.nih.nci.cagrid.evsgridservice.stubs.GetMetaSourcesResponse boxedResult = new gov.nih.nci.cagrid.evsgridservice.stubs.GetMetaSourcesResponse();
		boxedResult.setSource(impl.getMetaSources());
		return boxedResult;
	}

	public gov.nih.nci.cagrid.evsgridservice.stubs.SearchDescLogicConceptResponse searchDescLogicConcept(gov.nih.nci.cagrid.evsgridservice.stubs.SearchDescLogicConceptRequest params) throws RemoteException, gov.nih.nci.cagrid.evsgridservice.stubs.types.InvalidInputExceptionType {
		EVSGridServiceAuthorization.authorizeSearchDescLogicConcept();
		gov.nih.nci.cagrid.evsgridservice.stubs.SearchDescLogicConceptResponse boxedResult = new gov.nih.nci.cagrid.evsgridservice.stubs.SearchDescLogicConceptResponse();
		boxedResult.setDescLogicConcept(impl.searchDescLogicConcept(params.getEVSDescLogicConceptSearchParams().getEVSDescLogicConceptSearchParams()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.evsgridservice.stubs.SearchMetaThesaurusResponse searchMetaThesaurus(gov.nih.nci.cagrid.evsgridservice.stubs.SearchMetaThesaurusRequest params) throws RemoteException, gov.nih.nci.cagrid.evsgridservice.stubs.types.InvalidInputExceptionType {
		EVSGridServiceAuthorization.authorizeSearchMetaThesaurus();
		gov.nih.nci.cagrid.evsgridservice.stubs.SearchMetaThesaurusResponse boxedResult = new gov.nih.nci.cagrid.evsgridservice.stubs.SearchMetaThesaurusResponse();
		boxedResult.setMetaThesaurusConcept(impl.searchMetaThesaurus(params.getEVSMetaThesaurusSearchParams().getEVSMetaThesaurusSearchParams()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.evsgridservice.stubs.GetHistoryRecordsResponse getHistoryRecords(gov.nih.nci.cagrid.evsgridservice.stubs.GetHistoryRecordsRequest params) throws RemoteException, gov.nih.nci.cagrid.evsgridservice.stubs.types.InvalidInputExceptionType {
		EVSGridServiceAuthorization.authorizeGetHistoryRecords();
		gov.nih.nci.cagrid.evsgridservice.stubs.GetHistoryRecordsResponse boxedResult = new gov.nih.nci.cagrid.evsgridservice.stubs.GetHistoryRecordsResponse();
		boxedResult.setHistoryRecord(impl.getHistoryRecords(params.getEVSHistoryRecordsSearchParams().getEVSHistoryRecordsSearchParams()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.evsgridservice.stubs.SearchSourceByCodeResponse searchSourceByCode(gov.nih.nci.cagrid.evsgridservice.stubs.SearchSourceByCodeRequest params) throws RemoteException, gov.nih.nci.cagrid.evsgridservice.stubs.types.InvalidInputExceptionType {
		EVSGridServiceAuthorization.authorizeSearchSourceByCode();
		gov.nih.nci.cagrid.evsgridservice.stubs.SearchSourceByCodeResponse boxedResult = new gov.nih.nci.cagrid.evsgridservice.stubs.SearchSourceByCodeResponse();
		boxedResult.setMetaThesaurusConcept(impl.searchSourceByCode(params.getEVSSourceSearchParams().getEVSSourceSearchParams()));
		return boxedResult;
	}

}
