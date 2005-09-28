package gov.nih.nci.cagrid.gums.client.wsrf;

import gov.nih.nci.cagrid.gums.Registration;
import gov.nih.nci.cagrid.gums.bean.AttributeDescriptor;
import gov.nih.nci.cagrid.gums.bean.GUMSInternalFault;
import gov.nih.nci.cagrid.gums.bean.InvalidApplicationFault;
import gov.nih.nci.cagrid.gums.bean.UserApplication;
import gov.nih.nci.cagrid.gums.common.GUMSException;
import gov.nih.nci.cagrid.gums.wsrf.GUMSPortType;
import gov.nih.nci.cagrid.gums.wsrf.RequiredUserAttributes;
import gov.nih.nci.cagrid.security.commstyle.AnonymousSecureConversationWithEncryption;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

/**
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Langella </A>
 * @version $Id: JanusRegistrationClient.java,v 1.1 2005/09/26 20:22:20 langella
 *          Exp $
 */
public class GUMSRegistrationClient extends GUMSBaseClient implements
		Registration {

	public GUMSRegistrationClient(String serviceURI) {
		super(serviceURI);
	}

	public AttributeDescriptor[] getRequiredUserAttributes()
			throws GUMSInternalFault, GUMSException {
		GUMSPortType port = null;
		try {
			port = this
					.getPort(new AnonymousSecureConversationWithEncryption());

		}catch (Exception e) {
			e.printStackTrace();
			throw new GUMSException(e.getMessage());
		}
		try {
			return port.getRequiredUserAttributes(new RequiredUserAttributes())
					.getAttributeDescriptors();
		} catch(GUMSInternalFault gie){
			throw gie;
		}catch(AxisFault fault){
			fault.printStackTrace();
			throw new GUMSException(simplifyMessage(fault.getFaultString()));
		}catch (RemoteException e) {
			e.printStackTrace();
			throw new GUMSException(simplifyMessage(e.getMessage()));
		}
	}

	public String registerUser(UserApplication application) throws InvalidApplicationFault, GUMSInternalFault,GUMSException {
		GUMSPortType port = null;
		try {
			port = this
					.getPort(new AnonymousSecureConversationWithEncryption());

		}catch (Exception e) {
			e.printStackTrace();
			throw new GUMSException(e.getMessage());
		}
		try {
			return port.registerUser(application);
		} catch(GUMSInternalFault gie){
			throw gie;
		}catch(AxisFault fault){
			fault.printStackTrace();
			throw new GUMSException(simplifyMessage(fault.getFaultString()));
		}catch (RemoteException e) {
			e.printStackTrace();
			throw new GUMSException(simplifyMessage(e.getMessage()));
		}
	}
	
	

}
