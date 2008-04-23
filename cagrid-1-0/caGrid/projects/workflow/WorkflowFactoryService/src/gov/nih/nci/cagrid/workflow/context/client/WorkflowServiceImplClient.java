package gov.nih.nci.cagrid.workflow.context.client;

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

import gov.nih.nci.cagrid.workflow.context.stubs.WorkflowServiceImplPortType;
import gov.nih.nci.cagrid.workflow.context.stubs.service.WorkflowServiceImplServiceAddressingLocator;
import gov.nih.nci.cagrid.workflow.context.stubs.types.CannotCancelWorkflowFault;
import gov.nih.nci.cagrid.workflow.context.stubs.types.CannotPauseWorkflowFault;
import gov.nih.nci.cagrid.workflow.context.common.WorkflowServiceImplI;
import gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * On construction the class instance will contact the remote service and
 * retrieve it's security metadata description which it will use to configure
 * the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class WorkflowServiceImplClient extends ServiceSecurityClient implements WorkflowServiceImplI {
	protected WorkflowServiceImplPortType portType;
	private Object portTypeMutex;

	public WorkflowServiceImplClient(String url) throws MalformedURIException, RemoteException {
		this(url, null);
	}

	public WorkflowServiceImplClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
		super(url, proxy);
		initialize();
	}

	public WorkflowServiceImplClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
		this(epr, null);
	}

	public WorkflowServiceImplClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException,
		RemoteException {
		super(epr, proxy);
		initialize();
	}

	private void initialize() throws RemoteException {
		this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private WorkflowServiceImplPortType createPortType() throws RemoteException {

		WorkflowServiceImplServiceAddressingLocator locator = new WorkflowServiceImplServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = ClassUtils.getResourceAsStream(getClass(), "client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		WorkflowServiceImplPortType port = null;
		try {
			port = locator.getWorkflowServiceImplPortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}

	public WorkflowServiceImplPortType getPort() {
		if (this.portType != null) {
			return this.portType;
		} else {
			return null;
		}
	}
	public static void usage() {
		System.out.println(WorkflowServiceImplClient.class.getName() + " -url <service url>");
	}

	public static void main(String[] args) {
		System.out.println("Running the Grid Service Client");
		try {
			if (!(args.length < 2)) {
				if (args[0].equals("-url")) {
					WorkflowServiceImplClient client = new WorkflowServiceImplClient(args[1]);
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
			System.exit(1);
		}
	}

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"destroy");
    return portType.destroy(params);
    }
  }

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"setTerminationTime");
    return portType.setTerminationTime(params);
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

  public gov.nih.nci.cagrid.workflow.stubs.types.WorkflowStatusType start(gov.nih.nci.cagrid.workflow.stubs.types.StartInputType startInputElement) throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException, gov.nih.nci.cagrid.workflow.context.stubs.types.StartCalledOnStartedWorkflow {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"start");
    gov.nih.nci.cagrid.workflow.context.stubs.StartRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.StartRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.StartRequestStartInputElement startInputElementContainer = new gov.nih.nci.cagrid.workflow.context.stubs.StartRequestStartInputElement();
    startInputElementContainer.setStartInputElement(startInputElement);
    params.setStartInputElement(startInputElementContainer);
    gov.nih.nci.cagrid.workflow.context.stubs.StartResponse boxedResult = portType.start(params);
    return boxedResult.getWorkflowStatusElement();
    }
  }

  public gov.nih.nci.cagrid.workflow.stubs.types.WorkflowStatusType getStatus() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getStatus");
    gov.nih.nci.cagrid.workflow.context.stubs.GetStatusRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.GetStatusRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.GetStatusResponse boxedResult = portType.getStatus(params);
    return boxedResult.getWorkflowStatusElement();
    }
  }

  public gov.nih.nci.cagrid.workflow.stubs.types.WorkflowStatusType pause() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotPauseWorkflowFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"pause");
    gov.nih.nci.cagrid.workflow.context.stubs.PauseRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.PauseRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.PauseResponse boxedResult = portType.pause(params);
    return boxedResult.getWorkflowStatusElement();
    }
  }

  public gov.nih.nci.cagrid.workflow.stubs.types.WorkflowStatusType resume() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotResumeWorkflowFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"resume");
    gov.nih.nci.cagrid.workflow.context.stubs.ResumeRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.ResumeRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.ResumeResponse boxedResult = portType.resume(params);
    return boxedResult.getWorkflowStatusElement();
    }
  }

  public void cancel() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException, gov.nih.nci.cagrid.workflow.context.stubs.types.CannotCancelWorkflowFault {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"cancel");
    gov.nih.nci.cagrid.workflow.context.stubs.CancelRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.CancelRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.CancelResponse boxedResult = portType.cancel(params);
    }
  }

  public gov.nih.nci.cagrid.workflow.stubs.types.WorkflowOutputType getWorkflowOutput() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getWorkflowOutput");
    gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.GetWorkflowOutputResponse boxedResult = portType.getWorkflowOutput(params);
    return boxedResult.getWorkflowOutputElement();
    }
  }

  public gov.nih.nci.cagrid.workflow.stubs.types.WorkflowStatusEventType[] getDetailedStatus() throws RemoteException, gov.nih.nci.cagrid.workflow.stubs.types.WorkflowException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getDetailedStatus");
    gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusRequest params = new gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusRequest();
    gov.nih.nci.cagrid.workflow.context.stubs.GetDetailedStatusResponse boxedResult = portType.getDetailedStatus(params);
    return boxedResult.getDetailedStatusOutputElement();
    }
  }

}
