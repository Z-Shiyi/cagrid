package org.cagrid.gaards.dorian.ca;

import gov.nih.nci.cagrid.common.FaultUtil;
import gov.nih.nci.cagrid.dorian.common.CommonUtils;

import java.io.ByteArrayInputStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;

import junit.framework.TestCase;

import org.bouncycastle.asn1.x509.X509Name;
import org.cagrid.gaards.dorian.common.Lifetime;
import org.cagrid.gaards.dorian.stubs.types.DorianInternalFault;
import org.cagrid.gaards.dorian.test.Utils;
import org.cagrid.gaards.pki.CertUtil;
import org.cagrid.gaards.pki.KeyUtil;
import org.cagrid.tools.database.Database;
import org.globus.gsi.GlobusCredential;


/**
 * @author <A href="mailto:langella@bmi.osu.edu">Stephen Langella </A>
 * @author <A href="mailto:oster@bmi.osu.edu">Scott Oster </A>
 * @author <A href="mailto:hastings@bmi.osu.edu">Shannon Hastings </A>
 * @version $Id: ArgumentManagerTable.java,v 1.2 2004/10/15 16:35:16 langella
 *          Exp $
 */
@SuppressWarnings("deprecation")
public class TestCertificateAuthority extends TestCase {
    private static final String TABLE = "test_dorian_ca";

    private static LdapName BASE_SUBJECT = null; 

    private Database db;

    private int MAX_COUNT = 8;

    private int TIME_MULTIPLIER = 2;


    public void testWrappingCertificateAuthority() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoCreateAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            if (ca instanceof WrappingCertificateAuthority) {
                ca.clearCertificateAuthority();
                createAndStoreCA(ca);
                WrappingCertificateAuthority wca = (WrappingCertificateAuthority) ca;
                KeyPair pair = KeyUtil.generateRSAKeyPair1024();
                WrappedKey wk = wca.wrap(pair.getPrivate());
                try {
                    KeyUtil.loadPrivateKey(new ByteArrayInputStream(wk.getWrappedKeyData()), null);
                    fail("Should not be able to unwrap key.");
                } catch (Exception e) {

                }
                PrivateKey key = wca.unwrap(wk);
                assertEquals(pair.getPrivate(), key);
            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            assertTrue(false);
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private CertificateAuthority getCertificateAuthority(CertificateAuthorityProperties conf) throws Exception {
        Class<? extends CertificateAuthority> type = Utils.getCA().getClass();
        CertificateAuthorityProperties props = Utils.getCAProperties();
        props.setAutoCreateCA(conf.isAutoCreateCAEnabled());
        props.setAutoRenewCA(conf.isAutoRenewCAEnabled());
        props.setCreationPolicy(conf.getCreationPolicy());
        props.setRenewalLifetime(conf.getRenewalLifetime());

        CertificateAuthority ca = null;
        if (type.equals(DBCertificateAuthority.class)) {
            ca = new DBCertificateAuthority(db, props);
        } else if (type.equals(DBCertificateAuthority.class)) {
            ca = new EracomCertificateAuthority((EracomCertificateAuthorityProperties) props);
        } else {
            throw new Exception("The certificate authority " + type + " is not a valid ca for the test "
                + TestCertificateAuthority.class.getName() + ".");
        }
        ca.clearCertificateAuthority();
        return ca;

    }


    public void testRequestCertificateBadSubject() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoCreateAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            createAndStoreCA(ca);
            GregorianCalendar cal = new GregorianCalendar();
            Date start = cal.getTime();
            cal.add(Calendar.DAY_OF_MONTH, 5);
            Date end = cal.getTime();
            submitCertificateRequest(ca, new LdapName("O=OSU,OU=BMI,OU=MSCL,CN=foo"), start, end);
            assertTrue(false);
        } catch (CertificateAuthorityFault f) {
            if (f.getFaultString().indexOf("Invalid certificate subject") == -1) {
                FaultUtil.printFault(f);
                assertTrue(false);
            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            assertTrue(false);
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testCreateCertificate() {
        CertificateAuthority ca = null;
        try {
            int hours = 12;
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoCreateAutoRenewalLong();
            LdapName user = (LdapName) BASE_SUBJECT.clone();
            user.add("CN=User");
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            Calendar c = new GregorianCalendar();
            Date start = c.getTime();
            c.add(Calendar.HOUR, hours);

            KeyPair pair = KeyUtil.generateRSAKeyPair1024();
            assertNotNull(pair);
            PublicKey proxyPublicKey = pair.getPublic();
            assertNotNull(proxyPublicKey);

            X509Certificate cert = ca.signCertificate(user.toString(), pair.getPublic(), start, c.getTime());
            assertNotNull(cert);
            GlobusCredential cred = new GlobusCredential(pair.getPrivate(), new X509Certificate[]{cert});
            assertNotNull(cred);
            long timeLeft = cred.getTimeLeft();
            assertEquals(user.toString(), CertUtil.getSubjectDN(cert));
            assertEquals(user.toString(), CommonUtils.identityToSubject(cred.getIdentity()));
            assertEquals(cert.getIssuerX500Principal().getName(), CertUtil.getSubjectDN(ca.getCACertificate()));

            long okMax = hours * 60 * 60;
            // Allow some Buffer
            long okMin = okMax - 300;

            assertTrue("must have less time left than the maximum", timeLeft <= okMax);
            assertTrue("must have more time left than the minimum", timeLeft >= okMin);
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        }
    }


    public void testCertificateTimeToGreat() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoCreateAutoRenewalLong();
            LdapName user = (LdapName) BASE_SUBJECT.clone();
            user.add("CN=User");
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            Calendar c = new GregorianCalendar();
            Date start = c.getTime();
            c.add(Calendar.YEAR, 10);
            Date expiration = c.getTime();
            KeyPair pair = KeyUtil.generateRSAKeyPair1024();
            try {
                ca.signCertificate(user.toString(), pair.getPublic(), start, expiration);
                fail("Should not be able to sign a certificate that expires after the CA.");
            } catch (CertificateAuthorityFault f) {

            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        }
    }


    public void testNoCACredentials() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfNoAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            try {
                ca.getCACertificate();
                assertTrue(false);
            } catch (NoCACredentialsFault f) {

            }
            assertEquals(0, db.getUsedConnectionCount());
            try {
                GregorianCalendar cal = new GregorianCalendar();
                Date start = cal.getTime();
                cal.add(Calendar.DAY_OF_MONTH, 5);
                Date end = cal.getTime();
                submitCertificateRequest(ca, BASE_SUBJECT, start, end);
                assertEquals(0, db.getUsedConnectionCount());
                assertTrue(false);
            } catch (NoCACredentialsFault f) {

            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testNoCACredentialsWithAutoRenew() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();

            try {
                ca.getCACertificate();
                fail("Should have failed to get the ca certificate");
            } catch (NoCACredentialsFault f) {

            }
            try {
                GregorianCalendar cal = new GregorianCalendar();
                Date start = cal.getTime();
                cal.add(Calendar.DAY_OF_MONTH, 5);
                Date end = cal.getTime();
                submitCertificateRequest(ca, BASE_SUBJECT, start, end);
                fail("Should have failed to create certificate");
            } catch (NoCACredentialsFault f) {

            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testSetCACredentials() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            // ca.destroyTable();
            createAndStoreCA(ca);
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testAutoCreateCA() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoCreateAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            assertFalse(ca.hasCACredentials());
            X509Certificate cert = ca.getCACertificate();
            assertTrue(ca.hasCACredentials());
            assertEquals(conf.getCreationPolicy().getSubject(), CertUtil.getSubjectDN(cert));
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testRequestCertificate() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            createAndStoreCA(ca);
            GregorianCalendar cal = new GregorianCalendar();
            Date start = cal.getTime();
            cal.add(Calendar.DAY_OF_MONTH, 5);
            Date end = cal.getTime();
            submitCertificateRequest(ca, BASE_SUBJECT, start, end);
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testRequestCertificateBadDate() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            createAndStoreCA(ca);
            GregorianCalendar cal = new GregorianCalendar();
            Date start = cal.getTime();
            cal.add(Calendar.YEAR, 5);
            Date end = cal.getTime();
            submitCertificateRequest(ca, BASE_SUBJECT, start, end);
            fail("Should have failed with bad date");
        } catch (CertificateAuthorityFault f) {
            if (f.getFaultString().indexOf("Certificate expiration date is after the CA certificates expiration date") == -1) {
                FaultUtil.printFault(f);
                fail(f.getMessage());
            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testExpiredCACredentialsWithRenewal() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = this.getDorianCAConfAutoRenewalLong();
            // create the CA instance
            ca = getCertificateAuthority(conf);
            // clean out any existing root cert
            ca.clearCertificateAuthority();
            // give a chance for others to run right before we enter timing
            // sensitive code
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            Thread.yield();
            X509Certificate origRoot = null;

            boolean completed = false;
            int count = 0;
            int seconds = 5000;
            // try to create a new root CA good for a short time (seconds / 1000) - yeah, I know...
            while ((!completed) && (count < MAX_COUNT)) {
                try {
                    origRoot = createAndStoreCAShort(ca, seconds);
                    // yay! it worked!
                    completed = true;
                } catch (Exception f) {
                    System.out.println("" + count + ": Error creating new root CA: " + f.getMessage());
                    // darn, try again and extend the valid period by a factor of 2
                    count = count + 1;
                    seconds = seconds * TIME_MULTIPLIER;
                }
            }
            // sleep until the cert is expired
            Thread.sleep(seconds + 500);

            // ask for a new cert good for five days from the present
            GregorianCalendar cal = new GregorianCalendar();
            Date start = cal.getTime();
            cal.add(Calendar.DAY_OF_MONTH, 5);
            Date end = cal.getTime();
            
            // the ca should notice it's cert is expired and renew it
            assertNotSame(origRoot, ca.getCACertificate());
            
            // and we should be able to get a user cert from it
            submitCertificateRequest(ca, BASE_SUBJECT, start, end);
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testExpiredCACredentialsNoRenewal() {
        CertificateAuthority ca = null;
        try {
            CertificateAuthorityProperties conf = getDorianCAConfNoAutoRenewalLong();
            ca = getCertificateAuthority(conf);
            ca.clearCertificateAuthority();
            // ca.destroyTable();
            // give a chance for others to run right before we enter timing
            // sensitive code
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            Thread.yield();
            boolean completed = false;
            int count = 0;
            int seconds = 5000;
            while ((!completed) && (count < MAX_COUNT)) {
                try {
                    createAndStoreCAShort(ca, seconds);
                    completed = true;
                } catch (Exception f) {
                    count = count + 1;
                    seconds = seconds * TIME_MULTIPLIER;
                }
            }
            Thread.sleep(seconds + 500);
            try {
                ca.getCACertificate();
                fail("Should have failed to get ca certificate");
            } catch (NoCACredentialsFault f) {

            }

            try {
                GregorianCalendar cal = new GregorianCalendar();
                Date start = cal.getTime();
                cal.add(Calendar.DAY_OF_MONTH, 5);
                Date end = cal.getTime();
                submitCertificateRequest(ca, BASE_SUBJECT, start, end);
            } catch (NoCACredentialsFault f) {

            }
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        } finally {
            try {
                ca.clearCertificateAuthority();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private CertificateAuthorityProperties getDorianCAConfAutoRenewalLong() throws DorianInternalFault {
        Lifetime lifetime = new Lifetime();
        lifetime.setYears(5);
        lifetime.setMonths(0);
        lifetime.setDays(0);
        CertificateAuthorityProperties conf = new CertificateAuthorityProperties("password", null, 
            CertificateAuthorityProperties.DEFAULT_SIGNATURE_ALGORITHM, 1024, false, 
            null, true, lifetime);
        return conf;
    }


    private CertificateAuthorityProperties getDorianCAConfAutoCreateAutoRenewalLong() throws DorianInternalFault {
        Lifetime lifetime = new Lifetime();
        lifetime.setYears(5);
        lifetime.setMonths(0);
        lifetime.setDays(0);
        try {
			BASE_SUBJECT.add("CN=Temp Certificate Authority");
		} catch (InvalidNameException e) {
			fail();
		}
        CertificateAuthorityCreationPolicy creation = new CertificateAuthorityCreationPolicy(BASE_SUBJECT.toString(), 2048, lifetime);
        CertificateAuthorityProperties conf = new CertificateAuthorityProperties("password", null, CertificateAuthorityProperties.DEFAULT_SIGNATURE_ALGORITHM,
            1024, true, creation, true, lifetime);
        try {
			BASE_SUBJECT.remove(BASE_SUBJECT.size() - 1);
		} catch (InvalidNameException e) {
			fail();
		}
        return conf;
    }


    private CertificateAuthorityProperties getDorianCAConfNoAutoRenewalLong() throws DorianInternalFault {
        CertificateAuthorityProperties conf = new CertificateAuthorityProperties("password", 1024);
        return conf;
    }


    private void createAndStoreCA(CertificateAuthority ca) throws Exception {
        KeyPair rootPair = KeyUtil.generateRSAKeyPair1024(ca.getCACredentialsProvider());
        assertNotNull(rootPair);
        try {
			BASE_SUBJECT.add("CN=Temp Certificate Authority");
		} catch (InvalidNameException e) {
			fail();
		}
        X509Name rootSubject = new X509Name(BASE_SUBJECT.toString());
        try {
			BASE_SUBJECT.remove(BASE_SUBJECT.size() - 1);
		} catch (InvalidNameException e) {
			fail();
		}

        GregorianCalendar cal = new GregorianCalendar();
        Date start = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date end = cal.getTime();
        X509Certificate root = CertUtil.generateCACertificate(ca.getCACredentialsProvider(), rootSubject, start, end,
            rootPair, ca.getSignatureAlgorithm());
        assertNotNull(root);
        ca.setCACredentials(root, rootPair.getPrivate(), null);
        X509Certificate r = ca.getCACertificate();
        assertNotNull(r);
        assertEquals(r, root);
    }


    private X509Certificate createAndStoreCAShort(CertificateAuthority ca, int seconds) throws Exception {
        // TODO: why is this 2048 when the other one is 1024?
        KeyPair rootPair = KeyUtil.generateRSAKeyPair2048(ca.getCACredentialsProvider());
        assertNotNull(rootPair);
        String rootSub = "CN=Temp Certificate Authority," + BASE_SUBJECT.toString();
        X509Name rootSubject = new X509Name(rootSub);
        GregorianCalendar cal = new GregorianCalendar();
        Date start = cal.getTime();
        cal.add(Calendar.SECOND, (seconds / 1000));
        Date end = cal.getTime();
        X509Certificate root = CertUtil.generateCACertificate(ca.getCACredentialsProvider(), rootSubject, start, end,
            rootPair, ca.getSignatureAlgorithm());
        assertNotNull(root);
        ca.setCACredentials(root, rootPair.getPrivate(), null);
        X509Certificate r = ca.getCACertificate();
        assertNotNull(r);
        if (!r.equals(root)) {
            throw new Exception("The CA certificate obtained was not expected");
        }
        return r;
    }


    private void submitCertificateRequest(CertificateAuthority ca, LdapName prefix, Date start, Date end)
        throws Exception {
    	prefix.add("CN=user");
        KeyPair pair = KeyUtil.generateRSAKeyPair1024();
        X509Certificate cert = ca.signCertificate(prefix.toString(), pair.getPublic(), start, end);
        assertNotNull(cert);
        assertEquals(CertUtil.getSubjectDN(cert), prefix.toString());
        prefix.remove(prefix.size() - 1);
    }


    protected void setUp() throws Exception {
        try {
        	BASE_SUBJECT = new LdapName("OU=BMI,O=Ohio State University");
            db = Utils.getDB();
            assertEquals(0, db.getUsedConnectionCount());
            CredentialsManager.CREDENTIALS_TABLE = TABLE;
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        }
    }


    protected void tearDown() throws Exception {
        try {
            assertEquals(0, db.getUsedConnectionCount());
        } catch (Exception e) {
            FaultUtil.printFault(e);
            fail(e.getMessage());
        }
    }
}
