/**
 * AlcStaticState.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcStaticState  implements java.io.Serializable {
    private boolean campOnActivated;
    private boolean doNotDisturbActivated;
    private com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState forwardState;
    private boolean locked;
    private com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType overflowType;
    private java.lang.String associate;

    public AlcStaticState() {
    }

    public boolean isCampOnActivated() {
        return campOnActivated;
    }

    public void setCampOnActivated(boolean campOnActivated) {
        this.campOnActivated = campOnActivated;
    }

    public boolean isDoNotDisturbActivated() {
        return doNotDisturbActivated;
    }

    public void setDoNotDisturbActivated(boolean doNotDisturbActivated) {
        this.doNotDisturbActivated = doNotDisturbActivated;
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState getForwardState() {
        return forwardState;
    }

    public void setForwardState(com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState forwardState) {
        this.forwardState = forwardState;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType getOverflowType() {
        return overflowType;
    }

    public void setOverflowType(com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType overflowType) {
        this.overflowType = overflowType;
    }

    public java.lang.String getAssociate() {
        return associate;
    }

    public void setAssociate(java.lang.String associate) {
        this.associate = associate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlcStaticState)) return false;
        AlcStaticState other = (AlcStaticState) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.campOnActivated == other.isCampOnActivated() &&
            this.doNotDisturbActivated == other.isDoNotDisturbActivated() &&
            ((this.forwardState==null && other.getForwardState()==null) || 
             (this.forwardState!=null &&
              this.forwardState.equals(other.getForwardState()))) &&
            this.locked == other.isLocked() &&
            ((this.overflowType==null && other.getOverflowType()==null) || 
             (this.overflowType!=null &&
              this.overflowType.equals(other.getOverflowType()))) &&
            ((this.associate==null && other.getAssociate()==null) || 
             (this.associate!=null &&
              this.associate.equals(other.getAssociate())));
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
        _hashCode += new Boolean(isCampOnActivated()).hashCode();
        _hashCode += new Boolean(isDoNotDisturbActivated()).hashCode();
        if (getForwardState() != null) {
            _hashCode += getForwardState().hashCode();
        }
        _hashCode += new Boolean(isLocked()).hashCode();
        if (getOverflowType() != null) {
            _hashCode += getOverflowType().hashCode();
        }
        if (getAssociate() != null) {
            _hashCode += getAssociate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlcStaticState.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcStaticState"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campOnActivated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campOnActivated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doNotDisturbActivated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doNotDisturbActivated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcForwardState"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locked");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overflowType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overflowType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcOverflowType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("associate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "associate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
