package org.cagrid.identifiers.namingauthority;

import java.net.URI;

import org.cagrid.identifiers.namingauthority.domain.IdentifierValues;
import org.cagrid.identifiers.namingauthority.test.NamingAuthorityTestCaseBase;


public class NamingAuthorityTestCase extends NamingAuthorityTestCaseBase {

	
	public void testInvalidIdentifier() {
		
		//
		// Identifier is not local to prefix hosted by naming authority
		//
        URI prefix = URI.create("http://na.cagrid.org/foo/");

        try {
            this.NamingAuthority.resolveIdentifier(prefix);
        } catch (InvalidIdentifierException e) {
            // expected
        } catch (NamingAuthorityConfigurationException e) {
        	e.printStackTrace();
            fail("test configuration error");
        }
        
        //
        // Identifier does not exist
        //
        prefix = URI.create(this.NamingAuthority.getConfiguration().getPrefix() 
        		+ "BADIDENTIFIER");

        try {
            this.NamingAuthority.resolveIdentifier(prefix);
        } catch (InvalidIdentifierException e) {
            // expected
        } catch (NamingAuthorityConfigurationException e) {
        	e.printStackTrace();
            fail("test configuration error");
        }
	}
	
	//
	// Can create and resolve identifier that has no IdentifierValues
	//
	public void testNullIdentifierValues() {
        assertResolvedValues(null);
    }
	
	// Create identifier with multiple values per key
	public void testMultipleIdentifierValues() {
		IdentifierValues values = new IdentifierValues();
		values.add("URL", "http://na.cagrid.org/foo");
		values.add("URL", "http://na.cagrid.org/bar");
		values.add("CODE", "007");
		
		assertResolvedValues(values);
	}

    private void assertResolvedValues(IdentifierValues values) {
        URI id = null;
        try {
            id = this.NamingAuthority.createIdentifier(values);
        } catch (NamingAuthorityConfigurationException e) {
            e.printStackTrace();
            fail("test configuration error");

        } catch (InvalidIdentifierValuesException e) {
            fail("Unexpected failure on creation:" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("test configuration error");
        }

        IdentifierValues resolvedValues = null;

        try {
            resolvedValues = this.NamingAuthority.resolveIdentifier(id);
        } catch (NamingAuthorityConfigurationException e) {
            e.printStackTrace();
            fail("test configuration error");
        } catch (InvalidIdentifierException e) {
            fail("Unexpected failure on resolution:" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("test configuration error");
        }
        assertEquals(values, resolvedValues);
    }
}
