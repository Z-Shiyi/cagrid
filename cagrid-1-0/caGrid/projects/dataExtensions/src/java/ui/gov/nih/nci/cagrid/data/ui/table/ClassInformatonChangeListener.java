package gov.nih.nci.cagrid.data.ui.table;

/** 
 *  ClassInformatonChangeListener
 *  Listens for events pertaining to changes of the class information
 * 
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * 
 * @created Oct 6, 2006 
 * @version $Id: ClassInformatonChangeListener.java,v 1.1.2.1 2007-08-14 14:42:01 dervin Exp $ 
 */
public interface ClassInformatonChangeListener {

	public void elementNameChanged(ClassChangeEvent e);
	
	
	public void serializationChanged(ClassChangeEvent e);
	
	
	public void targetabilityChanged(ClassChangeEvent e);
}
