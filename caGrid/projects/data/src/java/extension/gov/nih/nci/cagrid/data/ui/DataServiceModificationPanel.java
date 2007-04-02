package gov.nih.nci.cagrid.data.ui;

import gov.nih.nci.cadsr.umlproject.domain.Project;
import gov.nih.nci.cadsr.umlproject.domain.UMLClassMetadata;
import gov.nih.nci.cadsr.umlproject.domain.UMLPackageMetadata;
import gov.nih.nci.cagrid.cadsr.client.CaDSRServiceClient;
import gov.nih.nci.cagrid.cadsr.portal.CaDSRBrowserPanel;
import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.common.portal.ErrorDialog;
import gov.nih.nci.cagrid.common.portal.PortalLookAndFeel;
import gov.nih.nci.cagrid.common.portal.PortalUtils;
import gov.nih.nci.cagrid.common.portal.PromptButtonDialog;
import gov.nih.nci.cagrid.data.DataServiceConstants;
import gov.nih.nci.cagrid.data.ExtensionDataUtils;
import gov.nih.nci.cagrid.data.codegen.DomainModelCreationUtil;
import gov.nih.nci.cagrid.data.extension.AdditionalLibraries;
import gov.nih.nci.cagrid.data.extension.CadsrInformation;
import gov.nih.nci.cagrid.data.extension.CadsrPackage;
import gov.nih.nci.cagrid.data.extension.ClassMapping;
import gov.nih.nci.cagrid.data.extension.Data;
import gov.nih.nci.cagrid.data.ui.browser.AdditionalJarsChangeListener;
import gov.nih.nci.cagrid.data.ui.browser.AdditionalJarsChangedEvent;
import gov.nih.nci.cagrid.data.ui.browser.ClassBrowserPanel;
import gov.nih.nci.cagrid.data.ui.browser.ClassSelectionEvent;
import gov.nih.nci.cagrid.data.ui.browser.ClassSelectionListener;
import gov.nih.nci.cagrid.data.ui.table.ClassChangeEvent;
import gov.nih.nci.cagrid.data.ui.table.ClassElementSerializationTable;
import gov.nih.nci.cagrid.data.ui.table.ClassInformatonChangeListener;
import gov.nih.nci.cagrid.data.ui.table.QueryProcessorParametersTable;
import gov.nih.nci.cagrid.data.ui.tree.CheckTreeSelectionEvent;
import gov.nih.nci.cagrid.data.ui.tree.CheckTreeSelectionListener;
import gov.nih.nci.cagrid.data.ui.tree.uml.UMLClassTreeNode;
import gov.nih.nci.cagrid.data.ui.tree.uml.UMLPackageTreeNode;
import gov.nih.nci.cagrid.data.ui.tree.uml.UMLProjectTree;
import gov.nih.nci.cagrid.introduce.ResourceManager;
import gov.nih.nci.cagrid.introduce.beans.extension.ServiceExtensionDescriptionType;
import gov.nih.nci.cagrid.introduce.beans.namespace.NamespaceType;
import gov.nih.nci.cagrid.introduce.beans.namespace.SchemaElementType;
import gov.nih.nci.cagrid.introduce.beans.property.ServicePropertiesProperty;
import gov.nih.nci.cagrid.introduce.beans.resource.ResourcePropertyType;
import gov.nih.nci.cagrid.introduce.common.CommonTools;
import gov.nih.nci.cagrid.introduce.common.FileFilters;
import gov.nih.nci.cagrid.introduce.info.ServiceInformation;
import gov.nih.nci.cagrid.introduce.portal.extension.ServiceModificationUIPanel;
import gov.nih.nci.cagrid.metadata.MetadataUtils;
import gov.nih.nci.cagrid.metadata.dataservice.DomainModel;
import gov.nih.nci.cagrid.metadata.dataservice.UMLClass;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.projectmobius.portal.PortalResourceManager;


/**
 * DataServiceModificationPanel Panel for configuring a caGrid data service from
 * within the Introduce Toolkit
 * 
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * @created Oct 10, 2006
 * @version $Id$
 */
public class DataServiceModificationPanel extends ServiceModificationUIPanel {

	private JButton selectDomainModelButton = null;
	private JTextField domainModelNameTextField = null;
	private JPanel domainModelSelectionPanel = null;
	private JButton addFullProjectButton = null;
	private JButton addPackageButton = null;
	private JButton removePackageButton = null;
	private CaDSRBrowserPanel cadsrBrowserPanel = null;
	private UMLProjectTree umlTree = null;
	private ClassElementSerializationTable classConfigTable = null;
	private ClassBrowserPanel classBrowserPanel = null;
	private JCheckBox cqlSyntaxValidationCheckBox = null;
	private JCheckBox domainModelValidationCheckBox = null;
	private JScrollPane classConfigScrollPane = null;
	private JPanel validationCheckPanel = null;
	private JScrollPane umlClassScrollPane = null;
	private JPanel packageSelectionButtonPanel = null;
	private JRadioButton noDomainModelRadioButton = null;
	private JRadioButton cadsrDomainModelRadioButton = null;
	private JRadioButton suppliedDomainModelRadioButton = null;
	private JPanel domainModelSourcePanel = null;
	private JPanel domainConfigPanel = null;
	private JPanel cadsrDomainModelPanel = null;
	private JTabbedPane mainTabbedPane = null;
	private JPanel processorConfigPanel = null;
	private JPanel detailConfigPanel = null;
	private QueryProcessorParametersTable qpParamsTable = null;
	private JScrollPane qpParamsScrollPane = null;

	private transient Project mostRecentProject = null;
	private transient Map packageToNamespace = null;
	private transient Map packageToClassMap = null;
    private JButton visualizeDomainModelButton = null;


	public DataServiceModificationPanel(ServiceExtensionDescriptionType desc, ServiceInformation info) {
		super(desc, info);
		packageToNamespace = new HashMap();
		packageToClassMap = new HashMap();
		// if there's existing cadsr configuration, apply it
		loadUmlTreeInformation();
		groupRadioButtons();
		initialize();
	}


	private void initialize() {
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 1.0D;
		cons.weighty = 1.0D;
		cons.fill = GridBagConstraints.BOTH;
		add(getMainTabbedPane(), cons);
	}


	protected void resetGUI() {
		// TODO Auto-generated method stub
	}


	private void groupRadioButtons() {
		NotifyingButtonGroup group = new NotifyingButtonGroup();
		group.add(getNoDomainModelRadioButton());
		group.add(getSuppliedDomainModelRadioButton());
		group.add(getCadsrDomainModelRadioButton());
		group.addGroupSelectionListener(new GroupSelectionListener() {
			public void selectionChanged(ButtonModel previous, ButtonModel current) {
				if ((previous != null) && (previous != current)) {
					if (current == getNoDomainModelRadioButton().getModel()) {
						removeStoredCadsrInformation();
						PortalUtils.setContainerEnabled(getDomainModelSelectionPanel(), false);
						PortalUtils.setContainerEnabled(getCadsrDomainModelPanel(), false);
                        getVisualizeDomainModelButton().setEnabled(false);
						cleanOutGui();
					} else if (current == getSuppliedDomainModelRadioButton().getModel()) {
						removeStoredCadsrInformation();
						PortalUtils.setContainerEnabled(getDomainModelSelectionPanel(), true);
						PortalUtils.setContainerEnabled(getCadsrDomainModelPanel(), false);
                        getVisualizeDomainModelButton().setEnabled(true);
					} else if (current == getCadsrDomainModelRadioButton().getModel()) {
						storeCadsrServiceUrl();
						PortalUtils.setContainerEnabled(getDomainModelSelectionPanel(), false);
						PortalUtils.setContainerEnabled(getCadsrDomainModelPanel(), true);
						getDomainModelNameTextField().setText("");
                        getVisualizeDomainModelButton().setEnabled(true);
					}
				}
				// always record this state
				storeNoDomainModelInfo();
			}


			private void cleanOutGui() {
				getDomainModelNameTextField().setText("");
				getUmlTree().clearTree();
				getClassConfigTable().clearTable();
			}
		});

		// decide which domain model mode to auto-select
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info != null) {
				if (info.isNoDomainModel()) {
					group.setSelected(getNoDomainModelRadioButton().getModel(), true);
				} else if (info.isUseSuppliedModel()) {
					group.setSelected(getSuppliedDomainModelRadioButton().getModel(), true);
				} else {
					group.setSelected(getCadsrDomainModelRadioButton().getModel(), true);
				}
			} else {
				group.setSelected(getNoDomainModelRadioButton().getModel(), true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog(ex);
		}
	}


	private CaDSRBrowserPanel getCadsrBrowserPanel() {
		if (cadsrBrowserPanel == null) {
			cadsrBrowserPanel = new CaDSRBrowserPanel(true, false);
			// add listener to the cadsr URL text field
			// TODO: this is probably really slow; make it better
			cadsrBrowserPanel.getCadsr().getDocument().addDocumentListener(new DocumentListener() {
				public void insertUpdate(DocumentEvent e) {
					storeCadsrServiceUrl();
				}


				public void removeUpdate(DocumentEvent e) {
					storeCadsrServiceUrl();
				}


				public void changedUpdate(DocumentEvent e) {
					storeCadsrServiceUrl();
				}
			});
		}
		return cadsrBrowserPanel;
	}


	private UMLProjectTree getUmlTree() {
		if (umlTree == null) {
			umlTree = new UMLProjectTree();
			umlTree.addCheckTreeSelectionListener(new CheckTreeSelectionListener() {
				public void nodeChecked(CheckTreeSelectionEvent e) {
					if (e.getNode() instanceof UMLClassTreeNode) {
						UMLClassTreeNode classNode = (UMLClassTreeNode) e.getNode();
						// add the type to the configuration table
						String packName = ((UMLPackageTreeNode) classNode.getParent()).getPackageName();
						String className = classNode.getClassName();
						String namespace = (String) packageToNamespace.get(packName);
						NamespaceType nsType = CommonTools
							.getNamespaceType(getServiceInfo().getNamespaces(), namespace);
						try {
							ClassMapping mapping = getClassMapping(packName, className);
							mapping.setSelected(true);
							getClassConfigTable().addClass(packName, mapping, nsType);
							storeClassMapping(packName, mapping);
						} catch (Exception ex) {
							ex.printStackTrace();
							ErrorDialog.showErrorDialog("Error getting mapping for " + packName + "." + className, ex);
						}
					}
				}


				public void nodeUnchecked(CheckTreeSelectionEvent e) {
					if (e.getNode() instanceof UMLClassTreeNode) {
						UMLClassTreeNode classNode = (UMLClassTreeNode) e.getNode();
						// add the type to the configuration table
						String packName = ((UMLPackageTreeNode) classNode.getParent()).getPackageName();
						String className = classNode.getClassName();
						getClassConfigTable().removeRow(packName, className);
						unselectClassMapping(packName, className);
					}
				}
			});
		}
		return umlTree;
	}


	private ClassElementSerializationTable getClassConfigTable() {
		if (classConfigTable == null) {
			classConfigTable = new ClassElementSerializationTable();
			classConfigTable.addClassInformatonChangeListener(new ClassInformatonChangeListener() {
				public void elementNameChanged(ClassChangeEvent e) {
					// get class to element mapping
					Map classToElement = (Map) packageToClassMap.get(e.getPackageName());
					// get the old element name mapping for this class
					String oldElementName = (String) classToElement.get(e.getClassName());
					// get the namespace type for the class
					NamespaceType nsType = CommonTools.getNamespaceType(getServiceInfo().getNamespaces(), e
						.getNamespace());
					// find the schema element type
					SchemaElementType schemaType = NamespaceUtils.getElementByName(nsType, e.getElementName());
					if ((schemaType == null) && (oldElementName != null) && (oldElementName.length() != 0)) {
						// WARNING: You've selected a non-existant element name,
						// AND the old element name was NOT non existant as well
						ErrorDialog.showErrorDialog("No element named " + e.getElementName() + " in namespace "
							+ e.getNamespace());
					}
					// change the element name mapping
					classToElement.put(e.getClassName(), e.getElementName());
					// save the mapping info
					try {
						ClassMapping mapping = getClassMapping(e.getPackageName(), e.getClassName());
						mapping.setElementName(e.getElementName());
						storeClassMapping(e.getPackageName(), mapping);
					} catch (Exception ex) {
						ex.printStackTrace();
						ErrorDialog.showErrorDialog("Error storing class mapping", ex);
					}
				}


				public void serializationChanged(ClassChangeEvent e) {
					// get the namespace type for the class
					NamespaceType nsType = CommonTools.getNamespaceType(getServiceInfo().getNamespaces(), e
						.getNamespace());
					// find the schema element type
					SchemaElementType schemaType = NamespaceUtils.getElementByName(nsType, e.getElementName());
					// user may have selected an element type name which is not
					// in the namespace type.
					// TODO: what do I do in that case? maybe prevent that in
					// handling element name changed
					if (schemaType != null) {
						schemaType.setSerializer(e.getSerializer());
						schemaType.setDeserializer(e.getDeserializer());
					}
				}


				public void targetabilityChanged(ClassChangeEvent e) {
					try {
						// get the old class mapping
						ClassMapping mapping = getClassMapping(e.getPackageName(), e.getClassName());
						// change the targetability
						mapping.setTargetable(e.isTargetable());
						// save the changes
						storeClassMapping(e.getPackageName(), mapping);
					} catch (Exception ex) {
						ex.printStackTrace();
						ErrorDialog.showErrorDialog("Error storing change to targetability", ex);
					}
				}
			});
		}
		return classConfigTable;
	}


	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getAddPackageButton() {
		if (addPackageButton == null) {
			addPackageButton = new JButton();
			addPackageButton.setText("Add Package");
			addPackageButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Project selectedProject = getCadsrBrowserPanel().getSelectedProject();
					UMLPackageMetadata selectedPackage = cadsrBrowserPanel.getSelectedPackage();
					handlePackageAddition(selectedProject, new UMLPackageMetadata[]{selectedPackage});
				}
			});
		}
		return addPackageButton;
	}


	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getAddFullProjectButton() {
		if (addFullProjectButton == null) {
			addFullProjectButton = new JButton();
			addFullProjectButton.setText("Add Full Project");
			addFullProjectButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Project selectedProject = getCadsrBrowserPanel().getSelectedProject();
					try {
						// use the caDSR client to get all the packages from the
						// selected project
						CaDSRServiceClient cadsrClient = new CaDSRServiceClient(getCadsrBrowserPanel().getCadsr()
							.getText());
						UMLPackageMetadata[] packages = cadsrClient.findPackagesInProject(selectedProject);
						handlePackageAddition(selectedProject, packages);
					} catch (Exception ex) {
						ex.printStackTrace();
						ErrorDialog.showErrorDialog("Error getting packages from caDSR", ex);
					}
				}
			});
		}
		return addFullProjectButton;
	}


	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getRemovePackageButton() {
		if (removePackageButton == null) {
			removePackageButton = new JButton();
			removePackageButton.setText("Remove Package");
			removePackageButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Project selectedProject = getCadsrBrowserPanel().getSelectedProject();
					UMLPackageMetadata selectedPackage = getCadsrBrowserPanel().getSelectedPackage();
					if ((selectedProject != null) && projectEquals(selectedProject, mostRecentProject)
						&& (selectedPackage != null) && packageToNamespace.containsKey(selectedPackage.getName())) {
						String packName = selectedPackage.getName();
						// get the selected classes from this package
						String[] classNames = getUmlTree().getSelectedClassNames(packName);
						// remove them from the class config table
						for (int i = 0; i < classNames.length; i++) {
							getClassConfigTable().removeRow(packName, classNames[i]);
						}
						// remove the package from the uml types tree
						getUmlTree().removeUmlPackage(selectedPackage.getName());
						String namespace = (String) packageToNamespace.get(selectedPackage.getName());
						NamespaceType nsType = CommonTools
							.getNamespaceType(getServiceInfo().getNamespaces(), namespace);
						// if the namespace type is no longer in use, remove it
						// from the service
						if ((nsType != null)
							&& !CommonTools.isNamespaceTypeInUse(nsType, getServiceInfo().getServiceDescriptor())) {
							NamespaceType[] allNamespaces = getServiceInfo().getNamespaces().getNamespace();
							NamespaceType[] cleanedNamespaces = (NamespaceType[]) Utils.removeFromArray(allNamespaces,
								nsType);
							getServiceInfo().getNamespaces().setNamespace(cleanedNamespaces);
						}
						// remove namespace from the packageMapping
						packageToNamespace.remove(selectedPackage.getName());
						// remove the mapping for its classes
						packageToClassMap.remove(selectedPackage.getName());
						// store the new information in the extension data
						storeUpdatedPackageInformation();
					} else {
						PortalUtils.showMessage("Please select a package involved in the current domain model.");
					}
				}
			});
		}
		return removePackageButton;
	}


	private ClassBrowserPanel getClassBrowserPanel() {
		if (classBrowserPanel == null) {
			classBrowserPanel = new ClassBrowserPanel(getExtensionTypeExtensionData(), getServiceInfo());
			// classBrowserPanel = new ClassBrowserPanel(null, null); //
			// uncomment this line to edit in VE
			classBrowserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Query Processor Class Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			// listen for class selection events
			classBrowserPanel.addClassSelectionListener(new ClassSelectionListener() {
				public void classSelectionChanged(ClassSelectionEvent e) {
					try {
						saveProcessorClassName(classBrowserPanel.getSelectedClassName());
					} catch (Exception ex) {
						ex.printStackTrace();
						ErrorDialog.showErrorDialog("Error setting the query processor class: " + ex.getMessage(), ex);
					}
				}
			});
			// listen for jar addition events
			classBrowserPanel.addAdditionalJarsChangeListener(new AdditionalJarsChangeListener() {
				public void additionalJarsChanged(AdditionalJarsChangedEvent e) {
					// remove any existing qp jars element from the service data
					AdditionalLibraries additionalLibs = new AdditionalLibraries();
					String[] additionalJars = classBrowserPanel.getAdditionalJars();
					additionalLibs.setJarName(additionalJars);
					try {
						Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
						data.setAdditionalLibraries(additionalLibs);
						ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
					} catch (Exception ex) {
						ex.printStackTrace();
						ErrorDialog.showErrorDialog("Error storing additional libraries information: "
							+ ex.getMessage(), ex);
					}
				}
			});
		}
		return classBrowserPanel;
	}


	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getSelectDomainModelButton() {
		if (selectDomainModelButton == null) {
			selectDomainModelButton = new JButton();
			selectDomainModelButton.setText("Select Domain Model");
			selectDomainModelButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String filename = ResourceManager.promptFile(null, FileFilters.XML_FILTER);
						setDomainModelFile(filename);
					} catch (Exception ex) {
						ex.printStackTrace();
						ErrorDialog.showErrorDialog("Error selecting file: " + ex.getMessage());
					}
				}
			});
		}
		return selectDomainModelButton;
	}


	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDomainModelNameTextField() {
		if (domainModelNameTextField == null) {
			domainModelNameTextField = new JTextField();
			domainModelNameTextField.setToolTipText("Optional xml file name of an existing domain model");
			domainModelNameTextField.setEditable(false);
		}
		return domainModelNameTextField;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDomainModelSelectionPanel() {
		if (domainModelSelectionPanel == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints7.gridy = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints6.gridx = 0;
			domainModelSelectionPanel = new JPanel();
			domainModelSelectionPanel.setLayout(new GridBagLayout());
			domainModelSelectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Supplied Domain Model", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			domainModelSelectionPanel.add(getDomainModelNameTextField(), gridBagConstraints6);
			domainModelSelectionPanel.add(getSelectDomainModelButton(), gridBagConstraints7);
		}
		return domainModelSelectionPanel;
	}


	private void setDomainModelFile(String filename) {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation cadsrInfo = data.getCadsrInformation();
			if (cadsrInfo == null) {
				cadsrInfo = new CadsrInformation();
				data.setCadsrInformation(cadsrInfo);
			}
			// set the info to use the supplied domain model
			cadsrInfo.setUseSuppliedModel(true);

			// load up the domain model
			DomainModel model = MetadataUtils.deserializeDomainModel(new FileReader(filename));
			// set the most recent project information
			Project proj = new Project();
			proj.setDescription(model.getProjectDescription());
			proj.setLongName(model.getProjectLongName());
			proj.setShortName(model.getProjectShortName());
			proj.setVersion(model.getProjectVersion());
			mostRecentProject = proj;
			// set cadsr project information
			cadsrInfo.setProjectLongName(model.getProjectLongName());
			cadsrInfo.setProjectVersion(model.getProjectVersion());
			// walk classes, creating package groupings as needed
			Map packageClasses = new HashMap();
			UMLClass[] modelClasses = model.getExposedUMLClassCollection().getUMLClass();
			for (int i = 0; i < modelClasses.length; i++) {
				String packageName = modelClasses[i].getPackageName();
				if (packageClasses.containsKey(packageName)) {
					((List) packageClasses.get(packageName)).add(modelClasses[i].getClassName());
				} else {
					List classList = new ArrayList();
					classList.add(modelClasses[i].getClassName());
					packageClasses.put(packageName, classList);
				}
			}
			// create cadsr packages
			CadsrPackage[] packages = new CadsrPackage[packageClasses.keySet().size()];
			int packIndex = 0;
			Iterator packageNameIter = packageClasses.keySet().iterator();
			while (packageNameIter.hasNext()) {
				String packName = (String) packageNameIter.next();
				String mappedNamespace = NamespaceUtils.createNamespaceString(model.getProjectShortName(), model
					.getProjectVersion(), packName);
				CadsrPackage pack = new CadsrPackage();
				pack.setName(packName);
				pack.setMappedNamespace(mappedNamespace);
				// does the mapped namespace exist in the service?
				NamespaceType packageNamespace = CommonTools.getNamespaceType(getServiceInfo().getNamespaces(),
					mappedNamespace);
				if (packageNamespace == null) {
					String[] message = {"The imported domain model has a package which maps to the namespace",
							mappedNamespace + ".", "This namespace is not loaded into the service.",
							"Please locate a suitable namespace."};
					JOptionPane.showMessageDialog(this, message);
					NamespaceType[] resolved = SchemaResolutionDialog.resolveSchemas(getServiceInfo(), pack);
					if ((resolved == null) || (resolved.length == 0)) {
						String[] error = {"The package " + packName + " was not mapped to a namespace.",
								"This can cause errors when the service builds."};
						ErrorDialog.showErrorDialog("No namespace mapping provided", error);
					} else {
						for (int i = 0; i < resolved.length; i++) {
							// add the resolved namespaces to the service
							CommonTools.addNamespace(getServiceInfo().getServiceDescriptor(), resolved[i]);
						}
						packageNamespace = resolved[0];
					}
				}
				// create ClassMappings for the package's classes
				List classNameList = (List) packageClasses.get(packName);
				ClassMapping[] mappings = new ClassMapping[classNameList.size()];
				for (int i = 0; i < classNameList.size(); i++) {
					ClassMapping mapping = new ClassMapping();
					String className = (String) classNameList.get(i);
					mapping.setClassName(className);
					mapping.setElementName(className);
					mapping.setSelected(true);
					mapping.setTargetable(true);
					mappings[i] = mapping;
					// add class mapping to the class config panel
					getClassConfigTable().addClass(pack.getName(), mapping, packageNamespace);
				}
				pack.setCadsrClass(mappings);
				packages[packIndex] = pack;
				packIndex++;
			}
			cadsrInfo.setPackages(packages);

			// store the changed information
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);

			// copy the selected file into the service's etc directory
			File originalFile = new File(filename);
			File localFile = new File(getServiceInfo().getBaseDirectory().getAbsolutePath() + File.separator + "etc"
				+ File.separator + originalFile.getName());
			Utils.copyFile(originalFile, localFile);

			// get the domain model resource property
			ResourcePropertyType dmResourceProp = CommonTools.getResourcePropertiesOfType(getServiceInfo()
				.getServices().getService(0), DataServiceConstants.DOMAIN_MODEL_QNAME)[0];
			dmResourceProp.setFileLocation(localFile.getName());
			dmResourceProp.setPopulateFromFile(true);

			// set the text of the selected domain model file to reflect the
			// local location of the domain model
			getDomainModelNameTextField().setText(localFile.getAbsolutePath());

			// the file has been copied to a new location and its name changed
			// inform the service developer of what just happened
			String[] message = {"The selected domain model was copied into the service's",
					"directory structure for future use and deployment."};
			PortalUtils.showMessage(message);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error loading existing caDSR information: " + ex.getMessage(), ex);
		}
	}


	private JCheckBox getCqlSyntaxValidationCheckBox() {
		if (cqlSyntaxValidationCheckBox == null) {
			cqlSyntaxValidationCheckBox = new JCheckBox();
			cqlSyntaxValidationCheckBox.setText("Validate CQL Syntax");
			cqlSyntaxValidationCheckBox.setToolTipText("Causes the Data Service to "
				+ "validate all CQL queries for syntactic correctness");
			cqlSyntaxValidationCheckBox.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					CommonTools.setServiceProperty(getServiceInfo().getServiceDescriptor(),
						DataServiceConstants.VALIDATE_CQL_FLAG, String.valueOf(getCqlSyntaxValidationCheckBox()
							.isSelected()), false);
				}
			});
			// set the check box selection
			if (CommonTools.servicePropertyExists(getServiceInfo().getServiceDescriptor(),
				DataServiceConstants.VALIDATE_CQL_FLAG)) {
				try {
					cqlSyntaxValidationCheckBox.setSelected(Boolean.parseBoolean(CommonTools.getServicePropertyValue(
						getServiceInfo().getServiceDescriptor(), DataServiceConstants.VALIDATE_CQL_FLAG)));
				} catch (Exception ex) {
					ex.printStackTrace();
					ErrorDialog.showErrorDialog("Error getting service property value for "
						+ DataServiceConstants.VALIDATE_CQL_FLAG, ex);
				}
			}
		}
		return cqlSyntaxValidationCheckBox;
	}


	/**
	 * This method initializes jCheckBox
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getDomainModelValidationCheckBox() {
		if (domainModelValidationCheckBox == null) {
			domainModelValidationCheckBox = new JCheckBox();
			domainModelValidationCheckBox.setText("Validate Domain Model");
			domainModelValidationCheckBox.setToolTipText("Causes the data service to ensure "
				+ "all queries remain within the limits of the exposed domain model");
			domainModelValidationCheckBox.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					CommonTools.setServiceProperty(getServiceInfo().getServiceDescriptor(),
						DataServiceConstants.VALIDATE_DOMAIN_MODEL_FLAG, String
							.valueOf(getDomainModelValidationCheckBox().isSelected()), false);
				}
			});
			// set the check box selection
			if (CommonTools.servicePropertyExists(getServiceInfo().getServiceDescriptor(),
				DataServiceConstants.VALIDATE_DOMAIN_MODEL_FLAG)) {
				try {
					domainModelValidationCheckBox.setSelected(Boolean.parseBoolean(CommonTools.getServicePropertyValue(
						getServiceInfo().getServiceDescriptor(), DataServiceConstants.VALIDATE_DOMAIN_MODEL_FLAG)));
				} catch (Exception ex) {
					ex.printStackTrace();
					ErrorDialog.showErrorDialog("Error getting service property value for "
						+ DataServiceConstants.VALIDATE_DOMAIN_MODEL_FLAG, ex);
				}
			}
		}
		return domainModelValidationCheckBox;
	}


	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getClassConfigScrollPane() {
		if (classConfigScrollPane == null) {
			classConfigScrollPane = new JScrollPane();
			classConfigScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Exposed Class Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			classConfigScrollPane.setViewportView(getClassConfigTable());
			classConfigScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return classConfigScrollPane;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getValidationCheckPanel() {
		if (validationCheckPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints.gridy = 0;
			validationCheckPanel = new JPanel();
			validationCheckPanel.setLayout(new GridBagLayout());
			validationCheckPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Query Validation",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			validationCheckPanel.add(getCqlSyntaxValidationCheckBox(), gridBagConstraints);
			validationCheckPanel.add(getDomainModelValidationCheckBox(), gridBagConstraints1);
		}
		return validationCheckPanel;
	}


	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getUmlClassScrollPane() {
		if (umlClassScrollPane == null) {
			umlClassScrollPane = new JScrollPane();
			umlClassScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UML Class Selection",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			umlClassScrollPane.setViewportView(getUmlTree());
		}
		return umlClassScrollPane;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPackageSelectionButtonPanel() {
		if (packageSelectionButtonPanel == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints2.gridy = 0;
			packageSelectionButtonPanel = new JPanel();
			packageSelectionButtonPanel.setLayout(new GridBagLayout());
			packageSelectionButtonPanel.add(getAddFullProjectButton(), gridBagConstraints2);
			packageSelectionButtonPanel.add(getAddPackageButton(), gridBagConstraints3);
			packageSelectionButtonPanel.add(getRemovePackageButton(), gridBagConstraints4);
		}
		return packageSelectionButtonPanel;
	}


	/**
	 * This method initializes jRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getNoDomainModelRadioButton() {
		if (noDomainModelRadioButton == null) {
			noDomainModelRadioButton = new JRadioButton();
			noDomainModelRadioButton.setText("No Domain Model");
		}
		return noDomainModelRadioButton;
	}


	/**
	 * This method initializes jRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getCadsrDomainModelRadioButton() {
		if (cadsrDomainModelRadioButton == null) {
			cadsrDomainModelRadioButton = new JRadioButton();
			cadsrDomainModelRadioButton.setText("caDSR Domain Model");
		}
		return cadsrDomainModelRadioButton;
	}


	/**
	 * This method initializes jRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getSuppliedDomainModelRadioButton() {
		if (suppliedDomainModelRadioButton == null) {
			suppliedDomainModelRadioButton = new JRadioButton();
			suppliedDomainModelRadioButton.setText("Supplied Domain Model");
		}
		return suppliedDomainModelRadioButton;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDomainModelSourcePanel() {
		if (domainModelSourcePanel == null) {
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints9.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints9.gridy = 2;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints8.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints8.gridy = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints5.gridy = 0;
			domainModelSourcePanel = new JPanel();
			domainModelSourcePanel.setLayout(new GridBagLayout());
			domainModelSourcePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Domain Model Source",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			domainModelSourcePanel.add(getNoDomainModelRadioButton(), gridBagConstraints5);
			domainModelSourcePanel.add(getCadsrDomainModelRadioButton(), gridBagConstraints8);
			domainModelSourcePanel.add(getSuppliedDomainModelRadioButton(), gridBagConstraints9);
		}
		return domainModelSourcePanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDomainConfigPanel() {
		if (domainConfigPanel == null) {
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 1;
			gridBagConstraints19.gridy = 1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints15.gridwidth = 2;
			gridBagConstraints15.weightx = 1.0D;
			gridBagConstraints15.weighty = 1.0D;
			gridBagConstraints15.gridy = 2;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.anchor = java.awt.GridBagConstraints.NORTH;
			gridBagConstraints11.weightx = 1.0D;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.gridheight = 2;
			gridBagConstraints10.gridy = 0;
			domainConfigPanel = new JPanel();
			domainConfigPanel.setLayout(new GridBagLayout());
			domainConfigPanel.add(getDomainModelSourcePanel(), gridBagConstraints10);
			domainConfigPanel.add(getDomainModelSelectionPanel(), gridBagConstraints11);
			domainConfigPanel.add(getCadsrDomainModelPanel(), gridBagConstraints15);
			domainConfigPanel.add(getVisualizeDomainModelButton(), gridBagConstraints19);
		}
		return domainConfigPanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getCadsrDomainModelPanel() {
		if (cadsrDomainModelPanel == null) {
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 2;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.weighty = 1.0;
			gridBagConstraints14.gridx = 0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridy = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints12.gridy = 0;
			cadsrDomainModelPanel = new JPanel();
			cadsrDomainModelPanel.setLayout(new GridBagLayout());
			cadsrDomainModelPanel.add(getCadsrBrowserPanel(), gridBagConstraints12);
			cadsrDomainModelPanel.add(getPackageSelectionButtonPanel(), gridBagConstraints13);
			cadsrDomainModelPanel.add(getUmlClassScrollPane(), gridBagConstraints14);
		}
		return cadsrDomainModelPanel;
	}


	/**
	 * This method initializes jTabbedPane
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getMainTabbedPane() {
		if (mainTabbedPane == null) {
			mainTabbedPane = new JTabbedPane();
			mainTabbedPane.addTab("Domain Model", null, getDomainConfigPanel(), null);
			mainTabbedPane.addTab("Query Processor", null, getProcessorConfigPanel(), null);
			mainTabbedPane.addTab("Details", null, getDetailConfigPanel(),
				"Class to element mapping, serialization, validation");
		}
		return mainTabbedPane;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getProcessorConfigPanel() {
		if (processorConfigPanel == null) {
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 0;
			gridBagConstraints16.weightx = 1.0D;
			gridBagConstraints16.gridy = 0;
			gridBagConstraints16.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.gridy = 1;
			gridBagConstraints17.weightx = 1.0D;
			gridBagConstraints17.weighty = 1.0D;
			gridBagConstraints17.fill = GridBagConstraints.BOTH;
			gridBagConstraints17.insets = new java.awt.Insets(6, 6, 6, 6);
			processorConfigPanel = new JPanel();
			processorConfigPanel.setLayout(new GridBagLayout());
			processorConfigPanel.add(getClassBrowserPanel(), gridBagConstraints16);
			processorConfigPanel.add(getQpParamsScrollPane(), gridBagConstraints17);
		}
		return processorConfigPanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDetailConfigPanel() {
		if (detailConfigPanel == null) {
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints18.gridy = 1;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.weighty = 1.0D;
			gridBagConstraints17.gridx = 0;
			detailConfigPanel = new JPanel();
			detailConfigPanel.setLayout(new GridBagLayout());
			detailConfigPanel.add(getClassConfigScrollPane(), gridBagConstraints17);
			detailConfigPanel.add(getValidationCheckPanel(), gridBagConstraints18);
		}
		return detailConfigPanel;
	}


	private QueryProcessorParametersTable getQpParamsTable() {
		if (qpParamsTable == null) {
			qpParamsTable = new QueryProcessorParametersTable(getExtensionTypeExtensionData(), getServiceInfo());
		}
		return qpParamsTable;
	}


	private JScrollPane getQpParamsScrollPane() {
		if (qpParamsScrollPane == null) {
			qpParamsScrollPane = new JScrollPane();
			qpParamsScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Processor Parameter Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			qpParamsScrollPane.setViewportView(getQpParamsTable());
		}
		return qpParamsScrollPane;
	}


	/**
	 * p1 must be non-null!!
	 * 
	 * @param p1
	 * @param p2
	 * @return True if the projects have the same values for long name and
	 *         version
	 */
	private boolean projectEquals(Project p1, Project p2) {
		if (p2 != null) {
			return p1.getLongName().equals(p2.getLongName()) && p1.getVersion().equals(p2.getVersion());
		}
		return false;
	}


	private void loadUmlTreeInformation() {
		// if there's existing cadsr configuration, apply it
		CadsrInformation cadsrInfo = null;
		try {
			cadsrInfo = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData()).getCadsrInformation();
		} catch (Exception ex) {
			ErrorDialog.showErrorDialog("Error getting caDSR information from extension data: " + ex.getMessage(), ex);
		}
		if (cadsrInfo != null) {
			getUmlTree().setEnabled(false);
			// set the most recent package info
			String longName = cadsrInfo.getProjectLongName();
			String version = cadsrInfo.getProjectVersion();
			if ((longName != null) && (version != null)) {
				Project tempProject = new Project();
				tempProject.setLongName(longName);
				tempProject.setVersion(version);
				mostRecentProject = tempProject;
			}
			// set the caDSR service URL in the GUI, if there is one
			if (cadsrInfo.getServiceUrl() != null) {
				getCadsrBrowserPanel().setDefaultCaDSRURL(cadsrInfo.getServiceUrl());
				getCadsrBrowserPanel().getCadsr().setText(cadsrInfo.getServiceUrl());
				getCadsrBrowserPanel().discoverFromCaDSR();
				getUmlTree().setEnabled(true);
			}
			// set the domain model filename if there is one
			if (cadsrInfo.isUseSuppliedModel()) {
				// get the supplied domain model filename
				ResourcePropertyType dmResourceProp = CommonTools.getResourcePropertiesOfType(getServiceInfo()
					.getServices().getService(0), DataServiceConstants.DOMAIN_MODEL_QNAME)[0];
				File domainModelFile = new File(getServiceInfo().getBaseDirectory().getAbsolutePath() + File.separator
					+ "etc" + File.separator + dmResourceProp.getFileLocation());
				getDomainModelNameTextField().setText(domainModelFile.getAbsolutePath());
				getUmlTree().setEnabled(false);
			}
			// walk through packages, adding them to the UML tree
			for (int i = 0; (cadsrInfo.getPackages() != null) && (i < cadsrInfo.getPackages().length); i++) {
				CadsrPackage pack = cadsrInfo.getPackages(i);
				String packageName = pack.getName();
				String namespace = pack.getMappedNamespace();
				// keep track of the mapped package / namespace combination
				packageToNamespace.put(packageName, namespace);
				// find the namespace needed for this package in the service
				// description
				NamespaceType[] serviceNamespaces = getServiceInfo().getNamespaces().getNamespace();
				NamespaceType nsType = null;
				for (int nsIndex = 0; nsIndex < serviceNamespaces.length; nsIndex++) {
					NamespaceType ns = serviceNamespaces[nsIndex];
					if (ns.getNamespace().equals(namespace)) {
						nsType = ns;
						break;
					}
				}
				if (nsType != null) {
					// add the package to the types tree
					getUmlTree().addUmlPackage(packageName);
					// prepare a mapping of class to element names
					Map classToElementNames = new HashMap();
					packageToClassMap.put(packageName, classToElementNames);
					for (int j = 0; (pack.getCadsrClass() != null) && (j < pack.getCadsrClass().length); j++) {
						ClassMapping map = pack.getCadsrClass(j);
						classToElementNames.put(map.getClassName(), map.getElementName());
						// add the classes for the uml package to the tree
						UMLClassTreeNode node = getUmlTree().addUmlClass(packageName, map.getClassName());
						node.getCheckBox().setSelected(map.isSelected());
					}
				}
			}
		} else {
			// no caDSR info to load, use default URL from Introduce
			String cadsrDefaultUrl = ResourceManager.getServiceURLProperty("CADSR_URL");
			getCadsrBrowserPanel().setDefaultCaDSRURL(cadsrDefaultUrl);
			getCadsrBrowserPanel().getCadsr().setText(cadsrDefaultUrl);
			getCadsrBrowserPanel().discoverFromCaDSR();
		}
	}


	private void saveProcessorClassName(String className) throws Exception {
		// store the property
		CommonTools.setServiceProperty(getServiceInfo().getServiceDescriptor(),
			DataServiceConstants.QUERY_PROCESSOR_CLASS_PROPERTY, className, false);
		// remove all query processor config properties from the service
		// properties
		ServicePropertiesProperty[] oldProperties = getServiceInfo().getServiceProperties().getProperty();
		List keptProperties = new ArrayList();
		for (int i = 0; i < oldProperties.length; i++) {
			if (!oldProperties[i].getKey().startsWith(DataServiceConstants.QUERY_PROCESSOR_CONFIG_PREFIX)) {
				keptProperties.add(oldProperties[i]);
			}
		}
		ServicePropertiesProperty[] properties = new ServicePropertiesProperty[keptProperties.size()];
		keptProperties.toArray(properties);
		getServiceInfo().getServiceDescriptor().getServiceProperties().setProperty(properties);
		// inform the parameters table that the class name is different
		getQpParamsTable().classChanged();
	}


	private void handlePackageAddition(final Project selectedProject, final UMLPackageMetadata[] selectedPackages) {
		// verify we're in the same project as the other packages
		boolean shouldAddPackages = true;
		if ((mostRecentProject != null)
			&& (!mostRecentProject.getLongName().equals(selectedProject.getLongName()) || !mostRecentProject
				.getVersion().equals(selectedProject.getVersion()))) {
			// not the same project, can't allow packages from more than one
			// project!
			String[] choices = {"Remove all other packages and insert", "Cancel"};
			String[] message = {"Domain models may only be derived from one project.",
					"To add the package you've selected, all other packages",
					"currently in the domain model will have to be removed.", "Should this operation procede?"};
			String choice = PromptButtonDialog.prompt(PortalResourceManager.getInstance().getGridPortal(),
				"Package incompatability...", message, choices, choices[1]);
			if (choice == choices[0]) {
				// try to remove namespaces from the service
				Iterator nsNameIter = packageToNamespace.values().iterator();
				while (nsNameIter.hasNext()) {
					String namespace = (String) nsNameIter.next();
					NamespaceType nsType = CommonTools.getNamespaceType(getServiceInfo().getNamespaces(), namespace);
					if (!CommonTools.isNamespaceTypeInUse(nsType, getServiceInfo().getServiceDescriptor())) {
						NamespaceType[] allNamespaces = getServiceInfo().getNamespaces().getNamespace();
						NamespaceType[] cleanedNamespaces = (NamespaceType[]) Utils.removeFromArray(allNamespaces,
							nsType);
						getServiceInfo().getNamespaces().setNamespace(cleanedNamespaces);
					}
				}
				// clear out the existing packages and classes
				packageToNamespace.clear();
				packageToClassMap.clear();
				// clear out the types table
				getClassConfigTable().clearTable();
				// clear out the types tree
				getUmlTree().clearTree();
			} else {
				shouldAddPackages = false;
			}
		}
		if (shouldAddPackages) {
			for (int i = 0; i < selectedPackages.length; i++) {
				addPackageToModel(selectedProject, selectedPackages[i]);
			}
			mostRecentProject = selectedProject;
			// store the (potential) change to project info
			storeMostRecentProjectInformation();
			// store the package information
			storeUpdatedPackageInformation();
		}
	}


	private void addPackageToModel(Project project, UMLPackageMetadata pack) {
		if (!packageToNamespace.containsKey(pack.getName())) {
			// determine if the namespace type already exists in the service
			String namespaceUri = NamespaceUtils.createNamespaceString(project, pack);
			NamespaceType nsType = NamespaceUtils.getServiceNamespaceType(getServiceInfo(), namespaceUri);
			if (nsType == null) {
				// ask the user to locate the schemas
				String[] message = {"No namespace is present in the service for the package", pack.getName() + ".",
						"Please specify a schema."};
				JOptionPane.showMessageDialog(this, message);
				CadsrPackage tempPackage = new CadsrPackage();
				tempPackage.setName(pack.getName());
				tempPackage.setMappedNamespace(namespaceUri);
				NamespaceType[] namespaces = SchemaResolutionDialog.resolveSchemas(getServiceInfo(), tempPackage);
				if ((namespaces != null) && (namespaces.length != 0)) {
					nsType = namespaces[0];
					// add the new namespaces to the service
					for (int i = 0; i < namespaces.length; i++) {
						CommonTools.addNamespace(getServiceInfo().getServiceDescriptor(), namespaces[i]);
					}
				}
			}
			if (nsType != null) {
				// map the package to the new namespace and add it to the types
				// tree
				packageToNamespace.put(pack.getName(), nsType.getNamespace());
				getUmlTree().addUmlPackage(pack.getName());
				// get classes for the package
				String cadsrUrl = getCadsrBrowserPanel().getCadsr().getText();
				try {
					CaDSRServiceClient cadsrClient = new CaDSRServiceClient(cadsrUrl);
					UMLClassMetadata[] classMd = cadsrClient.findClassesInPackage(project, pack.getName());
					for (int i = 0; i < classMd.length; i++) {
						getUmlTree().addUmlClass(pack.getName(), classMd[i].getName());
					}
					// map the classes to schema types
					Map classToType = NamespaceUtils.mapClassesToElementNames(classMd, nsType);
					// store the mapping
					packageToClassMap.put(pack.getName(), classToType);
				} catch (Exception ex) {
					ex.printStackTrace();
					ErrorDialog.showErrorDialog("Error getting classes from caDSR", ex);
				}
			}
		}
	}


	private ClassMapping getClassMapping(String packName, String className) throws Exception {
		// see if there's a class mapping in the extension data
		Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
		CadsrInformation info = data.getCadsrInformation();
		if (info != null) {
			CadsrPackage[] packages = info.getPackages();
			// find the package
			for (int i = 0; (packages != null) && (i < packages.length); i++) {
				if (packages[i].getName().equals(packName)) {
					ClassMapping[] mappings = packages[i].getCadsrClass();
					for (int j = 0; (mappings != null) && (j < mappings.length); j++) {
						if (mappings[j].getClassName().equals(className)) {
							return mappings[j];
						}
					}
				}
			}
		}
		// no mapping found in cadsr info, create a new one
		String elemName = (String) ((Map) packageToClassMap.get(packName)).get(className);
		ClassMapping mapping = new ClassMapping();
		mapping.setClassName(className);
		mapping.setElementName(elemName);
		mapping.setSelected(true);
		mapping.setTargetable(true);
		return mapping;
	}


	private void storeCadsrServiceUrl() {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info == null) {
				info = new CadsrInformation();
				data.setCadsrInformation(info);
			}
			info.setServiceUrl(getCadsrBrowserPanel().getCadsr().getText());
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error storing cadsr service URL", ex);
		}
	}


	private void storeNoDomainModelInfo() {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info == null) {
				info = new CadsrInformation();
				data.setCadsrInformation(info);
			}
			info.setNoDomainModel(getNoDomainModelRadioButton().isSelected());
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error storing domain model use information", ex);
		}
	}


	private void storeMostRecentProjectInformation() {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info == null) {
				info = new CadsrInformation();
				data.setCadsrInformation(info);
			}
			info.setProjectLongName(mostRecentProject.getLongName());
			info.setProjectVersion(mostRecentProject.getVersion());
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error storing project information", ex);
		}
	}


	private void storeUpdatedPackageInformation() {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info == null) {
				info = new CadsrInformation();
				data.setCadsrInformation(info);
			}
			Map packagesByName = new HashMap();
			// determine what currently stored packages can be kept
			for (int i = 0; (info.getPackages() != null) && (i < info.getPackages().length); i++) {
				String packName = info.getPackages(i).getName();
				// if the package is still in the mapping, keep it
				if (packageToNamespace.containsKey(packName)) {
					// update the namespace mapping
					info.getPackages(i).setMappedNamespace((String) packageToNamespace.get(packName));
					packagesByName.put(packName, info.getPackages(i));
				}
			}
			// iterate the current package mapping, looking for things
			// not already present in the stored package mappings
			Iterator currentPackNames = packageToNamespace.keySet().iterator();
			while (currentPackNames.hasNext()) {
				String name = (String) currentPackNames.next();
				if (!packagesByName.containsKey(name)) {
					// create a new package
					CadsrPackage newPackage = new CadsrPackage();
					newPackage.setName(name);
					newPackage.setMappedNamespace((String) packageToNamespace.get(name));
					// create class mappings for the new package
					Map packageClasses = (Map) packageToClassMap.get(name);
					ClassMapping[] mappings = new ClassMapping[packageClasses.size()];
					int mappingIndex = 0;
					Iterator classNameIter = packageClasses.keySet().iterator();
					while (classNameIter.hasNext()) {
						mappings[mappingIndex] = getClassMapping(name, (String) classNameIter.next());
						mappingIndex++;
					}
					packagesByName.put(name, newPackage);
				}
			}
			// put the updated packages into the cadsr information
			CadsrPackage[] updated = new CadsrPackage[packagesByName.size()];
			packagesByName.values().toArray(updated);
			info.setPackages(updated);
			// store the data
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error storing package information", ex);
		}
	}


	private void storeClassMapping(String packName, ClassMapping mapping) {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info == null) {
				// this is bad anyway, because we won't have any packages....
				info = new CadsrInformation();
				data.setCadsrInformation(info);
			}
			CadsrPackage pack = null;
			for (int i = 0; (info.getPackages() != null) && (i < info.getPackages().length); i++) {
				if (info.getPackages(i).getName().equals(packName)) {
					pack = info.getPackages(i);
					break;
				}
			}
			if (pack == null) {
				// no package found
				throw new IllegalArgumentException("Package " + packName + " is not stored in the extension data");
			}
			// see if the class mapping is already in the package
			boolean found = false;
			for (int i = 0; (pack.getCadsrClass() != null) && (i < pack.getCadsrClass().length); i++) {
				if (pack.getCadsrClass(i).getClassName().equals(mapping.getClassName())) {
					pack.setCadsrClass(i, mapping);
					found = true;
					break;
				}
			}
			if (!found) {
				ClassMapping[] current = pack.getCadsrClass();
				if (current == null) {
					current = new ClassMapping[]{mapping};
				} else {
					current = (ClassMapping[]) Utils.appendToArray(current, mapping);
				}
				pack.setCadsrClass(current);
			}
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error storing class mapping information", ex);
		}
	}


	private void unselectClassMapping(String packName, String className) {
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			CadsrInformation info = data.getCadsrInformation();
			if (info == null) {
				info = new CadsrInformation();
				data.setCadsrInformation(info);
			}
			// find the package
			CadsrPackage pack = null;
			for (int i = 0; (info.getPackages() != null) && (i < info.getPackages().length); i++) {
				if (info.getPackages(i).getName().equals(packName)) {
					pack = info.getPackages(i);
					break;
				}
			}
			if (pack != null) {
				// find the class mapping
				for (int i = 0; (pack.getCadsrClass() != null) && (i < pack.getCadsrClass().length); i++) {
					if (pack.getCadsrClass(i).getClassName().equals(className)) {
						pack.getCadsrClass(i).setSelected(false);
						break;
					}
				}
			}
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error removing class mapping", ex);
		}
	}


	private void removeStoredCadsrInformation() {
		// take out cadsr information from extension data
		try {
			Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
			data.setCadsrInformation(null);
			ExtensionDataUtils.storeExtensionData(getExtensionTypeExtensionData(), data);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorDialog.showErrorDialog("Error removing cadsr information from extension", ex);
		}
	}


    /**
     * This method initializes visualizeDomainModelButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getVisualizeDomainModelButton() {
        if (visualizeDomainModelButton == null) {
            visualizeDomainModelButton = new JButton();
            visualizeDomainModelButton.setText("Visualize Domain Model");
            visualizeDomainModelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    DomainModel model = null;
                    // get the domain model selected
                    if (getSuppliedDomainModelRadioButton().isSelected()
                        && getDomainModelNameTextField().getText().length() != 0) {
                        // domain model from file system
                        String filename = getDomainModelNameTextField().getText();
                        try {
                            model = MetadataUtils.deserializeDomainModel(
                                new FileReader(filename));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            ErrorDialog.showErrorDialog("Error loading domain model: " + ex.getMessage(), ex);
                        }
                    } else if (getCadsrDomainModelRadioButton().isSelected()) {
                        // build the domain model
                        try {
                            Data data = ExtensionDataUtils.getExtensionData(getExtensionTypeExtensionData());
                            CadsrInformation info = data.getCadsrInformation();
                            // TODO: busy dialog runnable
                            model = DomainModelCreationUtil.createDomainModel(info);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            ErrorDialog.showErrorDialog("Error getting caDSR information: " + ex.getMessage(), ex);
                        }   
                    }
                    if (model != null) {
                        new DomainModelVisualizationDialog(model);
                    }
                }
            });
        }
        return visualizeDomainModelButton;
    }
}