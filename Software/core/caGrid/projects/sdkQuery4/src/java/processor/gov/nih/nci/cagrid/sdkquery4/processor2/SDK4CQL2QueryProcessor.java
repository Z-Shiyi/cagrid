package gov.nih.nci.cagrid.sdkquery4.processor2;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cql2.aggregations.Aggregation;
import gov.nih.nci.cagrid.cql2.components.CQLQuery;
import gov.nih.nci.cagrid.cql2.modifiers.CQLQueryModifier;
import gov.nih.nci.cagrid.cql2.modifiers.NamedAttribute;
import gov.nih.nci.cagrid.cql2.results.CQLAggregateResult;
import gov.nih.nci.cagrid.cql2.results.CQLAttributeResult;
import gov.nih.nci.cagrid.cql2.results.CQLObjectResult;
import gov.nih.nci.cagrid.cql2.results.CQLQueryResults;
import gov.nih.nci.cagrid.cql2.results.TargetAttribute;
import gov.nih.nci.cagrid.data.QueryProcessingException;
import gov.nih.nci.cagrid.data.cql2.CQL2QueryProcessor;
import gov.nih.nci.cagrid.metadata.dataservice.DomainModel;
import gov.nih.nci.system.applicationservice.ApplicationService;
import gov.nih.nci.system.client.ApplicationServiceProvider;
import gov.nih.nci.system.query.hibernate.HQLCriteria;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.axis.message.MessageElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cagrid.cacore.sdk4x.cql2.processor.CQL2ToParameterizedHQL;
import org.cagrid.cacore.sdk4x.cql2.processor.ParameterizedHqlQuery;
import org.globus.wsrf.Resource;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.security.SecurityManager;

public class SDK4CQL2QueryProcessor extends CQL2QueryProcessor {
    // configuration property keys
    public static final String PROPERTY_APPLICATION_NAME = "applicationName";
    public static final String PROPERTY_USE_LOCAL_API = "useLocalApiFlag";
    public static final String PROPERTY_ORM_JAR_NAME = "ormJarName"; // only for local
    public static final String PROPERTY_HOST_NAME = "applicationHostName"; // only for remote
    public static final String PROPERTY_HOST_PORT = "applicationHostPort"; // only for remote
    public static final String PROPERTY_CASE_INSENSITIVE_QUERYING = "queryCaseInsensitive";
    public static final String PROPERTY_USE_LOGIN = "useServiceLogin";
    public static final String PROPERTY_USE_GRID_IDENTITY_LOGIN = "useGridIdentityLogin";
    public static final String PROPERTY_STATIC_LOGIN_USERNAME = "staticLoginUsername";
    public static final String PROPERTY_STATIC_LOGIN_PASSWORD = "staticLoginPassword";
    
    // default values for properties
    public static final String DEFAULT_USE_LOCAL_API = String.valueOf(false);
    public static final String DEFAULT_CASE_INSENSITIVE_QUERYING = String.valueOf(false);
    public static final String DEFAULT_USE_LOGIN = String.valueOf(false);
    public static final String DEFAULT_USE_GRID_IDENTITY_LOGIN = String.valueOf(false);
    
    public static final String EMPTY_PASSWORD = "EMPTYPASSWORD";
    
    private static Log LOG = LogFactory.getLog(SDK4CQL2QueryProcessor.class);
    
    private QNameResolver qnameResolver = null;
    private CQL2ToParameterizedHQL cqlTranslator = null;

    public SDK4CQL2QueryProcessor() {
        super();
    }
    
    
    public Properties getRequiredParameters() {
        Properties props = new Properties();
        props.setProperty(PROPERTY_APPLICATION_NAME, "");
        props.setProperty(PROPERTY_HOST_NAME, "");
        props.setProperty(PROPERTY_HOST_PORT, "");
        props.setProperty(PROPERTY_ORM_JAR_NAME, "");
        props.setProperty(PROPERTY_USE_LOCAL_API, DEFAULT_USE_LOCAL_API);
        props.setProperty(PROPERTY_CASE_INSENSITIVE_QUERYING, DEFAULT_CASE_INSENSITIVE_QUERYING);
        props.setProperty(PROPERTY_USE_LOGIN, DEFAULT_USE_LOGIN);
        props.setProperty(PROPERTY_USE_GRID_IDENTITY_LOGIN, DEFAULT_USE_GRID_IDENTITY_LOGIN);
        props.setProperty(PROPERTY_STATIC_LOGIN_USERNAME, "");
        props.setProperty(PROPERTY_STATIC_LOGIN_PASSWORD, "");
        return props;
    }

    
    public CQLQueryResults processQuery(CQLQuery query) throws QueryProcessingException {
        CQLQuery runQuery = query;
        if (runQuery.getCQLQueryModifier() != null && runQuery.getCQLQueryModifier().getNamedAttribute() != null) {
            // HQL will return distinct tuples of attribute names, so we need to include
            // the id attribute in those tuples to get a 1:1 correspondence with
            // actual data instances in the database
            try {
                runQuery = (CQLQuery) Utils.cloneBean(query, CQLQuery.getTypeDesc().getXmlType());
                NamedAttribute[] namedAttributes = runQuery.getCQLQueryModifier().getNamedAttribute();
                NamedAttribute idAttribute = new NamedAttribute("id");
                namedAttributes = (NamedAttribute[]) Utils.appendToArray(namedAttributes, idAttribute);
                runQuery.getCQLQueryModifier().setNamedAttribute(namedAttributes);
            } catch (Exception ex) {
                String message = "Error pre-processing query modifier attribute names: " + ex.getMessage();
                LOG.error(message, ex);
                throw new QueryProcessingException(message, ex);
            }
        }
        // get an instance of the caCORE SDK ApplicationService
        ApplicationService sdkService = getApplicationService();
        
        // empty results object
        CQLQueryResults queryResults = new CQLQueryResults();
        queryResults.setTargetClassname(query.getCQLTargetObject().getClassName());
        
        // convert the CQL to HQL
        LOG.debug("Converting CQL query to HQL");
        ParameterizedHqlQuery hql = null;
        try {
            hql = getCqlTranslator().convertToHql(runQuery);
            LOG.debug("Created HQL: " + hql.toString());
        } catch (QueryProcessingException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new QueryProcessingException("Error processing query: " + ex.getMessage(), ex);
        }
        
        HQLCriteria criteria = new HQLCriteria(hql.getHql(), hql.getParameters());
        
        // query the SDK
        LOG.debug("Querying application service");
        List<Object> rawResults = null;
        try {
            rawResults = sdkService.query(criteria);
        } catch (Exception ex) {
            throw new QueryProcessingException("Error querying caCORE service: " + ex.getMessage(), ex);
        }
        LOG.debug("Results obtained from application service");
        
        // see if there is further processing to be done
        if (runQuery.getCQLQueryModifier() != null) {
            LOG.debug("Post-processing query modifiers");
            CQLQueryModifier mods = runQuery.getCQLQueryModifier();
            if (mods.getNamedAttribute() != null) {
                LOG.debug("Detected named attribute results");
                // trim off the extra id attribute we added earlier
                String[] attributeNames = new String[mods.getNamedAttribute().length];
                attributeNames = (String[]) Utils.trimArray(attributeNames, 0, attributeNames.length);
                List<Object[]> attributeValues = new LinkedList<Object[]>();
                Iterator<?> rawResultIter = rawResults.iterator();
                while (rawResultIter.hasNext()) {
                    Object[] rawValues = (Object[]) rawResultIter.next();
                    Object[] cleanValues = (Object[]) Utils.trimArray(rawValues, 0, rawValues.length - 1);
                    attributeValues.add(cleanValues);
                }
                CQLAttributeResult[] attributeResults = createAttributeResult(attributeNames, attributeValues);
                queryResults.setAttributeResult(attributeResults);
            } else if (mods.getCountOnly() != null) {
                LOG.debug("Detected count only aggregate results");
                Object resultValue = rawResults.size() != 0 ? rawResults.get(0) : null;
                String valueAsString = attributeValueAsString(resultValue);
                CQLAggregateResult aggResult = createAggregateResult(
                    Aggregation.COUNT, "id", valueAsString);
                queryResults.setAggregationResult(aggResult);
            } else if (mods.getDistinctAttribute() != null) {
                LOG.debug("Detected discinct attribute results");
                if (mods.getDistinctAttribute().getAggregation() != null) {
                    LOG.debug("Detected aggregate results");
                    Aggregation agg = mods.getDistinctAttribute().getAggregation();
                    Object resultValue = rawResults.size() != 0 ? rawResults.get(0) : null;
                    String valueAsString = attributeValueAsString(resultValue);
                    CQLAggregateResult aggResult = createAggregateResult(
                        agg, mods.getDistinctAttribute().getAttributeName(), valueAsString);
                    queryResults.setAggregationResult(aggResult);
                } else {
                    // standard attribute name / value pairs
                    // using a list since .size() on the SDK's list-proxy is expensive
                    List<Object[]> attributeValues = new LinkedList<Object[]>();
                    Iterator<?> rawResultIter = rawResults.iterator();
                    while (rawResultIter.hasNext()) {
                        attributeValues.add(new Object[] {rawResultIter.next()});
                    }
                    CQLAttributeResult[] attributeResults = createAttributeResult(
                        new String[] {mods.getDistinctAttribute().getAttributeName()}, attributeValues);
                    queryResults.setAttributeResult(attributeResults);
                }
            }
        } else {
            LOG.debug("Detected object results");
            QName targetQName = null;
            try {
                targetQName = getQNameResolver().getQName(query.getCQLTargetObject().getClassName());
            } catch (Exception ex) {
                throw new QueryProcessingException("Error obtaining QName for target data type: " + ex.getMessage(), ex);
            }
            CQLObjectResult[] objectResults = createObjectResults(rawResults, targetQName);
            queryResults.setObjectResult(objectResults);
        }
        
        return queryResults;
    }
    
    
    private CQL2ToParameterizedHQL getCqlTranslator() throws Exception {
        if (cqlTranslator == null) {
            cqlTranslator = new CQL2ToParameterizedHQL(
                getDomainModel(), useCaseInsensitiveQueries());
        }
        return cqlTranslator;
    }
    
    
    private CQLObjectResult[] createObjectResults(List<Object> rawObjects, QName targetQName) throws QueryProcessingException {
        CQLObjectResult[] objectResults = new CQLObjectResult[rawObjects.size()];
        int resultIndex = 0;
        try {
            Iterator<?> rawIter = rawObjects.iterator();
            while (rawIter.hasNext()) {
                Object rawObject = rawIter.next();
                MessageElement elem = null;
                if (targetQName != null) {
                    elem = new MessageElement(targetQName, rawObject);
                } else {
                    elem = new MessageElement();
                    elem.setObjectValue(rawObject);
                }
                objectResults[resultIndex] = new CQLObjectResult(new MessageElement[] {elem});
                resultIndex++;
            }
        } catch (SOAPException ex) {
            throw new QueryProcessingException("Error creating object message elements: " + ex.getMessage(), ex);
        }
        return objectResults;
    }
    
    
    private CQLAggregateResult createAggregateResult(
        Aggregation agg, String attributeName, String value) {
        CQLAggregateResult result = new CQLAggregateResult();
        result.setAggregation(agg);
        result.setAttributeName(attributeName);
        result.setValue(value);
        return result;
    }
    
    
    private CQLAttributeResult[] createAttributeResult(String[] attributeNames, List<Object[]> attributeValues) {
        CQLAttributeResult[] results = new CQLAttributeResult[attributeValues.size()];
        int resultIndex = 0;
        for (Object[] values : attributeValues) {
            CQLAttributeResult result = new CQLAttributeResult();
            TargetAttribute[] ta = new TargetAttribute[attributeNames.length];
            for (int i = 0; i < attributeNames.length; i++) {
                Object val = values[i];
                ta[i] = new TargetAttribute(attributeNames[i], attributeValueAsString(val));
            }
            result.setAttribute(ta);
            results[resultIndex] = result;
            resultIndex++;
        }
        return results;
    }
    
    
    private String attributeValueAsString(Object val) {
        String valAsString = null;
        if (val != null) {
            if (val instanceof Date) {
                valAsString = DateFormat.getDateTimeInstance().format((Date) val);
            } else {
                valAsString = String.valueOf(val);
            }
        }
        return valAsString;
    }
    
    
    private ApplicationService getApplicationService() throws QueryProcessingException {
        LOG.debug("Obtaining application service instance");
        ApplicationService service = null;
        
        boolean useLocal = useLocalApplicationService();
        boolean useLogin = useServiceLogin();
        boolean useStaticLogin = useStaticLogin();
        try {
            String username = null;
            String passwd = null;
            if (useLogin) {
                if (useStaticLogin) {
                    LOG.trace("Application service using static login");
                    username = getConfiguredParameters().getProperty(PROPERTY_STATIC_LOGIN_USERNAME);
                    passwd = username = getConfiguredParameters().getProperty(PROPERTY_STATIC_LOGIN_PASSWORD);
                } else {
                    LOG.trace("Application service using caller identity login");
                    SecurityManager securityManager = SecurityManager.getManager();
                    username = securityManager.getCaller();
                    passwd = EMPTY_PASSWORD;
                }
            }
            
            if (useLocal) {
                LOG.trace("Application service using local API");
                if (useLogin) {
                    service = ApplicationServiceProvider.getApplicationService(username, passwd);
                } else {
                    service = ApplicationServiceProvider.getApplicationService();   
                }
            } else {
                String url = getRemoteApplicationUrl();
                LOG.trace("Application service using remote API at " + url);
                if (useLogin) {
                    service = ApplicationServiceProvider.getApplicationServiceFromUrl(url, username, passwd);
                } else {
                    service = ApplicationServiceProvider.getApplicationServiceFromUrl(url);   
                }
            }
        } catch (Exception ex) {
            throw new QueryProcessingException("Error obtaining application service instance: " + ex.getMessage(), ex);
        }
        
        return service;
    }
    
    
    private QNameResolver getQNameResolver() throws Exception {
        if (qnameResolver == null) {
            qnameResolver = new MappingFileQNameResolver(getClassToQnameMappings());
        }
        return qnameResolver;
    }
    
    
    private String getRemoteApplicationUrl() {
        String hostname = getConfiguredParameters().getProperty(PROPERTY_HOST_NAME);
        String port = getConfiguredParameters().getProperty(PROPERTY_HOST_PORT);
        while (hostname.endsWith("/")) {
            hostname = hostname.substring(0, hostname.length() - 1);
        }
        String urlPart = hostname + ":" + port;
        urlPart += "/";
        urlPart += getConfiguredParameters().getProperty(PROPERTY_APPLICATION_NAME);
        return urlPart;
    }
    
    
    private boolean useCaseInsensitiveQueries() throws QueryProcessingException {
        String caseInsensitiveValue = getConfiguredParameters().getProperty(PROPERTY_CASE_INSENSITIVE_QUERYING);
        try {
            return Boolean.parseBoolean(caseInsensitiveValue);
        } catch (Exception ex) {
            throw new QueryProcessingException("Error determining case insensitivity: " + ex.getMessage(), ex);
        }
    }
    
    
    private boolean useLocalApplicationService() throws QueryProcessingException {
        String useLocalValue = getConfiguredParameters().getProperty(PROPERTY_USE_LOCAL_API);
        try {
            return Boolean.parseBoolean(useLocalValue);
        } catch (Exception ex) {
            throw new QueryProcessingException("Error determining local application service use: " + ex.getMessage(), ex);
        }
    }
    
    
    private boolean useServiceLogin() throws QueryProcessingException {
        String useLoginValue = getConfiguredParameters().getProperty(PROPERTY_USE_LOGIN);
        try {
            return Boolean.parseBoolean(useLoginValue);
        } catch (Exception ex) {
            throw new QueryProcessingException("Error determining login use flag: " + ex.getMessage(), ex);
        }
    }
    
    
    private boolean useStaticLogin() throws QueryProcessingException {
        String useGridIdentLogin = getConfiguredParameters().getProperty(PROPERTY_USE_GRID_IDENTITY_LOGIN);
        try {
            return !Boolean.parseBoolean(useGridIdentLogin);
        } catch (Exception ex) {
            throw new QueryProcessingException("Error determining use of static login: " + ex.getMessage(), ex);
        }
    }
    
    
    private DomainModel getDomainModel() throws Exception {
        DomainModel domainModel = null;
        Resource serviceBaseResource = ResourceContext.getResourceContext().getResource();
        Method[] resourceMethods = serviceBaseResource.getClass().getMethods();
        for (int i = 0; i < resourceMethods.length; i++) {
            if (resourceMethods[i].getReturnType() != null 
                && resourceMethods[i].getReturnType().equals(DomainModel.class)) {
                domainModel = (DomainModel) resourceMethods[i].invoke(serviceBaseResource, new Object[] {});
                break;
            }
        }
        return domainModel;
    }
}
