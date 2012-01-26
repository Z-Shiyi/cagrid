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
package org.globus.ftp.test;

import org.globus.ftp.GridFTPClient;
import org.globus.ftp.DataChannelAuthentication;
import org.globus.ftp.Session;
import org.globus.ftp.GridFTPSession;
import org.globus.ftp.RetrieveOptions;
import org.globus.ftp.FileRandomIO;
import org.globus.ftp.DataSource;
import org.globus.ftp.DataSink;

import java.io.RandomAccessFile;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
   Test parallel GridFTPClient.get() and put()
 **/
public class GridFTPClient2PartyParallelTest 
    extends GridFTPClient2PartyTest {

    int parallelism = 1;

    //use inherited logger
    //private static Log logger = 
    //LogFactory.getLog(GridFTPClient2PartyParallelTest.class.getName());

    public GridFTPClient2PartyParallelTest(String name) {
	super(name);
    }

    public static void main (String[] args) throws Exception{
	junit.textui.TestRunner.run(suite());	
    }

    public static Test suite ( ) {
	return new TestSuite(GridFTPClient2PartyParallelTest.class);
    }
    

    // overriden methods

    /**
       Test get() and put() with parallelism ranging from 1 to 
       the test property org.globus.ftp.test.gridftp.parallelism
     **/
    public void testGet() {
	//int i = 5;
	title();
	for (int i = 1; i <= TestEnv.parallelism; i++) {
	    this.parallelism = i;
	    super.testGet();
	}
    }

    public void testPut() {
        //int i = 5;                                                                                                          
        title();
        for (int i = 1; i <= TestEnv.parallelism; i++) {
            this.parallelism = i;
            super.testPut();
        }
    }

    protected void title() {
	logger.info("Testing:");
	logger.info("parallel 2 party transfer\n\n");
    }

    protected void testGet(String host,
			   int port,
			   String subject,
			   String remoteDir,
			   String remoteFile,
			   String localDir)
	throws Exception{

	logger.info("with configuration: parallel, passive, image, eblock");
	testGet(host, port, subject,
		remoteDir + "/" + remoteFile, 
		localDir,		
		Session.SERVER_PASSIVE, 
		Session.TYPE_IMAGE, 
		GridFTPSession.MODE_EBLOCK);
	// stream mode not supported with parallelism
    }



    protected void testPut(String host,
			   int port,
			   String subject,
			   String remoteDir,
			   String localDir,
			   String localFile)
	throws Exception{

	logger.info("with configuration: parallel, active, image, eblock");
	testPut(host, port, subject,
		remoteDir, localFile, 
		localDir,		
		Session.SERVER_ACTIVE, 
		Session.TYPE_IMAGE, 
		GridFTPSession.MODE_EBLOCK);
	// stream mode not supported with parallelism
    }

    protected void get(GridFTPClient client, 
		       int localServerMode,
		       int transferType,
		       int transferMode,
		       DataChannelAuthentication dcau,
		       int prot,
		       String fullLocalFile,
		       String fullRemoteFile) 
	throws Exception{
	client.authenticate(null); /* use default cred */
	client.setProtectionBufferSize(16384);
	client.setType(transferType);
	client.setMode(transferMode);
	// adding parallelism
	logger.info("parallelism: " + parallelism);
	client.setOptions(new RetrieveOptions(parallelism));
	client.setDataChannelAuthentication(dcau);
 	client.setDataChannelProtection(prot);

	// in extended block mode, receiving side must be passive
	assertTrue(localServerMode == Session.SERVER_PASSIVE);

	if (TestEnv.localServerPort == TestEnv.UNDEFINED) {
	    client.setLocalPassive(); 
	} else {
	    client.setLocalPassive(TestEnv.localServerPort, 
				   org.globus.ftp.vanilla.FTPServerFacade.DEFAULT_QUEUE);
	}
	client.setActive();

	assertTrue(transferMode == GridFTPSession.MODE_EBLOCK);

	DataSink sink = null;
	sink = new FileRandomIO(new RandomAccessFile(fullLocalFile, 
						     "rw"));
	client.get(fullRemoteFile, sink, null);
    }
    

    protected void put(GridFTPClient client, 
		       int localServerMode,
		       int transferType,
		       int transferMode,
		       DataChannelAuthentication dcau,
		       int prot,
		       String fullLocalFile,
		       String fullRemoteFile) 
	throws Exception{
	client.authenticate(null); /* use default cred */
	client.setProtectionBufferSize(16384);
	client.setType(transferType);
	client.setMode(transferMode);
	// adding parallelism
	logger.info("parallelism: " + parallelism);
	client.setOptions(new RetrieveOptions(parallelism));
 	client.setDataChannelAuthentication(dcau);
 	client.setDataChannelProtection(prot);

	assertTrue(localServerMode == Session.SERVER_ACTIVE);

	client.setPassive();
	client.setLocalActive();

	assertTrue(transferMode == GridFTPSession.MODE_EBLOCK);

	logger.debug("sending file " + fullLocalFile);
	DataSource source = null;
	source = new FileRandomIO(new RandomAccessFile(fullLocalFile, 
						       "r"));
	client.put(fullRemoteFile, source, null);
    }

} 
