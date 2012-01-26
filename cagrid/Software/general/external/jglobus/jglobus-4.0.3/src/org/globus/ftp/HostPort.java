/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package org.globus.ftp;

import java.util.StringTokenizer;
import java.net.InetAddress;

/**
 * Utility class for parsing and converting host-port information from PASV 
 * and PORT ftp commands.
 */
public class HostPort {

    private int [] datainfo;
    
    protected HostPort() {
    }

    /**
     * Parses host-port from passive mode reply message.
     * Note that the argument is not the whole message, but
     * only the content of the brackets:
     * h1,h2,h3,h4,p1,p2
     *
     * @param passiveReplyMessage reply message for the PASV command
     */
    public HostPort(String passiveReplyMessage) {
	datainfo  = new int[6];
	int i     = 0;
	StringTokenizer tokens = new StringTokenizer(passiveReplyMessage, ",");
	while(tokens.hasMoreTokens()) {
	    datainfo[i] = Integer.parseInt( tokens.nextToken().trim() );
	    i++;
	}
    }
 
    /**
     * Creates the HostPort object from specified ip address
     * and port number.
     *
     * @param addr ip address
     * @param port port number
     */
    public HostPort(InetAddress addr, int port) {
	this(addr.getHostAddress(), port);
    }

    /**
     * Creates the HostPort object from specified ip address
     * and port number. 
     * @param ipAddress ip address
     * @param port port number
     */
    public HostPort(String ipAddress, int port) {
	datainfo  = new int[6];
	int i     = 0;
	StringTokenizer tokens = new StringTokenizer(ipAddress, ".");
	while(tokens.hasMoreTokens()) {
	    datainfo[i] = Integer.parseInt( (String)tokens.nextToken() );
	    i++;
	}
	
	if (i != 4) {
	    throw new IllegalArgumentException("Invalid ip address: " + 
					       ipAddress);
	}
	
	datainfo[4] = port/256;
	datainfo[5] = port - datainfo[4]*256;
    }
    
    /**
     * Returns the port number
     *
     * @return port number
     */
    public int getPort() {
	return datainfo[4]*256 + datainfo[5];
    }
  
    /**
     * Returns the ip address in the form "h1.h2.h3.h4"
     *
     * @return ip address 
     */
    public String getHost() {
	return datainfo[0] + "." + datainfo[1] + "." +
	    datainfo[2] + "." + datainfo[3];
    }
  
    /**
     * Returns the host-port information in the
     * format used by PORT command. 
     * (h1,h2,h3,h4,p1,p2)
     *
     * @return host-port information in PORT command
     *         representation.
     */
    public String toFtpCmdArgument() {
	StringBuffer msg = new StringBuffer();
	for (int i=0;i<datainfo.length;i++) {
	    msg.append( String.valueOf(datainfo[i]) );
	    if (i+1 != datainfo.length) msg.append( "," );
	}
	return msg.toString();
    }
    
}
