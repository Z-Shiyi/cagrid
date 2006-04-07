package gov.nih.nci.cagrid.introduce.portal.deployment;

import gov.nih.nci.cagrid.common.portal.BusyDialogRunnable;
import gov.nih.nci.cagrid.common.portal.PortalLookAndFeel;
import gov.nih.nci.cagrid.common.portal.PortalUtils;
import gov.nih.nci.cagrid.introduce.ResourceManager;
import gov.nih.nci.cagrid.introduce.common.CommonTools;
import gov.nih.nci.cagrid.introduce.portal.IntroduceLookAndFeel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.projectmobius.portal.GridPortalBaseFrame;
import org.projectmobius.portal.PortalResourceManager;


/**
 * CreationViewer
 * 
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella </A>
 * @created Jun 22, 2005
 * @version $Id: mobiusEclipseCodeTemplates.xml,v 1.2 2005/04/19 14:58:02 oster
 *          Exp $
 */
public class DeploymentViewer extends GridPortalBaseFrame {

	private static final String GLOBUS = "GLOBUS_LOCATION";

	private static final String TOMCAT = "CATALINA_HOME";

	private JPanel inputPanel = null;

	private JPanel mainPanel = null;

	private JPanel buttonPanel = null;

	private JButton deployButton = null;

	private JButton closeButton = null;

	private File serviceDirectory;

	Properties deployProperties;

	private JPanel deploymentTypePanel = null;

	private JComboBox deploymentTypeSelector = null;

	/**
	 * This method initializes
	 */
	public DeploymentViewer() {
		super();
		createChooserThread().start();
	}


	private Thread createChooserThread() {
		Thread th = new Thread(new Runnable() {

			public void run() {
				try {
					chooseService();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (serviceDirectory == null) {
					DeploymentViewer.this.dispose();
					return;
				}
				if (serviceDirectory.exists() && serviceDirectory.canRead()) {
					initialize();
				} else {
					JOptionPane.showMessageDialog(DeploymentViewer.this, "Directory "
						+ serviceDirectory.getAbsolutePath() + " does not seem to be an introduce service");
					DeploymentViewer.this.dispose();
				}
			}

		});
		return th;
	}


	private void chooseService() throws Exception {
		String dir = ResourceManager.promptDir(this, null);
		if (dir != null) {
			this.serviceDirectory = new File(dir);
		}
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getMainPanel());
		this.setFrameIcon(IntroduceLookAndFeel.getDeployIcon());
		this.setTitle("Deploy Grid Service");

		File deployPropertiesFile = new File(serviceDirectory.getAbsolutePath() + File.separator + "deploy.properties");
		deployProperties = new Properties();
		try {
			deployProperties.load(new FileInputStream(deployPropertiesFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration keys = deployProperties.keys();
		int i = 0;
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			this.addTextField(this.getInputPanel(), key, deployProperties.getProperty(key), i++, true);
		}
		pack();

	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getInputPanel() {
		if (inputPanel == null) {
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridy = 3;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints10.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints10.gridwidth = 2;
			gridBagConstraints10.weighty = 1.0D;
			gridBagConstraints10.gridx = 1;
			inputPanel = new JPanel();
			inputPanel.setLayout(new GridBagLayout());
			inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deployment Properties",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.gridy = 3;
			gridBagConstraints9.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints9.anchor = java.awt.GridBagConstraints.WEST;
		}
		return inputPanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.anchor = java.awt.GridBagConstraints.SOUTH;
			gridBagConstraints1.weighty = 0.0D;
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridheight = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridheight = 1;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
			gridBagConstraints.weightx = 0.0D;
			gridBagConstraints.weighty = 0.0D;
			gridBagConstraints.gridwidth = 1;
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridBagLayout());
			mainPanel.add(getInputPanel(), gridBagConstraints);
			mainPanel.add(getButtonPanel(), gridBagConstraints1);
			mainPanel.add(getDeploymentTypePanel(), gridBagConstraints11);
		}
		return mainPanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getDeployButton(), null);
			buttonPanel.add(getCloseButton(), null);
		}
		return buttonPanel;
	}


	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getDeployButton() {
		if (deployButton == null) {
			deployButton = new JButton();
			deployButton.setText("Deploy");
			deployButton.setIcon(IntroduceLookAndFeel.getDeployIcon());
			deployButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BusyDialogRunnable r = new BusyDialogRunnable(PortalResourceManager.getInstance().getGridPortal(),
						"Deployment") {

						public void process() {
							setProgressText("validating environment variables");

							setProgressText("writing deployment property file");

							Enumeration keys = deployProperties.keys();
							while (keys.hasMoreElements()) {
								String key = (String) keys.nextElement();
								String value = getTextFieldValue(key);
								deployProperties.setProperty(key, value);
							}

							try {
								deployProperties.store(new FileOutputStream(new File(serviceDirectory.getAbsolutePath()
									+ File.separator + "deploy.properties")), "service deployment properties");
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
								setErrorMessage("Error: " + ex.getMessage());
							} catch (IOException ex) {
								ex.printStackTrace();
								setErrorMessage("Error: " + ex.getMessage());
							}
							
							setProgressText("deploying");
							
							try {
								String cmd = "";
								if (((String) getDeploymentTypeSelector().getSelectedItem()).equals(GLOBUS)) {
									cmd = CommonTools.getAntDeployGlobusCommand(serviceDirectory.getAbsolutePath());
								} else {
									cmd = CommonTools.getAntDeployTomcatCommand(serviceDirectory.getAbsolutePath());
								}
								Process p = CommonTools.createAndOutputProcess(cmd);
								p.waitFor();
								if (p.exitValue() != 0) {
									setErrorMessage("Error deploying service!");
								} 
							} catch (Exception ex) {
								setErrorMessage("Error deploying service! " + ex.getMessage());
								ex.printStackTrace();
							}
						}
					};
					Thread th = new Thread(r);
					th.start();
				}
			});
		}

		return deployButton;
	}


	/**
	 * This method initializes closeButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton();
			closeButton.setIcon(PortalLookAndFeel.getCloseIcon());
			closeButton.setText("Done");
			closeButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return closeButton;
	}


	/**
	 * This method initializes deploymetnTypePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDeploymentTypePanel() {
		if (deploymentTypePanel == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.weightx = 1.0;
			deploymentTypePanel = new JPanel();
			deploymentTypePanel.setLayout(new GridBagLayout());
			deploymentTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deployment Location",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, PortalLookAndFeel.getPanelLabelColor()));
			deploymentTypePanel.add(getDeploymentTypeSelector(), gridBagConstraints2);
		}
		return deploymentTypePanel;
	}


	/**
	 * This method initializes deploymentTypeSelector
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getDeploymentTypeSelector() {
		if (deploymentTypeSelector == null) {
			deploymentTypeSelector = new JComboBox();
			deploymentTypeSelector.addItem(TOMCAT);
			deploymentTypeSelector.addItem(GLOBUS);
		}
		return deploymentTypeSelector;
	}
}
