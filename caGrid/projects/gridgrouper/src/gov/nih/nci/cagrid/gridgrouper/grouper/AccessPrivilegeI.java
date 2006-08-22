package gov.nih.nci.cagrid.gridgrouper.grouper;

import edu.internet2.middleware.subject.Subject;

/**
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella</A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster</A>
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Hastings</A>
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * 
 * @version $Id: GridGrouperBaseTreeNode.java,v 1.1 2006/08/04 03:49:26 langella
 *          Exp $
 */
public interface AccessPrivilegeI {
	public GroupI getGroup();

	public String getImplementationName();

	public String getName();

	public Subject getOwner();

	public Subject getSubject();

	public boolean isRevokable();
}
