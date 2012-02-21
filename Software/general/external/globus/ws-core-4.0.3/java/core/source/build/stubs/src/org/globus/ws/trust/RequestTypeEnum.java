/**
 * RequestTypeEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.globus.ws.trust;

public class RequestTypeEnum implements java.io.Serializable {
    private org.apache.axis.types.URI _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected RequestTypeEnum(org.apache.axis.types.URI value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final org.apache.axis.types.URI _value1;
    static {
    	try {
            _value1 = new org.apache.axis.types.URI("http://schemas.xmlsoap.org/ws/2004/04/security/trust/Issue");
        }
        catch (org.apache.axis.types.URI.MalformedURIException mue) {
            throw new java.lang.RuntimeException(mue.toString());
        }
    }

    public static final org.apache.axis.types.URI _value2;
    static {
    	try {
            _value2 = new org.apache.axis.types.URI("http://schemas.xmlsoap.org/ws/2004/04/security/trust/Renew");
        }
        catch (org.apache.axis.types.URI.MalformedURIException mue) {
            throw new java.lang.RuntimeException(mue.toString());
        }
    }

    public static final org.apache.axis.types.URI _value3;
    static {
    	try {
            _value3 = new org.apache.axis.types.URI("http://schemas.xmlsoap.org/ws/2004/04/security/trust/Validate");
        }
        catch (org.apache.axis.types.URI.MalformedURIException mue) {
            throw new java.lang.RuntimeException(mue.toString());
        }
    }

    public static final RequestTypeEnum value1 = new RequestTypeEnum(_value1);
    public static final RequestTypeEnum value2 = new RequestTypeEnum(_value2);
    public static final RequestTypeEnum value3 = new RequestTypeEnum(_value3);
    public org.apache.axis.types.URI getValue() { return _value_;}
    public static RequestTypeEnum fromValue(org.apache.axis.types.URI value)
          throws java.lang.IllegalArgumentException {
        RequestTypeEnum enumeration = (RequestTypeEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static RequestTypeEnum fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        try {
            return fromValue(new org.apache.axis.types.URI(value));
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_.toString();}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestTypeEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/ws/2004/04/trust", "RequestTypeEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
