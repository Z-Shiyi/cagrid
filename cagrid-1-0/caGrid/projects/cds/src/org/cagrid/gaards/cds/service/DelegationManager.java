package org.cagrid.gaards.cds.service;

import org.cagrid.gaards.cds.common.CertificateChain;
import org.cagrid.gaards.cds.common.DelegationIdentifier;
import org.cagrid.gaards.cds.common.DelegationRecord;
import org.cagrid.gaards.cds.common.DelegationRecordFilter;
import org.cagrid.gaards.cds.common.DelegationRequest;
import org.cagrid.gaards.cds.common.DelegationSigningRequest;
import org.cagrid.gaards.cds.common.DelegationSigningResponse;
import org.cagrid.gaards.cds.common.PublicKey;
import org.cagrid.gaards.cds.stubs.types.CDSInternalFault;
import org.cagrid.gaards.cds.stubs.types.DelegationFault;
import org.cagrid.gaards.cds.stubs.types.InvalidPolicyFault;
import org.cagrid.gaards.cds.stubs.types.PermissionDeniedFault;

public class DelegationManager {

	private DelegatedCredentialManager dcm;
	private PropertyManager properties;

	public DelegationManager(PropertyManager properties,
			DelegatedCredentialManager dcm) throws CDSInternalFault {
		this.dcm = dcm;
		this.properties = properties;

	}

	public DelegationSigningRequest initiateDelegation(String callerIdentity,
			DelegationRequest req) throws CDSInternalFault, InvalidPolicyFault,
			DelegationFault, PermissionDeniedFault {
		return this.dcm.initiateDelegation(callerIdentity, req);
	}

	public DelegationIdentifier approveDelegation(String callerIdentity,
			DelegationSigningResponse res) throws CDSInternalFault,
			DelegationFault, PermissionDeniedFault {
		return this.dcm.approveDelegation(callerIdentity, res);
	}

	public CertificateChain getDelegatedCredential(String gridIdentity,
			DelegationIdentifier id, PublicKey publicKey)
			throws CDSInternalFault, DelegationFault, PermissionDeniedFault {
		return this.dcm.getDelegatedCredential(gridIdentity, id, publicKey);
	}

	public DelegationRecord[] findMyDelegatedCredentials(String callerIdentity,
			DelegationRecordFilter f) throws CDSInternalFault,
			PermissionDeniedFault {
		if (gov.nih.nci.cagrid.common.Utils.clean(callerIdentity) == null) {
			PermissionDeniedFault fault = new PermissionDeniedFault();
			fault
					.setFaultString("No credentials provided, please authenticate.");
			throw fault;
		}
		if (f == null) {
			f = new DelegationRecordFilter();
		}
		f.setGridIdentity(callerIdentity);
		return this.dcm.findDelegatedCredentials(f);
	}

	public void clear() throws CDSInternalFault {
		dcm.clearDatabase();
		properties.clearAllProperties();
	}

	public DelegatedCredentialManager getDelegatedCredentialManager() {
		return this.dcm;
	}
}
