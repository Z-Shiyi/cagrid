/**
 * SecureConversationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.globus.wsrf.security.impl.secconv;

public interface SecureConversationService extends javax.xml.rpc.Service {
    public java.lang.String getSecureConversationPortAddress();

    public org.globus.wsrf.security.impl.secconv.SecureConversation getSecureConversationPort() throws javax.xml.rpc.ServiceException;

    public org.globus.wsrf.security.impl.secconv.SecureConversation getSecureConversationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
