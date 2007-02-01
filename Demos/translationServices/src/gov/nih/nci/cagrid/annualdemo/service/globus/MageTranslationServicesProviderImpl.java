package gov.nih.nci.cagrid.annualdemo.service.globus;

import gov.nih.nci.cagrid.annualdemo.service.MageTranslationServicesImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the MageTranslationServicesImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class MageTranslationServicesProviderImpl{
	
	MageTranslationServicesImpl impl;
	
	public MageTranslationServicesProviderImpl() throws RemoteException {
		impl = new MageTranslationServicesImpl();
	}
	

	public gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArrayResponse mageToMicroArray(gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArrayRequest params) throws RemoteException {
		MageTranslationServicesAuthorization.authorizeMageToMicroArray();
		gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArrayResponse boxedResult = new gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArrayResponse();
		boxedResult.setMicroarraySet(impl.mageToMicroArray(params.getCQLQueryResultCollection().getCQLQueryResultCollection()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLResponse mageToStatML(gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLRequest params) throws RemoteException {
		MageTranslationServicesAuthorization.authorizeMageToStatML();
		gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLResponse boxedResult = new gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLResponse();
		boxedResult.setData(impl.mageToStatML(params.getCQLQueryResultCollection().getCQLQueryResultCollection()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.annualdemo.stubs.ClusterToTreeViewResponse clusterToTreeView(gov.nih.nci.cagrid.annualdemo.stubs.ClusterToTreeViewRequest params) throws RemoteException {
		MageTranslationServicesAuthorization.authorizeClusterToTreeView();
		gov.nih.nci.cagrid.annualdemo.stubs.ClusterToTreeViewResponse boxedResult = new gov.nih.nci.cagrid.annualdemo.stubs.ClusterToTreeViewResponse();
		boxedResult.setTreeViewInputElement(impl.clusterToTreeView(params.getHierarchicalClusteringParameter().getHierarchicalClusteringParameter(),params.getMicroarraySet().getMicroarraySet()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToGpClusterResponse gwClusterToGpCluster(gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToGpClusterRequest params) throws RemoteException {
		MageTranslationServicesAuthorization.authorizeGwClusterToGpCluster();
		gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToGpClusterResponse boxedResult = new gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToGpClusterResponse();
		boxedResult.setHierarchicalCluster(impl.gwClusterToGpCluster(params.getCluster().getCluster()));
		return boxedResult;
	}

	public gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetResponse statmlToMicroarraySet(gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetRequest params) throws RemoteException {
		MageTranslationServicesAuthorization.authorizeStatmlToMicroarraySet();
		gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetResponse boxedResult = new gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetResponse();
		boxedResult.setMicroarraySet(impl.statmlToMicroarraySet(params.getData().getData()));
		return boxedResult;
	}

}
