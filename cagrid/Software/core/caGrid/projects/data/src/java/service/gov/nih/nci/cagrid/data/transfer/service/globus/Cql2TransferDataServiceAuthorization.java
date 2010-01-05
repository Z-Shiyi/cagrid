package gov.nih.nci.cagrid.data.transfer.service.globus;


import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class will have a authorize<methodName> method for each method on this grid service.
 * The method is responsible for making any authorization callouts required to satisfy the 
 * authorization requirements placed on each method call.  Each method will either simple return
 * upon a successful authorization or will throw an exception upon a failed authorization.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public class Cql2TransferDataServiceAuthorization{
	
	
	public Cql2TransferDataServiceAuthorization() {
	}
	
	public static String getCallerIdentity() {
		String caller = org.globus.wsrf.security.SecurityManager.getManager().getCaller();
		if ((caller == null) || (caller.equals("<anonymous>"))) {
			return null;
		} else {
			return caller;
		}
	}
	
					
	public static void authorizeExecuteTransferQuery() throws RemoteException {
		
		
	}
	
	
}
