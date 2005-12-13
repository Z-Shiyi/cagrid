package gov.nih.nci.cagrid.gums.ifs.portal;

import gov.nih.nci.cagrid.common.portal.PortalUtils;
import gov.nih.nci.cagrid.gums.IFSAdministration;
import gov.nih.nci.cagrid.gums.bean.PermissionDeniedFault;
import gov.nih.nci.cagrid.gums.client.IFSAdministrationClient;
import gov.nih.nci.cagrid.gums.ifs.bean.TrustedIdP;
import gov.nih.nci.cagrid.gums.portal.GUMSServiceListComboBox;
import gov.nih.nci.cagrid.gums.portal.GumsLookAndFeel;
import gov.nih.nci.cagrid.gums.portal.ProxyComboBox;
import gov.nih.nci.cagrid.security.commstyle.CommunicationStyle;
import gov.nih.nci.cagrid.security.commstyle.SecureConversationWithEncryption;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.globus.gsi.GlobusCredential;
import org.projectmobius.common.MobiusRunnable;
import org.projectmobius.portal.GridPortalBaseFrame;
import org.projectmobius.portal.PortalResourceManager;


/**
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Langella </A>
 * @version $Id: TrustedIdPsWindow.java,v 1.2 2005-12-13 19:53:22 langella Exp $
 */
public class TrustedIdPsWindow extends GridPortalBaseFrame {

	private javax.swing.JPanel jContentPane = null;

	private JPanel mainPanel = null;

	private JPanel contentPanel = null;

	private JPanel buttonPanel = null;

	private TrustedIdPTable trustedIdPTable = null;

	private JScrollPane jScrollPane = null;

	private JButton manageUser = null;

	private JPanel jPanel = null;

	private JPanel jPanel2 = null;

	private JLabel jLabel14 = null;

	private JPanel queryPanel = null;

	private JButton query = null;

	private JComboBox service = null;

	private boolean isQuerying = false;

	private Object mutex = new Object();

	private JLabel proxyLabel = null;

	private JComboBox proxy = null;

	private JPanel progressPanel = null;

	private JProgressBar progress = null;

	private String lastService = null;

	private String lastGridIdentity = null;

	private JButton removeUser = null;

	private JButton addUser = null;


	/**
	 * This is the default constructor
	 */
	public TrustedIdPsWindow() {
		super();
		initialize();
		this.setFrameIcon(GumsLookAndFeel.getTrustedIdPIcon());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Trusted Identity Provider Management");

	}


	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getMainPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 0;
			gridBagConstraints32.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints32.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints32.weightx = 1.0D;
			gridBagConstraints32.gridy = 2;
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.gridx = 0;
			gridBagConstraints33.gridy = 1;
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.gridx = 0;
			gridBagConstraints35.weightx = 1.0D;
			gridBagConstraints35.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints35.gridy = 0;

			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridBagLayout());
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 3;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints1.weightx = 1.0D;
			gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints1.weighty = 1.0D;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 6;
			gridBagConstraints2.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints2.anchor = java.awt.GridBagConstraints.SOUTH;
			gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			mainPanel.add(getButtonPanel(), gridBagConstraints2);
			mainPanel.add(getContentPanel(), gridBagConstraints1);
			mainPanel.add(getJPanel(), gridBagConstraints35);
			mainPanel.add(getQueryPanel(), gridBagConstraints33);
			mainPanel.add(getProgressPanel(), gridBagConstraints32);
		}
		return mainPanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getContentPanel() {
		if (contentPanel == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			contentPanel = new JPanel();
			contentPanel.setLayout(new GridBagLayout());
			contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trusted IdPs",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, null, GumsLookAndFeel.getPanelLabelColor()));
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
			contentPanel.add(getJScrollPane(), gridBagConstraints4);
		}
		return contentPanel;
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getAddUser(), null);
			buttonPanel.add(getManageUser(), null);
			buttonPanel.add(getRemoveUser(), null);
		}
		return buttonPanel;
	}


	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private TrustedIdPTable getTrustedIdPTable() {
		if (trustedIdPTable == null) {
			trustedIdPTable = new TrustedIdPTable(this);
		}
		return trustedIdPTable;
	}


	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTrustedIdPTable());
		}
		return jScrollPane;
	}


	/**
	 * This method initializes manageUser
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getManageUser() {
		if (manageUser == null) {
			manageUser = new JButton();
			manageUser.setText("View/Edit Trusted IdP");
			manageUser.setIcon(GumsLookAndFeel.getTrustedIdPIcon());
			manageUser.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					showTrustedIdP();
				}

			});
		}

		return manageUser;
	}


	public void showTrustedIdP() {
		try {
			String service = ((GUMSServiceListComboBox) getService()).getSelectedService();
			GlobusCredential proxy = ((ProxyComboBox) getProxy()).getSelectedProxy();
			PortalResourceManager.getInstance().getGridPortal().addGridPortalComponent(new TrustedIdPWindow(service,proxy,getTrustedIdPTable().getSelectedTrustedIdP()));
		} catch (Exception e) {
			PortalUtils.showErrorMessage(e);
		}
	}
	
	public void addTrustedIdP() {
		try {
			String service = ((GUMSServiceListComboBox) getService()).getSelectedService();
			GlobusCredential proxy = ((ProxyComboBox) getProxy()).getSelectedProxy();
			PortalResourceManager.getInstance().getGridPortal().addGridPortalComponent(new TrustedIdPWindow(service,proxy));
		} catch (Exception e) {
			PortalUtils.showErrorMessage(e);
		}
	}


	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints34.gridy = 0;
			gridBagConstraints34.weightx = 1.0D;
			gridBagConstraints34.gridx = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJPanel2(), gridBagConstraints34);
		}
		return jPanel;
	}


	/**
	 * This method initializes jPanel2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints30.gridx = 1;
			gridBagConstraints30.gridy = 1;
			gridBagConstraints30.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints30.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints30.weightx = 1.0;
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 0;
			gridBagConstraints29.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints29.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints29.gridy = 1;
			proxyLabel = new JLabel();
			proxyLabel.setText("Proxy");
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints28.gridx = 1;
			gridBagConstraints28.gridy = 0;
			gridBagConstraints28.insets = new java.awt.Insets(2, 2, 2, 2);
			gridBagConstraints28.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints28.weightx = 1.0;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridwidth = 1;
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.gridy = 0;
			gridBagConstraints31.insets = new Insets(2, 2, 2, 2);
			jLabel14 = new JLabel();
			jLabel14.setText("Service");
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Login Information",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, GumsLookAndFeel
					.getPanelLabelColor()));
			jPanel2.add(jLabel14, gridBagConstraints31);
			jPanel2.add(getService(), gridBagConstraints28);
			jPanel2.add(proxyLabel, gridBagConstraints29);
			jPanel2.add(getProxy(), gridBagConstraints30);
		}
		return jPanel2;
	}


	/**
	 * This method initializes queryPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getQueryPanel() {
		if (queryPanel == null) {
			queryPanel = new JPanel();
			queryPanel.add(getQuery(), null);
		}
		return queryPanel;
	}


	/**
	 * This method initializes query
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getQuery() {
		if (query == null) {
			query = new JButton();
			query.setText("Find Trusted Identity Providers");
			query.setIcon(GumsLookAndFeel.getQueryIcon());
			query.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MobiusRunnable runner = new MobiusRunnable() {
						public void execute() {
							findTrustedIdPs();
						}
					};
					try {
						PortalResourceManager.getInstance().getThreadManager().executeInBackground(runner);
					} catch (Exception t) {
						t.getMessage();
					}

				}
			});
		}
		return query;
	}


	private void findTrustedIdPs() {

		synchronized (mutex) {
			if (isQuerying) {
				PortalUtils.showErrorMessage("Query Already in Progress",
					"Please wait until the current query is finished before executing another.");
				return;
			} else {
				isQuerying = true;
			}
		}

		this.getTrustedIdPTable().clearTable();
		this.updateProgress(true, "Finding Trusted IdPs...");

		try {
			GlobusCredential proxy = ((ProxyComboBox) getProxy()).getSelectedProxy();
			String service = ((GUMSServiceListComboBox) getService()).getSelectedService();
			CommunicationStyle style = new SecureConversationWithEncryption(proxy);

			IFSAdministration client = new IFSAdministrationClient(service, style);
			TrustedIdP[] idps = client.getTrustedIdPs();
			for (int i = 0; i < idps.length; i++) {
				this.getTrustedIdPTable().addTrustedIdP(idps[i]);
			}
			this.updateProgress(false, "Completed [Found " + idps.length + " IdPs]");

		} catch (PermissionDeniedFault pdf) {
			PortalUtils.showErrorMessage(pdf);
			this.updateProgress(false, "Error");
		} catch (Exception e) {
			e.printStackTrace();
			PortalUtils.showErrorMessage(e);
			this.updateProgress(false, "Error");
		}
		isQuerying = false;

	}


	/**
	 * This method initializes service
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getService() {
		if (service == null) {
			service = new GUMSServiceListComboBox();
		}
		return service;
	}


	/**
	 * This method initializes proxy
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getProxy() {
		if (proxy == null) {
			proxy = new ProxyComboBox();
		}
		return proxy;
	}


	/**
	 * This method initializes progressPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getProgressPanel() {
		if (progressPanel == null) {
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.insets = new java.awt.Insets(2, 20, 2, 20);
			gridBagConstraints36.gridy = 0;
			gridBagConstraints36.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints36.weightx = 1.0D;
			gridBagConstraints36.gridx = 0;
			progressPanel = new JPanel();
			progressPanel.setLayout(new GridBagLayout());
			progressPanel.add(getProgress(), gridBagConstraints36);
		}
		return progressPanel;
	}


	/**
	 * This method initializes progress
	 * 
	 * @return javax.swing.JProgressBar
	 */
	private JProgressBar getProgress() {
		if (progress == null) {
			progress = new JProgressBar();
			progress.setForeground(GumsLookAndFeel.getPanelLabelColor());
			progress.setString("");
			progress.setStringPainted(true);
		}
		return progress;
	}


	public void updateProgress(final boolean working, final String s) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				getProgress().setString(s);
				getProgress().setIndeterminate(working);
			}
		});

	}


	/**
	 * This method initializes removeUser
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getRemoveUser() {
		if (removeUser == null) {
			removeUser = new JButton();
			removeUser.setText("Remove User");
			removeUser.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MobiusRunnable runner = new MobiusRunnable() {
						public void execute() {
							removeUser();
						}
					};
					try {
						PortalResourceManager.getInstance().getThreadManager().executeInBackground(runner);
					} catch (Exception t) {
						t.getMessage();
					}
				}
			});
			removeUser.setIcon(GumsLookAndFeel.getRemoveUserIcon());
		}
		return removeUser;
	}


	private void removeUser() {
		/*
		 * String service = ((GUMSServiceListComboBox)
		 * getService()).getSelectedService(); try { GlobusCredential proxy =
		 * ((ProxyComboBox) getProxy()).getSelectedProxy(); CommunicationStyle
		 * style = new SecureConversationWithEncryption(proxy);
		 * IFSAdministrationClient client = new IFSAdministrationClient(service,
		 * style); ; IFSUser usr = this.getTrustedIdPTable().getSelectedUser();
		 * client.removeUser(usr);
		 * this.getTrustedIdPTable().removeSelectedUser(); } catch (Exception e) {
		 * PortalUtils.showErrorMessage(e); }
		 */
	}


	/**
	 * This method initializes addUser	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getAddUser() {
		if (addUser == null) {
			addUser = new JButton();
			addUser.setText("Add Trusted IdP");
			addUser.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					addTrustedIdP();
				}
			});
			addUser.setIcon(GumsLookAndFeel.getAddTrustedIdPIcon());
		}
		return addUser;
	}

}
