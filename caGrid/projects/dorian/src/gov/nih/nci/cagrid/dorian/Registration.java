package gov.nih.nci.cagrid.gums;

import gov.nih.nci.cagrid.gums.bean.GUMSInternalFault;
import gov.nih.nci.cagrid.gums.common.GUMSException;
import gov.nih.nci.cagrid.gums.ifs.bean.AttributeDescriptor;
import gov.nih.nci.cagrid.gums.ifs.bean.InvalidApplicationFault;
import gov.nih.nci.cagrid.gums.ifs.bean.UserApplication;

/**
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Langella </A>
 * @version $Id: Registration.java,v 1.4 2005-10-18 23:23:48 langella Exp $
 */
public interface Registration {
	public AttributeDescriptor[] getRequiredUserAttributes() throws GUMSInternalFault,GUMSException;
	public String registerUser(UserApplication application) throws InvalidApplicationFault, GUMSInternalFault,GUMSException;
}
