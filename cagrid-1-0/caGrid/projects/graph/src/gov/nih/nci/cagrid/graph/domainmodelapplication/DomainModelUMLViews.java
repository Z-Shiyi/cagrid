package gov.nih.nci.cagrid.graph.domainmodelapplication;

import gov.nih.nci.cagrid.graph.vstheme.MDIPanel;

import java.awt.Color;
import java.awt.Graphics;

public class DomainModelUMLViews extends MDIPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
	}
	
	public void clear()
	{
		for(int k = 0; k < this.tabs.tabsPane.tabs.size(); k++)
		{
			this.removePage(k);
		}
	}
}
