package gov.nih.nci.cagrid.data.cql.cacore.experimental;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.data.MalformedQueryException;
import gov.nih.nci.cagrid.data.QueryProcessingException;
import gov.nih.nci.cagrid.data.cql.LazyCQLQueryProcessor;
import gov.nih.nci.cagrid.data.mapping.ClassToQname;
import gov.nih.nci.cagrid.data.mapping.Mappings;
import gov.nih.nci.cagrid.data.utilities.CQLResultsCreationUtil;
import gov.nih.nci.cagrid.data.utilities.ResultsCreationException;
import gov.nih.nci.system.applicationservice.ApplicationService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axis.deployment.wsdd.WSDDDeployment;
import org.apache.axis.deployment.wsdd.WSDDTypeMapping;
import org.apache.axis.utils.XMLUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/** 
 *  CoreQueryProcessor
 *  CQL Query processor implementation for SDK generated data sources.
 *  <b><i>This class shoule be concidered an experimental implementation.
 *  It makes use of Hibernate's DetachedCriteria API for queries, which
 *  does not provide the same level of expressivity that HQL does, and
 *  thus this query processor does not implement all the features of
 *  CQL against a caCORE data source</i></b>
 * 
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * 
 * @created May 2, 2006 
 * @version $Id$ 
 */
public class CoreQueryProcessor extends LazyCQLQueryProcessor {
	public static final String APPLICATION_SERVICE_URL = "appserviceUrl";
	
	private ApplicationService coreService;
	private StringBuffer wsddContents; 
	
	public CoreQueryProcessor() {
		super();
	}
	
	
	private InputStream getWsdd() throws Exception {
		if (getConfiguredWsddStream() != null) {
			if (wsddContents == null) {
				wsddContents = Utils.inputStreamToStringBuffer(getConfiguredWsddStream());
			}
			return new ByteArrayInputStream(wsddContents.toString().getBytes());
		} else {
			return null;
		}
	}
	

	public CQLQueryResults processQuery(CQLQuery cqlQuery) 
		throws MalformedQueryException, QueryProcessingException {
		InputStream configStream = null;
		try {
			configStream = getWsdd();
		} catch (Exception ex) {
			throw new QueryProcessingException(ex);
		}
		List coreResultsList = queryCoreService(cqlQuery);
		try {
			Mappings classToQnameMapping = wsddToMappings(configStream);
			CQLQueryResults queryResults = CQLResultsCreationUtil.createObjectResults(
				coreResultsList, cqlQuery.getTarget().getName(), classToQnameMapping);
			return queryResults;
		} catch (ResultsCreationException ex) {
			throw new QueryProcessingException("Error creating CQL Query Results: " + ex.getMessage(), ex);
		}
	}
	
	
	public Iterator processQueryLazy(CQLQuery cqlQuery) 
		throws MalformedQueryException, QueryProcessingException {
		List coreResultsList = queryCoreService(cqlQuery);
		return coreResultsList.iterator();
	}
	
	
	private List queryCoreService(CQLQuery query) 
		throws MalformedQueryException, QueryProcessingException {
		if (coreService == null) {
			String url = getConfiguredParameters().getProperty(APPLICATION_SERVICE_URL);
			if (url == null || url.length() == 0) {
				throw new QueryProcessingException(
					"Required parameter " + APPLICATION_SERVICE_URL + " was not defined!");
			}
			coreService = ApplicationService.getRemoteInstance(url);
		}
		DetachedCriteria objectCriteria = CQL2DetachedCriteria.translate(query);
		List targetObjects = null;
		try {
			targetObjects = coreService.query(objectCriteria, query.getTarget().getName());
		} catch (Exception ex) {
			throw new QueryProcessingException("Error invoking core query method: " + ex.getMessage(), ex);
		}
		return targetObjects;
	}
	
	
	public Properties getRequiredParameters() {
		Properties params = new Properties();
		params.setProperty(APPLICATION_SERVICE_URL, "http://localhost:8080/cacore31/server/HTTPServer");
		return params;
	}
	
	
	private Mappings wsddToMappings(InputStream wsddInput) throws QueryProcessingException {
		try {
			Document wsddDoc = XMLUtils.newDocument(wsddInput);
			Element wsddRoot = wsddDoc.getDocumentElement();
			WSDDDeployment deployment = new WSDDDeployment(wsddRoot);
			WSDDTypeMapping[] wsddMappings = deployment.getTypeMappings();
			ClassToQname[] classToQnames = new ClassToQname[wsddMappings.length];
			for (int i = 0; i < wsddMappings.length; i++) {
				ClassToQname c2q = new ClassToQname();
				QName rawQname = wsddMappings[i].getQName();
				c2q.setQname(rawQname.toString());
				String className = wsddMappings[i].getLanguageSpecificType().getName();
				c2q.setClassName(className);
				classToQnames[i] = c2q;
			}
			Mappings mappings = new Mappings();
			mappings.setMapping(classToQnames);
			return mappings;
		} catch (Exception ex) {
			throw new QueryProcessingException("Error generating class to qname mappings: " + ex.getMessage(), ex);
		}
	}
}
