/**
 * AlcPhoneSetProgrammingCapabilities.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcPhoneSetProgrammingCapabilities  implements java.io.Serializable {
    private boolean associateModification;
    private boolean campon;
    private boolean cancelForward;
    private boolean cancelOverflow;
    private boolean clickAndDial;
    private boolean doNotDisturb;
    private boolean forwardOnBusy;
    private boolean forwardOnBusyOrNoAnswer;
    private boolean forwardOnNoAnswer;
    private boolean immediateForward;
    private boolean lock;
    private boolean overflowOnBusy;
    private boolean overflowOnBusyOrNoAnswer;
    private boolean overflowOnNoAnswer;
    private boolean sdk;
    private boolean secretCodeModification;
    private boolean upk;

    public AlcPhoneSetProgrammingCapabilities() {
    }

    public boolean isAssociateModification() {
        return associateModification;
    }

    public void setAssociateModification(boolean associateModification) {
        this.associateModification = associateModification;
    }

    public boolean isCampon() {
        return campon;
    }

    public void setCampon(boolean campon) {
        this.campon = campon;
    }

    public boolean isCancelForward() {
        return cancelForward;
    }

    public void setCancelForward(boolean cancelForward) {
        this.cancelForward = cancelForward;
    }

    public boolean isCancelOverflow() {
        return cancelOverflow;
    }

    public void setCancelOverflow(boolean cancelOverflow) {
        this.cancelOverflow = cancelOverflow;
    }

    public boolean isClickAndDial() {
        return clickAndDial;
    }

    public void setClickAndDial(boolean clickAndDial) {
        this.clickAndDial = clickAndDial;
    }

    public boolean isDoNotDisturb() {
        return doNotDisturb;
    }

    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public boolean isForwardOnBusy() {
        return forwardOnBusy;
    }

    public void setForwardOnBusy(boolean forwardOnBusy) {
        this.forwardOnBusy = forwardOnBusy;
    }

    public boolean isForwardOnBusyOrNoAnswer() {
        return forwardOnBusyOrNoAnswer;
    }

    public void setForwardOnBusyOrNoAnswer(boolean forwardOnBusyOrNoAnswer) {
        this.forwardOnBusyOrNoAnswer = forwardOnBusyOrNoAnswer;
    }

    public boolean isForwardOnNoAnswer() {
        return forwardOnNoAnswer;
    }

    public void setForwardOnNoAnswer(boolean forwardOnNoAnswer) {
        this.forwardOnNoAnswer = forwardOnNoAnswer;
    }

    public boolean isImmediateForward() {
        return immediateForward;
    }

    public void setImmediateForward(boolean immediateForward) {
        this.immediateForward = immediateForward;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isOverflowOnBusy() {
        return overflowOnBusy;
    }

    public void setOverflowOnBusy(boolean overflowOnBusy) {
        this.overflowOnBusy = overflowOnBusy;
    }

    public boolean isOverflowOnBusyOrNoAnswer() {
        return overflowOnBusyOrNoAnswer;
    }

    public void setOverflowOnBusyOrNoAnswer(boolean overflowOnBusyOrNoAnswer) {
        this.overflowOnBusyOrNoAnswer = overflowOnBusyOrNoAnswer;
    }

    public boolean isOverflowOnNoAnswer() {
        return overflowOnNoAnswer;
    }

    public void setOverflowOnNoAnswer(boolean overflowOnNoAnswer) {
        this.overflowOnNoAnswer = overflowOnNoAnswer;
    }

    public boolean isSdk() {
        return sdk;
    }

    public void setSdk(boolean sdk) {
        this.sdk = sdk;
    }

    public boolean isSecretCodeModification() {
        return secretCodeModification;
    }

    public void setSecretCodeModification(boolean secretCodeModification) {
        this.secretCodeModification = secretCodeModification;
    }

    public boolean isUpk() {
        return upk;
    }

    public void setUpk(boolean upk) {
        this.upk = upk;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlcPhoneSetProgrammingCapabilities)) return false;
        AlcPhoneSetProgrammingCapabilities other = (AlcPhoneSetProgrammingCapabilities) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.associateModification == other.isAssociateModification() &&
            this.campon == other.isCampon() &&
            this.cancelForward == other.isCancelForward() &&
            this.cancelOverflow == other.isCancelOverflow() &&
            this.clickAndDial == other.isClickAndDial() &&
            this.doNotDisturb == other.isDoNotDisturb() &&
            this.forwardOnBusy == other.isForwardOnBusy() &&
            this.forwardOnBusyOrNoAnswer == other.isForwardOnBusyOrNoAnswer() &&
            this.forwardOnNoAnswer == other.isForwardOnNoAnswer() &&
            this.immediateForward == other.isImmediateForward() &&
            this.lock == other.isLock() &&
            this.overflowOnBusy == other.isOverflowOnBusy() &&
            this.overflowOnBusyOrNoAnswer == other.isOverflowOnBusyOrNoAnswer() &&
            this.overflowOnNoAnswer == other.isOverflowOnNoAnswer() &&
            this.sdk == other.isSdk() &&
            this.secretCodeModification == other.isSecretCodeModification() &&
            this.upk == other.isUpk();
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
        _hashCode += new Boolean(isAssociateModification()).hashCode();
        _hashCode += new Boolean(isCampon()).hashCode();
        _hashCode += new Boolean(isCancelForward()).hashCode();
        _hashCode += new Boolean(isCancelOverflow()).hashCode();
        _hashCode += new Boolean(isClickAndDial()).hashCode();
        _hashCode += new Boolean(isDoNotDisturb()).hashCode();
        _hashCode += new Boolean(isForwardOnBusy()).hashCode();
        _hashCode += new Boolean(isForwardOnBusyOrNoAnswer()).hashCode();
        _hashCode += new Boolean(isForwardOnNoAnswer()).hashCode();
        _hashCode += new Boolean(isImmediateForward()).hashCode();
        _hashCode += new Boolean(isLock()).hashCode();
        _hashCode += new Boolean(isOverflowOnBusy()).hashCode();
        _hashCode += new Boolean(isOverflowOnBusyOrNoAnswer()).hashCode();
        _hashCode += new Boolean(isOverflowOnNoAnswer()).hashCode();
        _hashCode += new Boolean(isSdk()).hashCode();
        _hashCode += new Boolean(isSecretCodeModification()).hashCode();
        _hashCode += new Boolean(isUpk()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlcPhoneSetProgrammingCapabilities.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingCapabilities"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("associateModification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "associateModification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelForward");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelForward"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelOverflow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelOverflow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clickAndDial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clickAndDial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doNotDisturb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doNotDisturb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardOnBusy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardOnBusy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardOnBusyOrNoAnswer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardOnBusyOrNoAnswer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardOnNoAnswer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardOnNoAnswer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("immediateForward");
        elemField.setXmlName(new javax.xml.namespace.QName("", "immediateForward"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lock");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overflowOnBusy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overflowOnBusy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overflowOnBusyOrNoAnswer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overflowOnBusyOrNoAnswer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overflowOnNoAnswer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overflowOnNoAnswer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sdk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sdk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secretCodeModification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "secretCodeModification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
