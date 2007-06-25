package gov.nih.nci.cagrid.introduce.portal;

import gov.nih.nci.cagrid.common.portal.PortalUtils;
import gov.nih.nci.cagrid.common.portal.SplashScreen;
import gov.nih.nci.cagrid.introduce.common.ResourceManager;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import org.projectmobius.common.MobiusException;
import org.projectmobius.portal.GridPortal;
import org.projectmobius.portal.PortalResourceManager;


public final class Introduce {

    private static SplashScreen introduceSplash;


    private static void showIntroduceSplash() {
        try {
            introduceSplash = new SplashScreen("/introduceSplash.png");
            PortalUtils.centerWindowInScreen(introduceSplash);
            introduceSplash.setVisible(true);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }


    private static void initialize() {

    }


    private static void showGridPortal(String confFile) {
        try {
            initialize();
            showIntroduceSplash();
            
            GridPortal portal = null;
            if (confFile == null) {
                confFile = ResourceManager.getPortalConfigFileLocation();
            }
            portal = new GridPortal(confFile);
            Dimension dim = PortalResourceManager.getInstance().getGridPortalConfig().getApplicationDimensions();
            try {
                portal.pack();
            } catch (Exception e) {
                portal.setIconImage(null);
                portal.pack();
            }
            portal.setSize(dim);
            portal.setVisible(true);
            portal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (MobiusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private static final class IntroduceSplashCloser implements Runnable {
        public void run() {
            try {
                introduceSplash.dispose();
            } catch (Exception e) {

            }
        }
    }
    
    public static void main(String[] args) {
        if (args.length > 0) {
            showGridPortal(args[0]);
        } else {
            showGridPortal(null);
        }
        EventQueue.invokeLater(new IntroduceSplashCloser());
    }

}
