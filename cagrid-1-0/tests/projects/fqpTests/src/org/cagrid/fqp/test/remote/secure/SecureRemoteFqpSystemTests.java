package org.cagrid.fqp.test.remote.secure;

import gov.nih.nci.cagrid.testing.system.deployment.ServiceContainer;
import gov.nih.nci.cagrid.testing.system.deployment.steps.DestroyContainerStep;
import gov.nih.nci.cagrid.testing.system.deployment.steps.StopContainerStep;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cagrid.fqp.test.common.DataServiceDeploymentStory;
import org.cagrid.fqp.test.common.FQPTestingConstants;
import org.cagrid.fqp.test.common.FederatedQueryProcessorHelper;
import org.cagrid.fqp.test.common.QueryStory;
import org.cagrid.fqp.test.remote.FQPServiceDeploymentStory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * SecureRemoteFqpSystemTests
 * Tests the Federated Query Processor Service with security enabled,
 * including delegating a credential to it.
 * 
 * @author David
 */
public class SecureRemoteFqpSystemTests {
    
    private Log logger = LogFactory.getLog(SecureRemoteFqpSystemTests.class);
        
    private DataServiceDeploymentStory[] dataServiceDeployments;
    private FQPServiceDeploymentStory fqpDeployment;
    
    @Test
    public void testSecureRemoteFqpSystemTests() {
        // deploy two example SDK data services with security enabled
        // which pull from slightly different data
        DataServiceDeploymentStory exampleService1Deployment = 
            new DataServiceDeploymentStory(new File("resources/services/ExampleSdkService1.zip"), true);
        DataServiceDeploymentStory exampleService2Deployment =
            new DataServiceDeploymentStory(new File("resources/services/ExampleSdkService2.zip"), true);
        // sources of data service containers.  This allows stories to grab
        // service containers after they've been created in the order of execution
        dataServiceDeployments = new DataServiceDeploymentStory[] {
            exampleService1Deployment, exampleService2Deployment
        };
        
        exampleService1Deployment.run();
        exampleService2Deployment.run();
        
        // deploy the secure FQP service
        fqpDeployment = new FQPServiceDeploymentStory(getFqpDir(), true);
        fqpDeployment.run();
        FederatedQueryProcessorHelper queryHelper = 
            new FederatedQueryProcessorHelper(fqpDeployment);
        
        // run standard queries against the secure FQP and data services
        QueryStory queryStory = new QueryStory(dataServiceDeployments, queryHelper);
        queryStory.run();
    }
    
    
    @After
    public void cleanUp() {
        logger.debug("Cleaning Up Secure Remote FQP Tests");
        for (DataServiceDeploymentStory deployment : dataServiceDeployments) {
            ServiceContainer container = deployment.getServiceContainer();
            try {
                new StopContainerStep(container).runStep();
                new DestroyContainerStep(container).runStep();
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
        try {
            ServiceContainer fqpContainer = fqpDeployment.getServiceContainer();
            new StopContainerStep(fqpContainer).runStep();
            new DestroyContainerStep(fqpContainer).runStep();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
    
    
    private File getFqpDir() {
        String value = System.getProperty(FQPTestingConstants.FQP_DIR_PROPERTY);
        Assert.assertNotNull("System property " + FQPTestingConstants.FQP_DIR_PROPERTY + " was not set!", value);
        File dir = new File(value);
        return dir;
    }
    
    
    private File getCdsDir() {
        String value = System.getProperty(FQPTestingConstants.CDS_SERVICE_DIR_PROPERTY);
        Assert.assertNotNull("System property " + FQPTestingConstants.CDS_SERVICE_DIR_PROPERTY + " was not set!", value);
        File dir = new File(value);
        return dir;
    }
}
