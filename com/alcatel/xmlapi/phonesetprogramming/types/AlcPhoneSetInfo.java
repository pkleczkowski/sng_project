/**
 * AlcPhoneSetInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcPhoneSetInfo  implements java.io.Serializable {
    private java.lang.String language;
    private java.lang.String phoneSetType;
    private com.alcatel.xmlapi.phonesetprogramming.types.AlcAddOnType[] addOnInfo;

    public AlcPhoneSetInfo() {
    }

    public java.lang.String getLanguage() {
        return language;
    }

    public void setLanguage(java.lang.String language) {
        this.language = language;
    }

    public java.lang.String getPhoneSetType() {
        return phoneSetType;
    }

    public void setPhoneSetType(java.lang.String phoneSetType) {
        this.phoneSetType = phoneSetType;
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcAddOnType[] getAddOnInfo() {
        return addOnInfo;
    }

    public void setAddOnInfo(com.alcatel.xmlapi.phonesetprogramming.types.AlcAddOnType[] addOnInfo) {
        this.addOnInfo = addOnInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlcPhoneSetInfo)) return false;
        AlcPhoneSetInfo other = (AlcPhoneSetInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.phoneSetType==null && other.getPhoneSetType()==null) || 
             (this.phoneSetType!=null &&
              this.phoneSetType.equals(other.getPhoneSetType()))) &&
            ((this.addOnInfo==null && other.getAddOnInfo()==null) || 
             (this.addOnInfo!=null &&
              java.util.Arrays.equals(this.addOnInfo, other.getAddOnInfo())));
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
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getPhoneSetType() != null) {
            _hashCode += getPhoneSetType().hashCode();
        }
        if (getAddOnInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAddOnInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAddOnInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlcPhoneSetInfo.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("", "language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneSetType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneSetType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addOnInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addOnInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcAddOnType"));
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
          new  org.apache.axis.encoding.ser.BeanSerializer(
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
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
