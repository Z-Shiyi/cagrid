package gov.nih.nci.cagrid.syncgts.client;

import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;
import gov.nih.nci.cagrid.syncgts.common.SyncGTSI;
import gov.nih.nci.cagrid.syncgts.stubs.SyncGTSPortType;
import gov.nih.nci.cagrid.syncgts.stubs.service.SyncGTSServiceAddressingLocator;

import java.io.InputStream;
import java.rmi.RemoteException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.ClassUtils;
import org.globus.gsi.GlobusCredential;

/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class SyncGTSClient extends ServiceSecurityClient implements SyncGTSI {
	protected SyncGTSPortType portType;
	private Object portTypeMutex;

	public SyncGTSClient(String url) throws MalformedURIException, RemoteException {
		this(url, null);
	}

	public SyncGTSClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
		super(url, proxy);
		initialize();
	}

	public SyncGTSClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
		this(epr, null);
	}

	public SyncGTSClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
		super(epr, proxy);
		initialize();
	}

	private void initialize() throws RemoteException {
		this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private SyncGTSPortType createPortType() throws RemoteException {

		SyncGTSServiceAddressingLocator locator = new SyncGTSServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = ClassUtils.getResourceAsStream(getClass(), "client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		SyncGTSPortType port = null;
		try {
			port = locator.getSyncGTSPortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	
	public static void usage(){
		System.out.println(SyncGTSClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  SyncGTSClient client = new SyncGTSClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"getServiceSecurityMetadata");
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest params = new gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest();
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataResponse boxedResult = portType.getServiceSecurityMetadata(params);
        return boxedResult.getServiceSecurityMetadata();
      }
    }

}
