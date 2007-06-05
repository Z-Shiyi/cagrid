/**
 * 
 */
package gov.nih.nci.cagrid.portal2.portlet.discovery;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import message.MessageHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 * @author <a href="joshua.phillips@semanticbits.com">Joshua Phillips</a>
 * 
 */
public class SelectGridServiceController extends AbstractController{
	
	private static final Log logger = LogFactory.getLog(SelectGridServiceController.class);
	
	private String successAction;
	
	public String getSuccessAction() {
		return successAction;
	}

	public void setSuccessAction(String successAction) {
		this.successAction = successAction;
	}

	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		String sgsIdStr = request.getParameter("sgs_id");
		logger.debug("sgsIdStr = " + sgsIdStr);
		Integer sgsId = null;
		try {
			sgsId = Integer.parseInt(sgsIdStr);
		} catch (Exception ex) {
			// This should never happen.
			String msg = "Error parsing selected gridService ID = " + sgsIdStr
					+ ": " + ex.getMessage();
			logger.error(msg, ex);
			throw new RuntimeException(msg, ex);
		}
		
		PortletSession portletSession = request.getPortletSession(true);
		String id = getInstanceID(request);
		String msgSessionId = MessageHelper.getSessionID(request);
		MessageHelper.loadPrefs(request, id, msgSessionId);
		MessageHelper helper = new MessageHelper(portletSession, id,
				msgSessionId);
		
		logger.debug("########## publishing selectedGridServiceId = " + sgsId + " #########");
		
		helper.send("selectedGridServiceId", sgsId);

		logger.debug("setting action to " + getSuccessAction());
		response.setRenderParameter("action", getSuccessAction());
	}

	public String getInstanceID(PortletRequest request) {
		return "SelectGridService" + MessageHelper.getPortletID(request);
	}

}
