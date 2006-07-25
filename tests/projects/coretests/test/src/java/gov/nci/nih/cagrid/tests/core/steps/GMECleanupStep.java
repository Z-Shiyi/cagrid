/*
 * Created on Jun 13, 2006
 */
package gov.nci.nih.cagrid.tests.core.steps;

/**
 * This step cleans up a GME deployment by dropping the databases globusgme_gme_registry,
 * globusgme_gme_schema_cache, and globusgme_gme_schema_store.
 * @author Patrick McConnell
 */
public class GMECleanupStep
	extends AbstractDbCleanupStep
{
	public GMECleanupStep() 
	{
		super();
	}
	
	public GMECleanupStep(String dbUrl, String user, String password) 
	{
		super(dbUrl, user, password);		
	}
	
	public void runStep() 
		throws Throwable
	{
		super.dropDatabases(new String[] { 
			"globusgme_gme_registry", 
			"globusgme_gme_schema_cache", 
			"globusgme_gme_schema_store"
		});
	}
	
	public static void main(String[] args)
		throws Throwable
	{
		new GMECleanupStep().runStep(); 
	}
}
