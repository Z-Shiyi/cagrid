/**
 * 
 */
package gov.nih.nci.cagrid.portal2.portlet.tree;

import java.util.Map;

/**
 * @author <a href="mailto:joshua.phillips@semanticbits.com">Joshua Phillips</a>
 *
 */
public interface TreeNodeRenderer {
	String render(TreeNode node, Map<String, Object> params);
}
