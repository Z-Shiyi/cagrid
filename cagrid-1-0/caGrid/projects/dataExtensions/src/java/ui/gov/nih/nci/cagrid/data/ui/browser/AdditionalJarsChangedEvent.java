package gov.nih.nci.cagrid.data.ui.browser;

import java.util.EventObject;

/** 
 *  AdditionalJarsEvent
 *  Event fired when additional jars change in the class browser panel
 * 
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * 
 * @created May 12, 2006 
 * @version $Id: AdditionalJarsChangedEvent.java,v 1.1.2.1 2007-08-14 14:42:01 dervin Exp $ 
 */
public class AdditionalJarsChangedEvent extends EventObject {

	public AdditionalJarsChangedEvent(ClassBrowserPanel source) {
		super(source);
	}
}
