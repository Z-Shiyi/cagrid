/**
 * 
 */
package org.cagrid.installer.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.security.cert.X509Certificate;

import org.cagrid.installer.steps.Constants;

/**
 * @author <a href="mailto:joshua.phillips@semanticbits.com">Joshua Phillips</a>
 * 
 */
public class GenerateServiceCredsTask extends CaGridInstallerAntTask {

	/**
	 * @param name
	 * @param description
	 */
	public GenerateServiceCredsTask(String name, String description) {
		super(name, description, "generate-host-creds");
	}

	protected Object runAntTask(Map state, String target, Map env,
			Properties sysProps) throws Exception {

		// Need to ensure that we have a valid value for days valid.
		if (!state.containsKey(Constants.CA_DAYS_VALID)) {
			
			//Then we need to load it from the certificate
			File f = new File((String) state.get(Constants.CA_CERT_PATH));
			if(!f.exists()){
				throw new RuntimeException("Certificate at '" + f.getAbsolutePath() + "' not found.");
			}
			X509Certificate cert = X509Certificate.getInstance(new FileInputStream(f));
			Date now = new Date();
			Date notAfter = cert.getNotAfter();
			if(notAfter.before(now)){
				throw new RuntimeException("The certificate is already expired.");
			}
			int diffInDays = (int) ((notAfter.getTime() - now.getTime())/(1000*60*60*24));
			state.put(Constants.SERVICE_CERT_DAYS_VALID, String.valueOf(diffInDays));
		}

		new AntTask("", "", target, env, sysProps).execute(state);

		return null;
	}

}
