/**
 * 
 */
package org.cagrid.installer.cds;

import java.util.Map;
import java.util.Properties;

import org.cagrid.installer.model.CaGridInstallerModel;
import org.cagrid.installer.steps.Constants;
import org.cagrid.installer.tasks.AntTask;
import org.cagrid.installer.tasks.CaGridInstallerAntTask;

/**
 * @author <a href="joshua.phillips@semanticbits.com">Joshua Phillips</a>
 * 
 */
public class ConfigureCDSTask extends CaGridInstallerAntTask {

	/**
	 * @param name
	 * @param description
	 * @param targetName
	 */
	public ConfigureCDSTask(String name, String description) {
		super(name, description, null);
	}

	protected Object runAntTask(CaGridInstallerModel model, String target,
			Map<String, String> env, Properties sysProps) throws Exception {

		model.setProperty(Constants.BUILD_FILE_PATH, getBuildFilePath(model));
		new AntTask("", "", "configure-cds-properties", env, sysProps)
				.execute(model);

		model.setProperty(Constants.BUILD_FILE_PATH, model.getServiceDestDir()
				+ "/cds/build.xml");
		model.setProperty("gridId.input", model
				.getProperty(Constants.CDS_ADMIN_IDENT));
		new AntTask("", "", "addAdmin", env, sysProps).execute(model);
		return null;
	}

}
