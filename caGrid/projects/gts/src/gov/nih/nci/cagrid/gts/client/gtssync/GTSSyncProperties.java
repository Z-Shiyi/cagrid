package gov.nih.nci.cagrid.gts.client.gtssync;

import java.util.ArrayList;
import java.util.List;


/**
 * @author <A href="mailto:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A href="mailto:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A href="mailto:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @version $Id: ArgumentManagerTable.java,v 1.2 2004/10/15 16:35:16 langella
 *          Exp $
 */
public class GTSSyncProperties {

	private List gtsServices;
	private boolean deleteUnknownFiles;


	public GTSSyncProperties() {
		this.gtsServices = new ArrayList();
		this.deleteUnknownFiles = false;
	}


	public void addSyncDescriptor(SyncDescriptor gts) {
		this.gtsServices.add(gts);
	}


	public int getSyncDescriptorCount() {
		return this.gtsServices.size();
	}


	public SyncDescriptor getSyncDescriptor(int index) {
		return (SyncDescriptor) this.gtsServices.get(index);
	}


	public boolean deleteUnknownFiles() {
		return deleteUnknownFiles;
	}


	public void setDeleteUnknownFiles(boolean deleteUnknownFiles) {
		this.deleteUnknownFiles = deleteUnknownFiles;
	}

}
