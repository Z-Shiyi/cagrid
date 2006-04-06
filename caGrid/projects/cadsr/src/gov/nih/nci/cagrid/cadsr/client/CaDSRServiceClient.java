package gov.nih.nci.cagrid.cadsr.client;

import gov.nih.nci.cadsr.umlproject.domain.Project;
import gov.nih.nci.cadsr.umlproject.domain.UMLAttributeMetadata;
import gov.nih.nci.cadsr.umlproject.domain.UMLClassMetadata;
import gov.nih.nci.cadsr.umlproject.domain.UMLPackageMetadata;
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
		System.out.println(CaDSRServiceClient.class.getName() + " -url <service's url>");
	}


	public static void main(String[] args) {
		try {
			if (!(args.length < 2)) {
				if (args[0].equals("-url")) {
					CaDSRServiceClient client = new CaDSRServiceClient(args[1]);
					// place client calls here if you want to use this main as a
					// test....

					Project[] projs = client.findAllProjects();
					if (projs != null) {
						for (int i = 0; i < projs.length; i++) {
							Project project = projs[i];
							if (project.getShortName().equals("GrandParent")) {
								continue;
							}
							System.out.println("\n" + project.getShortName());
							UMLPackageMetadata[] packs = client.findPackagesInProject(project);
							if (packs != null) {
								for (int j = 0; j < packs.length; j++) {
									UMLPackageMetadata pack = packs[j];
									System.out.println("\t-" + pack.getName());
									UMLClassMetadata[] classes = client.findClassesInPackage(pack);
									if (classes != null) {
										for (int k = 0; k < classes.length; k++) {
											UMLClassMetadata clazz = classes[k];
											System.out.println("\t\t-" + clazz.getName());
											UMLAttributeMetadata[] atts = client.findAttributesInClass(clazz);
											if (atts != null) {
												for (int l = 0; l < atts.length; l++) {
													UMLAttributeMetadata att = atts[l];
													System.out.println("\t\t\t-" + att.getName());
												}
											}

										}
									}
								}
							}
						}
					}

					// projs = client.findProjects("caBIG");
					// for (int i = 0; i < projs.length; i++) {
					// System.out.println(projs[i].getShortName());
					// }
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

	     public gov.nih.nci.cadsr.umlproject.domain.Project[] findProjects(java.lang.String context) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.FindProjects params = new gov.nih.nci.cagrid.cadsr.stubs.FindProjects();
               params.setContext(context);
               gov.nih.nci.cagrid.cadsr.stubs.FindProjectsResponse boxedResult = port.findProjects(params);
               return boxedResult.getProject();

	}

	     public gov.nih.nci.cadsr.umlproject.domain.UMLPackageMetadata[] findPackagesInProject(gov.nih.nci.cadsr.umlproject.domain.Project project) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.FindPackagesInProject params = new gov.nih.nci.cagrid.cadsr.stubs.FindPackagesInProject();
               gov.nih.nci.cagrid.cadsr.stubs.FindPackagesInProjectProject projectContainer = new gov.nih.nci.cagrid.cadsr.stubs.FindPackagesInProjectProject();
               projectContainer.setProject(project);
               params.setProject(projectContainer);
               gov.nih.nci.cagrid.cadsr.stubs.FindPackagesInProjectResponse boxedResult = port.findPackagesInProject(params);
               return boxedResult.getUMLPackageMetadata();

	}

	     public gov.nih.nci.cadsr.umlproject.domain.UMLClassMetadata[] findClassesInProject(gov.nih.nci.cadsr.umlproject.domain.Project project) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.FindClassesInProject params = new gov.nih.nci.cagrid.cadsr.stubs.FindClassesInProject();
               gov.nih.nci.cagrid.cadsr.stubs.FindClassesInProjectProject projectContainer = new gov.nih.nci.cagrid.cadsr.stubs.FindClassesInProjectProject();
               projectContainer.setProject(project);
               params.setProject(projectContainer);
               gov.nih.nci.cagrid.cadsr.stubs.FindClassesInProjectResponse boxedResult = port.findClassesInProject(params);
               return boxedResult.getUMLClassMetadata();

	}

	     public gov.nih.nci.cadsr.umlproject.domain.UMLClassMetadata[] findClassesInPackage(gov.nih.nci.cadsr.umlproject.domain.UMLPackageMetadata pkg) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.FindClassesInPackage params = new gov.nih.nci.cagrid.cadsr.stubs.FindClassesInPackage();
               gov.nih.nci.cagrid.cadsr.stubs.FindClassesInPackagePkg pkgContainer = new gov.nih.nci.cagrid.cadsr.stubs.FindClassesInPackagePkg();
               pkgContainer.setUMLPackageMetadata(pkg);
               params.setPkg(pkgContainer);
               gov.nih.nci.cagrid.cadsr.stubs.FindClassesInPackageResponse boxedResult = port.findClassesInPackage(params);
               return boxedResult.getUMLClassMetadata();

	}

	     public java.lang.String generateMetadataExtractForProject(gov.nih.nci.cadsr.umlproject.domain.Project project) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForProject params = new gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForProject();
               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForProjectProject projectContainer = new gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForProjectProject();
               projectContainer.setProject(project);
               params.setProject(projectContainer);
               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForProjectResponse boxedResult = port.generateMetadataExtractForProject(params);
               return boxedResult.getResponse();

	}

	     public java.lang.String generateMetadataExtractForPackages(gov.nih.nci.cadsr.umlproject.domain.UMLPackageMetadata[] packages) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForPackages params = new gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForPackages();
               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForPackagesPackages packagesContainer = new gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForPackagesPackages();
               packagesContainer.setUMLPackageMetadata(packages);
               params.setPackages(packagesContainer);
               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForPackagesResponse boxedResult = port.generateMetadataExtractForPackages(params);
               return boxedResult.getResponse();

	}

	     public java.lang.String generateMetadataExtractForClasses(gov.nih.nci.cadsr.umlproject.domain.UMLClassMetadata[] classes) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForClasses params = new gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForClasses();
               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForClassesClasses classesContainer = new gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForClassesClasses();
               classesContainer.setUMLClassMetadata(classes);
               params.setClasses(classesContainer);
               gov.nih.nci.cagrid.cadsr.stubs.GenerateMetadataExtractForClassesResponse boxedResult = port.generateMetadataExtractForClasses(params);
               return boxedResult.getResponse();

	}

	     public gov.nih.nci.cadsr.umlproject.domain.UMLAttributeMetadata[] findAttributesInClass(gov.nih.nci.cadsr.umlproject.domain.UMLClassMetadata clazz) throws RemoteException {
               CaDSRServicePortType port = this.getPortType();
               org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               gov.nih.nci.cagrid.cadsr.stubs.FindAttributesInClass params = new gov.nih.nci.cagrid.cadsr.stubs.FindAttributesInClass();
               gov.nih.nci.cagrid.cadsr.stubs.FindAttributesInClassClazz clazzContainer = new gov.nih.nci.cagrid.cadsr.stubs.FindAttributesInClassClazz();
               clazzContainer.setUMLClassMetadata(clazz);
               params.setClazz(clazzContainer);
               gov.nih.nci.cagrid.cadsr.stubs.FindAttributesInClassResponse boxedResult = port.findAttributesInClass(params);
               return boxedResult.getUMLAttributeMetadata();

	}


}
