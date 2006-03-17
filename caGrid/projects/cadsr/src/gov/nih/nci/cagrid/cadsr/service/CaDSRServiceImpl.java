package gov.nih.nci.cagrid.cadsr.service;

import gov.nih.nci.cadsr.domain.ClassificationScheme;
import gov.nih.nci.cadsr.domain.Context;
import gov.nih.nci.cadsr.umlproject.domain.Project;
import gov.nih.nci.cagrid.cadsr.common.CaDSRServiceI;
import gov.nih.nci.system.applicationservice.ApplicationService;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * gov.nih.nci.cagrid.cadsrI
 * 
 * @created by caGrid toolkit version 1.0
 */
public class CaDSRServiceImpl implements CaDSRServiceI {

	protected static Log LOG = LogFactory.getLog(CaDSRServiceImpl.class.getName());

	// "http://cbioqa101.nci.nih.gov:49080/cacore31/http/remoteService"
	// "http://cbiodev104.nci.nih.gov:49080/cacore31/http/remoteService
	private String serviceURL = "http://localhost:49080/cacore31/http/remoteService";


	public CaDSRServiceImpl() {

	}


	public gov.nih.nci.cadsr.umlproject.domain.Project[] findAllProjects() throws RemoteException {
		try {
			ApplicationService appService = ApplicationService.getRemoteInstance(serviceURL);
			LOG.debug("Using basic search. Retrieving allprojects");

			Project projPrototype = new Project();
			ClassificationScheme cs = new ClassificationScheme();
			cs.setType("Project");// is this necessary?
			Context ctx = new Context();
			ctx.setName("caBIG");
			cs.setContext(ctx);
			projPrototype.setClassificationScheme(cs);

			try {
				List resultList = appService.search(Project.class, projPrototype);
				Project arr[] = new Project[resultList.size()];
				LOG.debug("result count: " + resultList.size());
				int index = 0;
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					Project project = (Project) resultsIterator.next();
					LOG.debug("project name:" + project.getLongName());
					arr[index++] = project;
				}
				return arr;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RemoteException(e.getMessage(), e);
			}

		} catch (RuntimeException e2) {
			e2.printStackTrace();
			throw new RemoteException(e2.getMessage(), e2);
		}
	}


	public gov.nih.nci.cadsr.umlproject.domain.Project[] findProjects(String context) throws RemoteException {
		try {
			ApplicationService appService = ApplicationService.getRemoteInstance(serviceURL);
			LOG.debug("Using basic search. Retrieving all projects under context:" + context);

			Project projPrototype = new Project();
			ClassificationScheme cs = new ClassificationScheme();
			cs.setType("Project");// is this necessary?
			Context ctx = new Context();
			ctx.setName(context);
			cs.setContext(ctx);
			projPrototype.setClassificationScheme(cs);

			try {
				List resultList = appService.search(Project.class, projPrototype);
				Project arr[] = new Project[resultList.size()];
				LOG.debug("result count: " + resultList.size());
				int index = 0;
				for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
					Project project = (Project) resultsIterator.next();
					LOG.debug("project name:" + project.getLongName());
					arr[index++] = project;
				}
				return arr;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RemoteException(e.getMessage(), e);
			}

		} catch (RuntimeException e2) {
			e2.printStackTrace();
			throw new RemoteException(e2.getMessage(), e2);
		}
	}
}
