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
package org.globus.wsrf.encoding;

import javax.xml.namespace.QName;

import org.apache.axis.Constants;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.types.URI;
import org.globus.wsrf.WSRFConstants;
import org.oasis.wsrf.properties.QueryExpressionType;

public class QueryExpressionSerializer extends DialectDependentSerializer {

    private static final QName ATTR = 
        new QName(isNSQualified() ? QueryExpressionType.NAMESPACE : "", 
                  QueryExpressionType.DIALECT_ATTR);
    
    private static final URI XPATH_1_DIALECT_URI;
    
    static {
        try {
            XPATH_1_DIALECT_URI = new URI(WSRFConstants.XPATH_1_DIALECT);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public QueryExpressionSerializer() {
        this.attributeName = ATTR;
        this.typeMappingName = "QueryExpressionDialect";
        registerSerializerFactory(XPATH_1_DIALECT_URI,
                                  new SimpleSerializerFactory(
                                         String.class,
                                         Constants.XSD_STRING));
    }

}
