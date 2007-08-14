package gov.nih.nci.cagrid.data.style;

import gov.nih.nci.cagrid.introduce.beans.extension.ServiceExtensionDescriptionType;
import gov.nih.nci.cagrid.introduce.common.ServiceInformation;

/** 
 *  StyleCodegenPostProcessor
 *  Post processor for style codegen
 * 
 * @author David Ervin
 * 
 * @created Jul 10, 2007 10:49:21 AM
 * @version $Id: StyleCodegenPostProcessor.java,v 1.1.2.1 2007-08-14 14:42:01 dervin Exp $ 
 */
public interface StyleCodegenPostProcessor {

    public void codegenPostProcessStyle(ServiceExtensionDescriptionType desc, ServiceInformation info) throws Exception;
}
