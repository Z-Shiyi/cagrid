package gov.nih.nci.cagrid.cadsr.common;

import java.rmi.RemoteException;


/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by caGrid toolkit version 0.5
 */
public interface CaDSRServiceI {


























     public gov.nih.nci.cadsr.umlproject.domain.ws.Project[] findAllProjects() throws RemoteException ;
     public gov.nih.nci.cadsr.umlproject.domain.ws.Project[] findProjects(java.lang.String context) throws RemoteException ;
     public gov.nih.nci.cadsr.umlproject.domain.ws.UMLPackageMetadata[] findPackagesInProject(gov.nih.nci.cadsr.umlproject.domain.ws.Project project) throws RemoteException ;
     public gov.nih.nci.cadsr.umlproject.domain.ws.UMLClassMetadata[] findClassesInProject(gov.nih.nci.cadsr.umlproject.domain.ws.Project project) throws RemoteException ;
     public gov.nih.nci.cadsr.umlproject.domain.ws.UMLClassMetadata[] findClassesInPackage(gov.nih.nci.cadsr.umlproject.domain.ws.UMLPackageMetadata pkg) throws RemoteException ;
     public java.lang.String[] generateMetadataExtractForProject(gov.nih.nci.cadsr.umlproject.domain.ws.Project project) throws RemoteException ;
     public java.lang.String generateMetadataExtractForPackages(gov.nih.nci.cadsr.umlproject.domain.ws.UMLPackageMetadata[] packages) throws RemoteException ;
     public java.lang.String generateMetadataExtractForClasses(gov.nih.nci.cadsr.umlproject.domain.ws.UMLClassMetadata[] classes) throws RemoteException ;
     public gov.nih.nci.cadsr.umlproject.domain.ws.UMLAttributeMetadata[] findAttributesInClass(gov.nih.nci.cadsr.umlproject.domain.ws.UMLClassMetadata clazz) throws RemoteException ;

}
