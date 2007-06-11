package gov.nih.nci.cagrid.fqp.service.globus.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.globus.wsrf.Resource;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.impl.SingletonResourceHome;
import org.globus.wsrf.jndi.Initializable;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceContextException;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements the resource home for the resource type represented
 * by this service.
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class BaseResourceHome extends SingletonResourceHome implements Initializable {

	static final Log logger = LogFactory.getLog(BaseResourceHome.class);


	public Resource findSingleton() {
		logger.info("Creating a single resource.");
		try {
			FederatedQueryProcessorResource resource = new FederatedQueryProcessorResource();
			resource.initialize();
			return resource;
		} catch (Exception e) {
			logger.error("Exception when creating the resource: " + e);
			return null;
		}
	}
	
	public FederatedQueryProcessorResource getResource(){
		FederatedQueryProcessorResource serviceBaseResource;
		try {
			serviceBaseResource = (FederatedQueryProcessorResource)ResourceContext.getResourceContext().getResource();
		} catch (ResourceContextException e) {
			return null;
		} catch (ResourceException e) {
			return null;
		}
		return serviceBaseResource;
	}


	public Resource find(ResourceKey key) throws ResourceException {
		FederatedQueryProcessorResource resource = (FederatedQueryProcessorResource) super.find(key);
		// each time the resource is looked up, do a lazy refreash of
		// registration.
		resource.refreshRegistration(false);
		return resource;
	}


	/**
	 * Initialze the singleton resource, when the home is initialized.
	 */
	public void initialize() throws Exception {
		logger.info("Attempting to initialize resource.");
		Resource resource = find(null);
		if (resource == null) {
			logger.error("Unable to initialize resource!");
		} else {
			logger.info("Successfully initialized resource.");
		}
	}
	
    /**
     * Get the resouce that is being addressed in this current context
     */
    public FederatedQueryProcessorResource getAddressedResource() throws Exception {
        FederatedQueryProcessorResource thisResource;
        thisResource = (FederatedQueryProcessorResource) ResourceContext.getResourceContext().getResource();
        return thisResource;
    }
}