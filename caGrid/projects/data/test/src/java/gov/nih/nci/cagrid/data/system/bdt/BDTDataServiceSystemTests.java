package gov.nih.nci.cagrid.data.system.bdt;

import gov.nih.nci.cagrid.data.creation.DataTestCaseInfo;
import gov.nih.nci.cagrid.data.creation.bdt.BDTDataServiceCreationTests;
import gov.nih.nci.cagrid.data.system.AddBookstoreStep;
import gov.nih.nci.cagrid.data.system.BaseSystemTest;
import gov.nih.nci.cagrid.data.system.CreateCleanGlobusStep;
import gov.nih.nci.cagrid.data.system.DeployDataServiceStep;
import gov.nih.nci.cagrid.data.system.DestroyTempGlobusStep;
import gov.nih.nci.cagrid.data.system.EnableValidationStep;
import gov.nih.nci.cagrid.data.system.RebuildServiceStep;
import gov.nih.nci.cagrid.data.system.SetQueryProcessorStep;
import gov.nih.nci.cagrid.data.system.StartGlobusStep;
import gov.nih.nci.cagrid.data.system.StopGlobusStep;
import gov.nih.nci.cagrid.introduce.IntroduceConstants;
import gov.nih.nci.cagrid.introduce.test.IntroduceTestConstants;
import gov.nih.nci.cagrid.introduce.tests.deployment.PortPreference;
import gov.nih.nci.cagrid.introduce.tests.deployment.ServiceContainer;
import gov.nih.nci.cagrid.introduce.tests.deployment.ServiceContainerFactory;
import gov.nih.nci.cagrid.introduce.tests.deployment.ServiceContainerType;

import java.io.File;
import java.util.Vector;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import com.atomicobject.haste.framework.Step;

/** 
 *  BDTDataServiceSystemTests
 *  System tests for BDT Data Service
 * 
 * @author David Ervin
 * 
 * @created Mar 14, 2007 2:19:42 PM
 * @version $Id: BDTDataServiceSystemTests.java,v 1.6 2007-10-18 18:57:44 dervin Exp $ 
 */
public class BDTDataServiceSystemTests extends BaseSystemTest {
    
    private static ServiceContainer container = null;
    
    static {
        try {
            PortPreference ports = new PortPreference(
                Integer.valueOf(IntroduceTestConstants.TEST_PORT + 601), 
                Integer.valueOf(IntroduceTestConstants.TEST_PORT + 1101), null);
            container = ServiceContainerFactory.createContainer(ServiceContainerType.GLOBUS_CONTAINER, null, ports);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Failed to create container: " + ex.getMessage());
        }
    }
    
	
	public String getDescription() {
		return "System tests for BDT Data Service";
	}
    
    
    public String getName() {
        return "BDT Data Service System Tests";
    }
	
	
	protected boolean storySetUp() {
		// verify the BDT service has been built
		File serviceDir = new File(BDTDataServiceCreationTests.SERVICE_DIR);
		assertTrue("BDT Data Service directory NOT FOUND", serviceDir.exists());
		File serviceModel = new File(serviceDir.getAbsolutePath() 
			+ File.separator + IntroduceConstants.INTRODUCE_XML_FILE);
		assertTrue("BDT Data Service directory does not appear to be an Introduce service", 
			serviceModel.exists());
        
        // unpack the container
        Step unpack = new CreateCleanGlobusStep(container);
        try {
            unpack.runStep();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
		return true;
	}


	protected Vector steps() {
        DataTestCaseInfo info = new BDTDataServiceCreationTests.TestBDTDataServiceInfo();
		Vector<Step> steps = new Vector<Step>();
		// assumes the BDT service has been created already
		// 1) Add the bookstore schema to the data service
		steps.add(new AddBookstoreStep(info));
		// 2) change out query processor
		steps.add(new SetQueryProcessorStep(BDTDataServiceCreationTests.SERVICE_DIR));
		// 3) Turn on query validation
		steps.add(new EnableValidationStep(BDTDataServiceCreationTests.SERVICE_DIR));
		// 4) Rebuild the service to pick up the bookstore beans
		steps.add(new RebuildServiceStep(info, getIntroduceBaseDir()));
		// 5) deploy data service
		steps.add(new DeployDataServiceStep(container, BDTDataServiceCreationTests.SERVICE_DIR));
		// 6) start the container
		steps.add(new StartGlobusStep(container));
		// 7) test bdt data service
		steps.add(new InvokeBDTDataServiceStep("localhost", 
            BDTDataServiceCreationTests.SERVICE_NAME, container.getProperties().getPortPreference()));
		return steps;
	}
	
	
	protected void storyTearDown() throws Throwable {
		super.storyTearDown();
		// 8) stop globus
		Step stopStep = new StopGlobusStep(container);
		try {
			stopStep.runStep();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
		// 10) throw away globus
		Step destroyStep = new DestroyTempGlobusStep(container);
		try {
			destroyStep.runStep();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		TestResult result = runner.doRun(new TestSuite(
				BDTDataServiceSystemTests.class));
		System.exit(result.errorCount() + result.failureCount());
	}
}
