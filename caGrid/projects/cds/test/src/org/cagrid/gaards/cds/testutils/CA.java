package org.cagrid.gaards.cds.testutils;

import gov.nih.nci.cagrid.gridca.common.CertUtil;
import gov.nih.nci.cagrid.gridca.common.KeyUtil;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.asn1.x509.X509Name;
import org.globus.gsi.GlobusCredential;

/**
 * @author <A href="mailto:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A href="mailto:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A href="mailto:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @version $Id: ArgumentManagerTable.java,v 1.2 2004/10/15 16:35:16 langella
 *          Exp $
 */
public class CA {
	private X509Certificate cert;
	private PrivateKey key;
	public static final Provider PROVIDER = new org.bouncycastle.jce.provider.BouncyCastleProvider();
	public static final String SIGNATURE_ALGORITHM = "MD5WithRSAEncryption";
	public static final String PASSWORD = "password";
	public final static String DEFAULT_CA_DN = "O=Organization ABC,OU=Unit XYZ,CN=Certificate Authority";

	private Map<String, GlobusCredential> creds = new HashMap<String, GlobusCredential>();

	public CA() throws Exception {
		this(DEFAULT_CA_DN);
	}

	public CA(String dn) throws Exception {
		Security.addProvider(PROVIDER);
		Calendar c = new GregorianCalendar();
		Date now = c.getTime();
		c.add(Calendar.YEAR, 5);
		Date expires = c.getTime();
		KeyPair pair = KeyUtil.generateRSAKeyPair1024(PROVIDER.getName());
		this.key = pair.getPrivate();
		cert = CertUtil.generateCACertificate(PROVIDER.getName(), new X509Name(
				dn), now, expires, pair, SIGNATURE_ALGORITHM);
		this.creds = new HashMap<String, GlobusCredential>();

	}

	public X509Certificate getCertificate() {
		return cert;
	}
	
	public GlobusCredential createCredential(String id) throws Exception{
		KeyPair pair = KeyUtil.generateRSAKeyPair(Constants.KEY_LENGTH);
		return createCredential(pair.getPublic(),pair.getPrivate(),id);
	}
	
	public GlobusCredential createCredential(PublicKey publicKey, PrivateKey privateKey, String id) throws Exception{
		String dn = getCertificate().getSubjectDN().getName();
		int index = dn.indexOf("CN=");
		dn = dn.substring(0, index + 3) + id;
		Date now = new Date();
		Date end = getCertificate().getNotAfter();
		X509Certificate cert = CertUtil.generateCertificate(PROVIDER.getName(),
				new X509Name(dn), now, end, publicKey, getCertificate(),
				getPrivateKey(), SIGNATURE_ALGORITHM, null);
		GlobusCredential cred = new GlobusCredential(privateKey,new X509Certificate[]{cert});
		this.creds.put(id, cred);
		return cred;
	}


	public PrivateKey getPrivateKey() {
		return key;
	}
}
