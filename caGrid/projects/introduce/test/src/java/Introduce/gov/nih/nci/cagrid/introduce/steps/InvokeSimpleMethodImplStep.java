package gov.nih.nci.cagrid.introduce.steps;

import gov.nih.nci.cagrid.introduce.IntroduceTestConstants;
import gov.nih.nci.cagrid.introduce.TestCaseInfo;
import gov.nih.nci.cagrid.introduce.common.CommonTools;


public class InvokeSimpleMethodImplStep extends BaseStep {
	private TestCaseInfo tci;
	private String methodName;


	public InvokeSimpleMethodImplStep(TestCaseInfo tci, String methodName, boolean build) throws Exception {
		super(tci.getDir(),build);
		this.tci = tci;
		this.methodName = methodName;
	}


	public void runStep() throws Throwable {
		System.out.println("Invoking a simple methods implementation.");

		String cmd = CommonTools.getAntCommand("runClient",tci.getDir());
		cmd += " -Dservice.url=\"" + IntroduceTestConstants.TEST_URL +  "\"";
		Process p = CommonTools.createAndOutputProcess(cmd);
		p.waitFor();
		
		assertTrue(p.exitValue()==0);
		
		buildStep();
	}

}
