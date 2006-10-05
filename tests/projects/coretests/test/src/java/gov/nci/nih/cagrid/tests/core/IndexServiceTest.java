/*
 * Created on Apr 12, 2006
 */
package gov.nci.nih.cagrid.tests.core;

import gov.nci.nih.cagrid.tests.core.steps.GlobusCleanupStep;
import gov.nci.nih.cagrid.tests.core.steps.GlobusCreateStep;
import gov.nci.nih.cagrid.tests.core.steps.GlobusDeployServiceStep;
import gov.nci.nih.cagrid.tests.core.steps.GlobusStartStep;
import gov.nci.nih.cagrid.tests.core.steps.GlobusStopStep;
import gov.nci.nih.cagrid.tests.core.steps.ServiceAdvertiseConfigStep;
import gov.nci.nih.cagrid.tests.core.steps.ServiceDiscoveryStep;
import gov.nci.nih.cagrid.tests.core.steps.SleepStep;

import java.io.File;
import java.util.Vector;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.apache.axis.types.URI.MalformedURIException;

/**
 * This is an integration test that tests the deployment of the index service and the discovery
 * of services registering to it.
 * @testType integration
 * @steps ServiceCreateStep, ServiceAdvertiseConfigStep
 * @steps GlobusCreateStep, GlobusDeployServiceStep, GlobusStartStep
 * @steps SleepStep, ServiceDiscoveryStep
 * @steps GlobusStopStep, GlobusCleanupStep
 * @author Patrick McConnell
 */
public class IndexServiceTest
	extends AbstractServiceTest
{
	public IndexServiceTest()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	protected Vector steps() 
	{
		//super.init("BasicAnalyticalServiceWithMetadata");
		super.init("BasicDataService");
		
		File indexServiceDir = new File(System.getProperty("index.dir",
			".." + File.separator + ".." + File.separator + ".." + File.separator + 
			"caGrid" + File.separator + "projects" + File.separator + "index"
		));

		Vector steps = new Vector();
		steps.add(createServiceStep);
		try {
			steps.add(new ServiceAdvertiseConfigStep(port, serviceDir));
		} catch (MalformedURIException e) {
			throw new IllegalArgumentException("could not add advertise steps", e);
		}
		steps.add(new GlobusCreateStep(globus));
		steps.add(new GlobusDeployServiceStep(globus, createServiceStep.getServiceDir()));
		steps.add(new GlobusDeployServiceStep(globus, indexServiceDir, "deployIndexGlobus"));		
		steps.add(new GlobusStartStep(globus, port));
		steps.add(new SleepStep(6000));
		try {
			steps.add(new ServiceDiscoveryStep(port, super.endpoint, super.metadataFile));
		} catch (Exception e) {
			throw new IllegalArgumentException("could not add discovery step", e);
		}
		steps.add(new GlobusStopStep(globus, port));
		steps.add(new GlobusCleanupStep(globus));
		return steps;
	}

	public String getDescription()
	{
		return "IndexServiceTest";
	}

	/**
	 * Convenience method for running all the Steps in this Story.
	 */
	public static void main(String args[]) {
		TestRunner runner = new TestRunner();
		TestResult result = runner.doRun(new TestSuite(IndexServiceTest.class));
		System.exit(result.errorCount() + result.failureCount());
	}
}
