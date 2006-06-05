package gov.nih.nci.cagrid.introduce.portal.modification.discovery.globus;

import gov.nih.nci.cagrid.introduce.common.CommonTools;
import gov.nih.nci.cagrid.introduce.common.GlobusTools;
import gov.nih.nci.cagrid.introduce.portal.IntroducePortalConf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.projectmobius.common.Namespace;
import org.projectmobius.portal.PortalResourceManager;

public class GlobiusConfigurationPanel extends JPanel {

	public String currentNamespace = null;

	public File currentSchemaFile = null;

	protected File schemaDir;

	private JComboBox namespaceComboBox = null;

	private JLabel namespaceLabel = null;

	public String filterType = null;

	/**
	 * This method initializes
	 */
	public GlobiusConfigurationPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
		gridBagConstraints9.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints9.gridy = 0;
		gridBagConstraints9.insets = new java.awt.Insets(2, 2, 2, 2);
		gridBagConstraints9.gridx = 0;
		namespaceLabel = new JLabel();
		namespaceLabel.setText("Schema");
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints7.gridy = 0;
		gridBagConstraints7.weightx = 1.0;
		gridBagConstraints7.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints7.insets = new java.awt.Insets(2, 2, 2, 2);
		gridBagConstraints7.weighty = 1.0D;
		gridBagConstraints7.gridx = 1;
		this.setLayout(new GridBagLayout());
		this.add(getNamespaceComboBox(), gridBagConstraints7);
		this.add(namespaceLabel, gridBagConstraints9);
	}

	public void discoverFromGlobus() {

		IntroducePortalConf conf = (IntroducePortalConf) PortalResourceManager
				.getInstance().getResource(IntroducePortalConf.RESOURCE);
		List namespaces = null;

		namespaces = CommonTools.getProvidedNamespaces(new File(conf
				.getGlobusLocation()));

		getNamespaceComboBox().removeAllItems();
		for (int i = 0; i < namespaces.size(); i++) {
			getNamespaceComboBox().addItem(namespaces.get(i));
		}
	}

	/**
	 * This method initializes jComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getNamespaceComboBox() {
		if (namespaceComboBox == null) {
			namespaceComboBox = new JComboBox();
			namespaceComboBox
					.addItemListener(new java.awt.event.ItemListener() {
						public void itemStateChanged(java.awt.event.ItemEvent e) {

							String schemaNamespace = (String) namespaceComboBox
									.getSelectedItem();
							currentNamespace = schemaNamespace;
							IntroducePortalConf conf = (IntroducePortalConf)PortalResourceManager.getInstance().getResource(IntroducePortalConf.RESOURCE);
							File schemasDir = new File(conf
									.getGlobusLocation()
									+ File.separator
									+ "share"
									+ File.separator
									+ "schema");
							File foundSchema = CommonTools.findSchema(
									schemaNamespace, schemasDir);
							if (foundSchema != null) {
								currentSchemaFile = foundSchema;
							}
						}
					});
		}
		return namespaceComboBox;
	}

	class SchemaWrapper {
		Namespace ns;

		public Namespace getNamespace() {
			return ns;
		}

		public SchemaWrapper(Namespace ns) {
			this.ns = ns;
		}

		public String toString() {
			return ns.getName();
		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
