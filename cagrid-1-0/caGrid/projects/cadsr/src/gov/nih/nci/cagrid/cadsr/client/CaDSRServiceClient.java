package gov.nih.nci.cagrid.cadsr.client;

import gov.nih.nci.cadsr.umlproject.domain.Project;
import gov.nih.nci.cagrid.cadsr.common.CaDSRServiceI;
import gov.nih.nci.cagrid.cadsr.stubs.CaDSRServicePortType;
import gov.nih.nci.cagrid.cadsr.stubs.service.CaDSRServiceAddressingLocator;

import java.rmi.RemoteException;

import org.apache.axis.message.addressing.Address;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.globus.gsi.GlobusCredential;


/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by caGrid toolkit version 0.5
 */
public class CaDSRServiceClient implements CaDSRServiceI {

	private CaDSRServiceAddressingLocator locator;
	private GlobusCredential proxy;
	private String url;


	public CaDSRServiceClient(String url) {
		this(url, null);
	}


	public CaDSRServiceClient(String url, GlobusCredential proxy) {
		this.proxy = proxy;
		this.url = url;
	}


	private CaDSRServicePortType getPortType() {
		try {
			CaDSRServiceAddressingLocator locator = new CaDSRServiceAddressingLocator();
			EndpointReferenceType endpoint = new EndpointReferenceType();
			endpoint.setAddress(new Address(url));
			CaDSRServicePortType port = locator.getCaDSRServicePortTypePort(endpoint);
			return port;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void usage() {
		System.out.println(CaDSRServiceClient.class.getName() + " -gsh [gsh]");
	}


	public static void main(String[] args) {
		try {
			if (!(args.length < 2)) {
				if (args[0].equals("-gsh")) {
					CaDSRServiceClient client = new CaDSRServiceClient(args[1]);
					// place client calls here if you want to use this main as a
					// test....

					Project[] projs = client.findAllProjects();
					for (int i = 0; i < projs.length; i++) {
						System.out.println(projs[i].getShortName());
					}

					projs = client.findProjects("caBIG");
					for (int i = 0; i < projs.length; i++) {
						System.out.println(projs[i].getShortName());
					}
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


	public gov.nih.nci.cadsr.umlproject.domain.Project[] findAllProjects() throws RemoteException {
		CaDSRServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		gov.nih.nci.cagrid.cadsr.stubs.FindAllProjects params = new gov.nih.nci.cagrid.cadsr.stubs.FindAllProjects();
		gov.nih.nci.cagrid.cadsr.stubs.FindAllProjectsResponse boxedResult = port.findAllProjects(params);
		return boxedResult.getProject();

	}


	public gov.nih.nci.cadsr.umlproject.domain.Project[] findProjects(String context) throws RemoteException {
		CaDSRServicePortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

		gov.nih.nci.cagrid.cadsr.stubs.FindProjects params = new gov.nih.nci.cagrid.cadsr.stubs.FindProjects();
		params.setContext(context);
		gov.nih.nci.cagrid.cadsr.stubs.FindProjectsResponse boxedResult = port.findProjects(params);
		return boxedResult.getProject();

	}

}
