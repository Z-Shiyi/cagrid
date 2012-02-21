/**
 * KeyTypeOpenEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.globus.ws.trust;

public class KeyTypeOpenEnum  implements java.io.Serializable, org.apache.axis.encoding.SimpleType {
    private java.lang.String _value;
    public KeyTypeOpenEnum() {
    }

    // Simple Types must have a String constructor
    public KeyTypeOpenEnum(java.lang.String _value) {
        this._value = _value;
    }
    public KeyTypeOpenEnum(org.globus.ws.trust.KeyTypeEnum _value) {
        setKeyTypeEnumValue(_value);
    }

    public KeyTypeOpenEnum(org.apache.axis.types.URI _value) {
        setAnyURIValue(_value);
    }

    // Simple Types must have a toString for serializing the value
    public java.lang.String toString() {
        return _value;
    }


    /**
     * Gets the keyTypeEnumValue value for this KeyTypeOpenEnum.
     * 
     * @return keyTypeEnumValue
     */
    public org.globus.ws.trust.KeyTypeEnum getKeyTypeEnumValue() {
        return org.globus.ws.trust.KeyTypeEnum.fromString(_value);
    }


    /**
     * Sets the _value value for this KeyTypeOpenEnum.
     * 
     * @param _value
     */
    public void setKeyTypeEnumValue(org.globus.ws.trust.KeyTypeEnum _value) {
        this._value = _value == null ? null : _value.toString();
    }


    /**
     * Gets the anyURIValue value for this KeyTypeOpenEnum.
     * 
     * @return anyURIValue
     */
    public org.apache.axis.types.URI getAnyURIValue() {
        try {
            return new org.apache.axis.types.URI(_value);
        }
        catch (org.apache.axis.types.URI.MalformedURIException mue) {
            throw new java.lang.RuntimeException(mue.toString());
       }
    }


    /**
     * Sets the _value value for this KeyTypeOpenEnum.
     * 
     * @param _value
     */
    public void setAnyURIValue(org.apache.axis.types.URI _value) {
        this._value = _value == null ? null : _value.toString();
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeyTypeOpenEnum)) return false;
        KeyTypeOpenEnum other = (KeyTypeOpenEnum) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&  this.toString().equals(obj.toString());
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (this._value != null) {
            _hashCode += this._value.hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeyTypeOpenEnum.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/ws/2004/04/trust", "KeyTypeOpenEnum"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyTypeEnumValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KeyTypeEnumValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/ws/2004/04/trust", "KeyTypeEnum"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anyURIValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anyURIValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.SimpleSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.SimpleDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
