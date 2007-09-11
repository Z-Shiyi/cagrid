package gov.nci.nih.cagrid.validator.steps;

import java.io.File;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.atomicobject.haste.framework.Step;

/** 
 *  AbstractBaseServiceTestStep
 *  Base step from which all service testing steps must inherit
 * 
 * @author David Ervin
 * 
 * @created Sep 5, 2007 11:47:16 AM
 * @version $Id: AbstractBaseServiceTestStep.java,v 1.2 2007-09-11 14:53:56 dervin Exp $ 
 */
public abstract class AbstractBaseServiceTestStep extends Step {
    
    private String serviceUrl;
    private File tempDir;
    private Properties configuration;
    
    /**
     * This constructor is only used to instantiate the step for the purpose of
     * calling the getRequiredConfigurationProperties() method
     */
    public AbstractBaseServiceTestStep() {
        super();
    }
    
    
    public AbstractBaseServiceTestStep(String serviceUrl, File tempDir, Properties configuration) {
        this.serviceUrl = serviceUrl;
        this.tempDir = tempDir;
        this.configuration = configuration;
    }
    
    
    /**
     * Overridden because Haste forgets what you passed in to the constructor as a name
     */
    public String getName() {
        return getClass().getName() + " for " + String.valueOf(serviceUrl);
    }
    
    
    /**
     * This method may be overriden by subclasses to return a Set
     * of the keys for configuration properties
     * required at runtime
     * 
     * @return
     *      The set of required configuration properties
     */
    public Set<String> getRequiredConfigurationProperties() {
        return new HashSet<String>();
    }
    

    public String getServiceUrl() {
        return this.serviceUrl;
    }
    
    
    public File getTempDir() {
        return this.tempDir;
    }
    
    
    public Properties getConfiguration() {
        return configuration;
    }
}
