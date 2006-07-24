package gov.nih.nci.cagrid.data.ui.types;

import gov.nih.nci.cadsr.umlproject.domain.Project;
import gov.nih.nci.cadsr.umlproject.domain.UMLPackageMetadata;
import gov.nih.nci.cagrid.introduce.beans.namespace.NamespaceType;
import gov.nih.nci.cagrid.introduce.common.CommonTools;
import gov.nih.nci.cagrid.introduce.info.ServiceInformation;

import java.io.File;
import java.util.List;

import javax.swing.JOptionPane;

import org.projectmobius.client.gme.ImportInfo;
import org.projectmobius.common.Namespace;
import org.projectmobius.common.XMLUtilities;
import org.projectmobius.common.gme.NoSuchSchemaException;
import org.projectmobius.gme.XMLDataModelService;
import org.projectmobius.portal.PortalResourceManager;
import org.projectmobius.protocol.gme.SchemaNode;

/** 
 *  NamespaceUtils
 *  Some utilities for making namespace manipulation and discovery easier
 * 
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * 
 * @created Jul 21, 2006 
 * @version $Id$ 
 */
public class NamespaceUtils {

	public static NamespaceType getServiceNamespaceType(ServiceInformation info, String namespace) {
		NamespaceType[] serviceNamespaces = info.getNamespaces().getNamespace();
		for (int i = 0; i < serviceNamespaces.length; i++) {
			if (serviceNamespaces[i].getNamespace().equals(namespace)) {
				return serviceNamespaces[i];
			}
		}
		return null;
	}
	
	
	public static String createNamespaceString(Project project, UMLPackageMetadata pack) {
		String version = project.getVersion();
		if (version.indexOf(".") == -1) {
			version += ".0";
		}
		return "gme://" + project.getShortName() + ".caBIG/" + version + "/" + pack.getName();
	}
	
	
	public static NamespaceType createNamespaceFromUmlPackage(Project project, 
		UMLPackageMetadata pack, XMLDataModelService gmeHandle, File schemaDir) throws Exception {
		String namespaceString = null;
		if (project != null) {
			namespaceString = createNamespaceString(project, pack);
			NamespaceType nsType = new NamespaceType();
			try {
				Namespace namespace = new Namespace(namespaceString);
				List namespaceDomainList = gmeHandle.getNamespaceDomainList();
				if (!namespaceDomainList.contains(namespace.getDomain())) {
					// prompt for alternate
					String alternativeDomain = (String) JOptionPane.showInputDialog(
						PortalResourceManager.getInstance().getGridPortal(),
						"The GME does not appear to contain schemas under the specified domain.\n"
						+ "Select an alternative domain, or cancel if no viable option is available.\n"
						+ "\nExpected domain: " + namespace.getDomain(), "Schema Location Error",
						JOptionPane.ERROR_MESSAGE, null, namespaceDomainList.toArray(), null);
					
					if (alternativeDomain != null) {
						namespace = new Namespace(namespace.getProtocol() + "://" + alternativeDomain + "/"
							+ namespace.getName());
					} else {
						return null;
					}
				}
				String schemaContents = null;
				try {
					schemaContents = getSchema(gmeHandle, namespace);
				} catch (NoSuchSchemaException e) {
					// prompt for alternate
					List schemas = gmeHandle.getSchemaListForNamespaceDomain(namespace.getDomain());
					Namespace alternativeSchema = (Namespace) JOptionPane.showInputDialog(
						PortalResourceManager.getInstance().getGridPortal(),
						"Unable to locate schema for the selected caDSR package.\n"
						+ "This package may not have a published Schema."
						+ "\nSelect an alternative Schema, or cancel.\n\nExpected schema: " + namespace.getName(),
						"Schema Location Error", JOptionPane.ERROR_MESSAGE, null, schemas.toArray(), null);
					
					if (alternativeSchema != null) {
						namespace = alternativeSchema;
					} else {
						return null;
					}
					schemaContents = getSchema(gmeHandle, namespace);
				}
				
				// set the package name
				String packageName = CommonTools.getPackageName(namespace);
				nsType.setPackageName(packageName);
				
				nsType.setNamespace(namespace.getRaw());
				ImportInfo ii = new ImportInfo(namespace);
				nsType.setLocation("./" + ii.getFileName());
				
				// popualte the schema elements
				gov.nih.nci.cagrid.introduce.portal.extension.ExtensionTools.setSchemaElements(
					nsType, XMLUtilities.stringToDocument(schemaContents));
				// write the schema and its imports to the filesystem
				gmeHandle.cacheSchema(namespace, schemaDir);
				return nsType;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	
	private static String getSchema(XMLDataModelService gmeHandle, Namespace namespace) throws Exception {
		SchemaNode schema = gmeHandle.getSchema(namespace, false);
		return schema.getSchemaContents();
	}
}
