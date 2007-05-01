package org.cagrid.installer.steps;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTextPane;

import org.pietschy.wizard.PanelWizardStep;

public class FinishedStep extends PanelWizardStep {

	private JTextPane IntroTextPane = null;

	/**
	 * This method initializes
	 * 
	 */
	public FinishedStep() {
		super();
		initialize();
		this.setComplete(true);
	}

	public String getName() {
		return "Complete";
	}

	public String getSummary() {
		return "caGrid Installation Complete";
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		this.setLayout(new GridBagLayout());
		this.setSize(new Dimension(263, 161));
		this.add(getIntroTextPane(), gridBagConstraints);

	}

	/**
	 * This method initializes IntroTextPane
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getIntroTextPane() {
		if (IntroTextPane == null) {
			IntroTextPane = new JTextPane();
			IntroTextPane
					.setText("caGrid is now installed.  For changes please re-run the installer.");
		}
		return IntroTextPane;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
