package org.cagrid.grape;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import org.cagrid.grape.model.Component;
import org.projectmobius.common.MobiusRunnable;
import org.projectmobius.common.MobiusRunnableGroup;


/**
 * @author <A href="mailto:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A href="mailto:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A href="mailto:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @created Oct 14, 2004
 * @version $Id: ArgumentManagerTable.java,v 1.2 2004/10/15 16:35:16 langella
 *          Exp $
 */
public class ApplicationContext {

	private GridApplication application;

	private Component component;


	public ApplicationContext(GridApplication application) {
		this(application, null);
	}


	public ApplicationContext(GridApplication application, Component component) {
		this.application = application;
		this.component = component;
	}


	public Component getComponent() {
		return component;
	}


	public void addApplicationComponent(ApplicationComponent comp) {
		this.application.addApplicationComponent(comp);
	}


	public void addApplicationComponent(ApplicationComponent comp, int width, int height) {
		this.application.addApplicationComponent(comp, width, height);
	}


	public ConfigurationManager getConfigurationManager() {
		return this.application.getConfigurationManager();
	}


	public void executeInBackground(MobiusRunnable r) throws Exception {
		this.application.getThreadManager().executeInBackground(r);
	}


	public void executeInBackground(MobiusRunnableGroup grp) throws Exception {
		this.application.getThreadManager().executeGroupInBackground(grp);
	}


	public void execute(MobiusRunnable r) throws Exception {
		this.application.getThreadManager().execute(r);
	}


	public void execute(MobiusRunnableGroup grp) throws Exception {
		this.application.getThreadManager().executeGroup(grp);
	}


	public void centerComponent(JComponent comp) {
		// Determine the new location of the window
		int w = application.getSize().width;
		int h = application.getSize().height;
		int x = application.getLocationOnScreen().x;
		int y = application.getLocationOnScreen().y;
		Dimension dim = comp.getSize();
		comp.setLocation(w / 2 + x - dim.width / 2, h / 2 + y - dim.height / 2);
	}


	public void centerWindow(Window comp) {
		// Determine the new location of the window
		int w = application.getSize().width;
		int h = application.getSize().height;
		int x = application.getLocationOnScreen().x;
		int y = application.getLocationOnScreen().y;
		Dimension dim = comp.getSize();
		comp.setLocation(w / 2 + x - dim.width / 2, h / 2 + y - dim.height / 2);
	}


	public void showMessage(String msg) {
		showMessage(new String[]{msg});
	}


	public void showMessage(String[] msg) {
		showMessage("Information", msg);
	}


	public void showMessage(String title, String msg) {
		showMessage(title, new String[]{msg});
	}


	public void showMessage(String title, String[] msg) {
		JOptionPane.showMessageDialog(this.application, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
