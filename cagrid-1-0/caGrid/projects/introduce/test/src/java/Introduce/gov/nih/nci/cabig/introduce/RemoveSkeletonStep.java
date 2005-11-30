package gov.nih.nci.cabig.introduce;

import java.io.File;

import org.projectmobius.common.MobiusException;
import org.projectmobius.common.XMLUtilities;

import gov.nih.nci.cagrid.introduce.CommonTools;

import com.atomicobject.haste.framework.Step;

public class RemoveSkeletonStep extends Step {


	public void runStep() throws Throwable {
		System.out.println("Removing the service skeleton");
		assertTrue(deleteDir(new File(TestCaseInfo.dir)));
	}

    // Deletes all files and subdirectories under dir.
    // Returns true if all deletions were successful.
    // If a deletion fails, the method stops attempting to delete and returns false.
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
    
        // The directory is now empty so delete it
        return dir.delete();
    }

}
