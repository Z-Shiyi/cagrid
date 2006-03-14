package gov.nih.nci.cagrid.gts.service;

import gov.nih.nci.cagrid.gts.bean.Permission;
import gov.nih.nci.cagrid.gts.common.Database;
import gov.nih.nci.cagrid.gts.stubs.GTSInternalFault;
import gov.nih.nci.cagrid.gts.stubs.IllegalPermissionFault;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @version $Id: TrustedAuthorityManager.java,v 1.1 2006/03/08 19:48:46 langella
 *          Exp $
 */
public class PermissionManager {

	private static final String PERMISSIONS_TABLE = "PERMISSIONS";

	private Logger logger;

	private boolean dbBuilt = false;

	private Database db;

	private String ALL_TRUST_AUTHORITIES = "*";


	public PermissionManager(Database db) {
		logger = Logger.getLogger(this.getClass().getName());
		this.db = db;
	}


	public synchronized void addPermission(Permission p) throws GTSInternalFault, IllegalPermissionFault {

		// This method assumes that any Trusted Authorites associated with a
		// permission is valid
		this.buildDatabase();

		if (this.doesPermissionExist(p)) {
			IllegalPermissionFault fault = new IllegalPermissionFault();
			fault.setFaultString("The permission " + formatPermission(p) + " cannot be added, it already exists.");
			throw fault;
		}

		if (p.getGridIdentity() == null) {
			IllegalPermissionFault fault = new IllegalPermissionFault();
			fault.setFaultString("The permission " + formatPermission(p) + " no grid identity specified.");
			throw fault;
		}

		if (p.getRole() == null) {
			IllegalPermissionFault fault = new IllegalPermissionFault();
			fault.setFaultString("The permission " + formatPermission(p) + " no role specified.");
			throw fault;
		}

		if (p.getTrustedAuthorityName() == null) {
			p.setTrustedAuthorityName(ALL_TRUST_AUTHORITIES);
		}

		StringBuffer insert = new StringBuffer();
		try {
			insert.append("INSERT INTO " + PERMISSIONS_TABLE + " SET GRID_IDENTITY='" + p.getGridIdentity()
				+ "',ROLE='" + p.getRole().getValue() + "',TRUSTED_AUTHORITY='" + p.getTrustedAuthorityName() + "'");

			db.update(insert.toString());

		} catch (Exception e) {
			this.logger.log(Level.SEVERE, "Unexpected database error incurred in adding the permission "+formatPermission(p)
				+ ", the following statement generated the error: \n"
				+ insert.toString() + "\n", e);
			GTSInternalFault fault = new GTSInternalFault();
			fault.setFaultString("Unexpected error adding the permission " + formatPermission(p)
				+ "!!!");
			throw fault;
		}
	}


	public synchronized boolean doesPermissionExist(Permission p) throws GTSInternalFault {
		String sql = "select count(*) from " + PERMISSIONS_TABLE + " where GRID_IDENTITY='" + p.getGridIdentity()
			+ "' AND ROLE='" + p.getRole().getValue() + "' AND TRUSTED_AUTHORITY='" + p.getTrustedAuthorityName() + "'";
		Connection c = null;
		boolean exists = false;
		try {
			c = db.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					exists = true;
				}
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			String perm = formatPermission(p);
			this.logger.log(Level.SEVERE, "Unexpected database error incurred in determining if the permission " + perm
				+ " exists, the following statement generated the error: \n" + sql + "\n", e);
			GTSInternalFault fault = new GTSInternalFault();
			fault.setFaultString("Unexpected error in determining if the permission " + perm + " exists.");
			throw fault;
		} finally {
			db.releaseConnection(c);
		}
		return exists;
	}


	private String formatPermission(Permission p) {
		return "[" + p.getGridIdentity() + "," + p.getRole().getValue() + "," + p.getTrustedAuthorityName() + "]";
	}


	public synchronized void buildDatabase() throws GTSInternalFault {
		if (!dbBuilt) {
			if (!this.db.tableExists(PERMISSIONS_TABLE)) {
				String trust = "CREATE TABLE " + PERMISSIONS_TABLE + " (" + "GRID_IDENTITY VARCHAR(255) NOT NULL,"
					+ "ROLE VARCHAR(50) NOT NULL," + "TRUSTED_AUTHORITY VARCHAR(255) NOT NULL,"
					+ "INDEX document_index (GRID_IDENTITY));";
				db.update(trust);
			}
			dbBuilt = true;
		}
	}


	public void destroy() throws GTSInternalFault {
		db.update("DROP TABLE IF EXISTS " + PERMISSIONS_TABLE);
		dbBuilt = false;
	}

}
