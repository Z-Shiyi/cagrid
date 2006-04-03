package gov.nih.nci.cagrid.cadsr.service.globus.resource;

import org.apache.axis.MessageContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.globus.wsrf.Resource;
import org.globus.wsrf.impl.SingletonResourceHome;
import org.globus.wsrf.jndi.Initializable;


/**
 * This class implements a resource home
 */

public class BaseResourceHome extends SingletonResourceHome implements Initializable {

	static final Log logger = LogFactory.getLog(BaseResourceHome.class);


	public Resource findSingleton() {
		logger.info("Creating a single resource.");
		try {
			BaseResource resource = new BaseResource();
			resource.initialize();
			return resource;
		} catch (Exception e) {
			logger.error("Exception when creating the resource: " + e);
			return null;
		}
	}


	/**
	 * Initialze the singleton resource, when the home is initialized.
	 */
	public void initialize() throws Exception {
		// we need the container's transport url, in order to properly configure
		// the resource
		// not all containers have this information at initilization time
		// (globus does, tomcat doesn't), so we'll check for the url here, it
		// not initialize the resource if we don't have it.

		if (MessageContext.getCurrentContext() == null
			|| MessageContext.getCurrentContext().getProperty(MessageContext.TRANS_URL) == null) {
			logger
				.info("Unable to initialize resource during resourcehome initialization, deferring to first invocation.");
		} else {
			logger.info("Attempting to initialize resource.");
			Resource resource = findSingleton();
			if (resource == null) {
				logger.error("Unable to initialize resource!");
			} else {
				logger.info("Successfully initialized resource.");
			}
		}

	}
}