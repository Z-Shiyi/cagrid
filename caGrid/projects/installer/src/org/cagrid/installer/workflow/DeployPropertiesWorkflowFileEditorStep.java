/**
 * 
 */
package org.cagrid.installer.workflow;

import javax.swing.Icon;

import org.cagrid.installer.steps.DeployPropertiesFileEditorStep;


/**
 * @author <a href="joshua.phillips@semanticbits.com">Joshua Phillips</a>
 *
 */
public class DeployPropertiesWorkflowFileEditorStep extends
		DeployPropertiesFileEditorStep {

	/**
	 * 
	 */
	public DeployPropertiesWorkflowFileEditorStep() {

	}

	/**
	 * @param serviceName
	 * @param name
	 * @param summary
	 * @param propertyNameColumnName
	 * @param propertyValueColumnValue
	 */
	public DeployPropertiesWorkflowFileEditorStep(String serviceName, String name,
			String summary, String propertyNameColumnName,
			String propertyValueColumnValue) {
		super(serviceName, name, summary, propertyNameColumnName,
				propertyValueColumnValue);

	}

	/**
	 * @param serviceName
	 * @param name
	 * @param summary
	 * @param propertyNameColumnName
	 * @param propertyValueColumnValue
	 * @param icon
	 */
	public DeployPropertiesWorkflowFileEditorStep(String serviceName, String name,
			String summary, String propertyNameColumnName,
			String propertyValueColumnValue, Icon icon) {
		super(serviceName, name, summary, propertyNameColumnName,
				propertyValueColumnValue, icon);

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cagrid.installer.steps.AbstractPropertiesFileEditorStep#getPropertyFilePath()
	 */
	@Override
	protected String getPropertyFilePath() {
		return this.model.getServiceDestDir() + "/"
				+ this.serviceName + "/WorkflowFactoryService" +"/deploy.properties";
	}

}
