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
package org.globus.wsrf.client;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.Stub;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.globus.wsrf.WSNConstants;
import org.globus.wsrf.utils.AnyHelper;
import org.globus.wsrf.utils.FaultHelper;
import org.oasis.wsn.NotificationProducer;
import org.oasis.wsn.TopicExpressionType;
import org.oasis.wsn.WSBaseNotificationServiceAddressingLocator;

public class GetCurrentMessage extends BaseClient {

    public static void main(String[] args) {
        GetCurrentMessage client = new GetCurrentMessage();
        client.setCustomUsage("topic");

        QName topicQName = null;

        try {
            CommandLine line = client.parse(args);
            
            List options = line.getArgList();
            if (options == null || options.isEmpty()) {
                throw new ParseException("topic name expected");
            }
            topicQName = QName.valueOf((String)options.get(0));
        } catch(ParseException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(COMMAND_LINE_ERROR);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(COMMAND_LINE_ERROR);
        }

        WSBaseNotificationServiceAddressingLocator locator =
            new WSBaseNotificationServiceAddressingLocator();

        try {
            NotificationProducer port = 
                locator.getNotificationProducerPort(client.getEPR());
	    client.setOptions((Stub)port);

            TopicExpressionType topicExpression = new TopicExpressionType();
            topicExpression.setDialect(WSNConstants.SIMPLE_TOPIC_DIALECT);
            topicExpression.setValue(topicQName);

            org.oasis.wsn.GetCurrentMessage request = 
                new org.oasis.wsn.GetCurrentMessage();
            request.setTopic(topicExpression);
            
            org.oasis.wsn.GetCurrentMessageResponse response = 
                port.getCurrentMessage(request);

            System.out.println(AnyHelper.toSingleString(response));
        } catch(Exception e) {
            if (client.isDebugMode()) {
                FaultHelper.printStackTrace(e);
            } else {
                System.err.println("Error: " + FaultHelper.getMessage(e));
            }
            System.exit(APPLICATION_ERROR);
        }
    }
    
}
