<%@ page package="gov.nih.nci.cagrid.introduce.templates.client" class="ServiceClientTemplate" import="gov.nih.nci.cagrid.introduce.*,gov.nih.nci.cagrid.introduce.common.*"%>
<% gov.nih.nci.cagrid.introduce.common.SpecificServiceInformation info = (gov.nih.nci.cagrid.introduce.common.SpecificServiceInformation) argument; 
   String mainServiceName = info.getIntroduceServiceProperties().getProperty("introduce.skeleton.service.name");
   String serviceName = info.getService().getName();
   String namespaceDomain = info.getIntroduceServiceProperties().getProperty(gov.nih.nci.cagrid.introduce.IntroduceConstants.INTRODUCE_SKELETON_NAMESPACE_DOMAIN);
   String mainModifiedServiceName = mainServiceName;
   if(mainServiceName.endsWith("Service")){
   	mainModifiedServiceName = mainServiceName.substring(0,mainServiceName.length()-7);
   }
   String modifiedServiceName = serviceName;
   if(serviceName.endsWith("Service")){
   	modifiedServiceName = serviceName.substring(0,serviceName.length()-7);
   }
%>
package <%=info.getService().getPackageName()%>.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import <%=info.getService().getPackageName()%>.stubs.<%=serviceName%>PortType;
import <%=info.getService().getPackageName()%>.stubs.service.<%=modifiedServiceName%>ServiceAddressingLocator;
import <%=info.getService().getPackageName()%>.common.<%=serviceName%>I;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;


/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version <%=CommonTools.getIntroduceVersion()%>
 */
public class <%=info.getService().getName()%>ClientBase extends ServiceSecurityClient {	
	protected <%=info.getService().getName()%>PortType portType;
	protected Object portTypeMutex;

	public <%=info.getService().getName()%>ClientBase(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public <%=info.getService().getName()%>ClientBase(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private <%=info.getService().getName()%>PortType createPortType() throws RemoteException {

		<%=modifiedServiceName%>ServiceAddressingLocator locator = new <%=modifiedServiceName%>ServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = getClass().getResourceAsStream("client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		<%=info.getService().getName()%>PortType port = null;
		try {
			port = locator.get<%=info.getService().getName()%>PortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	
	public GetResourcePropertyResponse getResourceProperty(QName resourcePropertyQName) throws RemoteException {
		return portType.getResourceProperty(resourcePropertyQName);
	}


}