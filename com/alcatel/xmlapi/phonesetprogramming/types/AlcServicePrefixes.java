/**
 * AlcServicePrefixes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcServicePrefixes  implements java.io.Serializable {
    private java.lang.String cancelAutoCallbackPfx;
    private java.lang.String cancelOverflowPfx;
    private java.lang.String cancelWakeUpPfx;
    private java.lang.String cancelForwardPfx;
    private java.lang.String directCallPickUpPfx;
    private java.lang.String doNotDisturbPfx;
    private java.lang.String forwardOnBusyOrNoAnswerPfx;
    private java.lang.String forwardOnNoAnswerPfx;
    private java.lang.String groupCallPickUpPfx;
    private java.lang.String immediateForwardPfx;
    private java.lang.String forwardOnBusyPfx;
    private java.lang.String overflowOnAssociatePfx;
    private java.lang.String padlockPfx;
    private java.lang.String speedDialAssociatePfx;
    private java.lang.String wakeUpPfx;

    public AlcServicePrefixes() {
    }

    public java.lang.String getCancelAutoCallbackPfx() {
        return cancelAutoCallbackPfx;
    }

    public void setCancelAutoCallbackPfx(java.lang.String cancelAutoCallbackPfx) {
        this.cancelAutoCallbackPfx = cancelAutoCallbackPfx;
    }

    public java.lang.String getCancelOverflowPfx() {
        return cancelOverflowPfx;
    }

    public void setCancelOverflowPfx(java.lang.String cancelOverflowPfx) {
        this.cancelOverflowPfx = cancelOverflowPfx;
    }

    public java.lang.String getCancelWakeUpPfx() {
        return cancelWakeUpPfx;
    }

    public void setCancelWakeUpPfx(java.lang.String cancelWakeUpPfx) {
        this.cancelWakeUpPfx = cancelWakeUpPfx;
    }

    public java.lang.String getCancelForwardPfx() {
        return cancelForwardPfx;
    }

    public void setCancelForwardPfx(java.lang.String cancelForwardPfx) {
        this.cancelForwardPfx = cancelForwardPfx;
    }

    public java.lang.String getDirectCallPickUpPfx() {
        return directCallPickUpPfx;
    }

    public void setDirectCallPickUpPfx(java.lang.String directCallPickUpPfx) {
        this.directCallPickUpPfx = directCallPickUpPfx;
    }

    public java.lang.String getDoNotDisturbPfx() {
        return doNotDisturbPfx;
    }

    public void setDoNotDisturbPfx(java.lang.String doNotDisturbPfx) {
        this.doNotDisturbPfx = doNotDisturbPfx;
    }

    public java.lang.String getForwardOnBusyOrNoAnswerPfx() {
        return forwardOnBusyOrNoAnswerPfx;
    }

    public void setForwardOnBusyOrNoAnswerPfx(java.lang.String forwardOnBusyOrNoAnswerPfx) {
        this.forwardOnBusyOrNoAnswerPfx = forwardOnBusyOrNoAnswerPfx;
    }

    public java.lang.String getForwardOnNoAnswerPfx() {
        return forwardOnNoAnswerPfx;
    }

    public void setForwardOnNoAnswerPfx(java.lang.String forwardOnNoAnswerPfx) {
        this.forwardOnNoAnswerPfx = forwardOnNoAnswerPfx;
    }

    public java.lang.String getGroupCallPickUpPfx() {
        return groupCallPickUpPfx;
    }

    public void setGroupCallPickUpPfx(java.lang.String groupCallPickUpPfx) {
        this.groupCallPickUpPfx = groupCallPickUpPfx;
    }

    public java.lang.String getImmediateForwardPfx() {
        return immediateForwardPfx;
    }

    public void setImmediateForwardPfx(java.lang.String immediateForwardPfx) {
        this.immediateForwardPfx = immediateForwardPfx;
    }

    public java.lang.String getForwardOnBusyPfx() {
        return forwardOnBusyPfx;
    }

    public void setForwardOnBusyPfx(java.lang.String forwardOnBusyPfx) {
        this.forwardOnBusyPfx = forwardOnBusyPfx;
    }

    public java.lang.String getOverflowOnAssociatePfx() {
        return overflowOnAssociatePfx;
    }

    public void setOverflowOnAssociatePfx(java.lang.String overflowOnAssociatePfx) {
        this.overflowOnAssociatePfx = overflowOnAssociatePfx;
    }

    public java.lang.String getPadlockPfx() {
        return padlockPfx;
    }

    public void setPadlockPfx(java.lang.String padlockPfx) {
        this.padlockPfx = padlockPfx;
    }

    public java.lang.String getSpeedDialAssociatePfx() {
        return speedDialAssociatePfx;
    }

    public void setSpeedDialAssociatePfx(java.lang.String speedDialAssociatePfx) {
        this.speedDialAssociatePfx = speedDialAssociatePfx;
    }

    public java.lang.String getWakeUpPfx() {
        return wakeUpPfx;
    }

    public void setWakeUpPfx(java.lang.String wakeUpPfx) {
        this.wakeUpPfx = wakeUpPfx;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlcServicePrefixes)) return false;
        AlcServicePrefixes other = (AlcServicePrefixes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cancelAutoCallbackPfx==null && other.getCancelAutoCallbackPfx()==null) || 
             (this.cancelAutoCallbackPfx!=null &&
              this.cancelAutoCallbackPfx.equals(other.getCancelAutoCallbackPfx()))) &&
            ((this.cancelOverflowPfx==null && other.getCancelOverflowPfx()==null) || 
             (this.cancelOverflowPfx!=null &&
              this.cancelOverflowPfx.equals(other.getCancelOverflowPfx()))) &&
            ((this.cancelWakeUpPfx==null && other.getCancelWakeUpPfx()==null) || 
             (this.cancelWakeUpPfx!=null &&
              this.cancelWakeUpPfx.equals(other.getCancelWakeUpPfx()))) &&
            ((this.cancelForwardPfx==null && other.getCancelForwardPfx()==null) || 
             (this.cancelForwardPfx!=null &&
              this.cancelForwardPfx.equals(other.getCancelForwardPfx()))) &&
            ((this.directCallPickUpPfx==null && other.getDirectCallPickUpPfx()==null) || 
             (this.directCallPickUpPfx!=null &&
              this.directCallPickUpPfx.equals(other.getDirectCallPickUpPfx()))) &&
            ((this.doNotDisturbPfx==null && other.getDoNotDisturbPfx()==null) || 
             (this.doNotDisturbPfx!=null &&
              this.doNotDisturbPfx.equals(other.getDoNotDisturbPfx()))) &&
            ((this.forwardOnBusyOrNoAnswerPfx==null && other.getForwardOnBusyOrNoAnswerPfx()==null) || 
             (this.forwardOnBusyOrNoAnswerPfx!=null &&
              this.forwardOnBusyOrNoAnswerPfx.equals(other.getForwardOnBusyOrNoAnswerPfx()))) &&
            ((this.forwardOnNoAnswerPfx==null && other.getForwardOnNoAnswerPfx()==null) || 
             (this.forwardOnNoAnswerPfx!=null &&
              this.forwardOnNoAnswerPfx.equals(other.getForwardOnNoAnswerPfx()))) &&
            ((this.groupCallPickUpPfx==null && other.getGroupCallPickUpPfx()==null) || 
             (this.groupCallPickUpPfx!=null &&
              this.groupCallPickUpPfx.equals(other.getGroupCallPickUpPfx()))) &&
            ((this.immediateForwardPfx==null && other.getImmediateForwardPfx()==null) || 
             (this.immediateForwardPfx!=null &&
              this.immediateForwardPfx.equals(other.getImmediateForwardPfx()))) &&
            ((this.forwardOnBusyPfx==null && other.getForwardOnBusyPfx()==null) || 
             (this.forwardOnBusyPfx!=null &&
              this.forwardOnBusyPfx.equals(other.getForwardOnBusyPfx()))) &&
            ((this.overflowOnAssociatePfx==null && other.getOverflowOnAssociatePfx()==null) || 
             (this.overflowOnAssociatePfx!=null &&
              this.overflowOnAssociatePfx.equals(other.getOverflowOnAssociatePfx()))) &&
            ((this.padlockPfx==null && other.getPadlockPfx()==null) || 
             (this.padlockPfx!=null &&
              this.padlockPfx.equals(other.getPadlockPfx()))) &&
            ((this.speedDialAssociatePfx==null && other.getSpeedDialAssociatePfx()==null) || 
             (this.speedDialAssociatePfx!=null &&
              this.speedDialAssociatePfx.equals(other.getSpeedDialAssociatePfx()))) &&
            ((this.wakeUpPfx==null && other.getWakeUpPfx()==null) || 
             (this.wakeUpPfx!=null &&
              this.wakeUpPfx.equals(other.getWakeUpPfx())));
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
        if (getCancelAutoCallbackPfx() != null) {
            _hashCode += getCancelAutoCallbackPfx().hashCode();
        }
        if (getCancelOverflowPfx() != null) {
            _hashCode += getCancelOverflowPfx().hashCode();
        }
        if (getCancelWakeUpPfx() != null) {
            _hashCode += getCancelWakeUpPfx().hashCode();
        }
        if (getCancelForwardPfx() != null) {
            _hashCode += getCancelForwardPfx().hashCode();
        }
        if (getDirectCallPickUpPfx() != null) {
            _hashCode += getDirectCallPickUpPfx().hashCode();
        }
        if (getDoNotDisturbPfx() != null) {
            _hashCode += getDoNotDisturbPfx().hashCode();
        }
        if (getForwardOnBusyOrNoAnswerPfx() != null) {
            _hashCode += getForwardOnBusyOrNoAnswerPfx().hashCode();
        }
        if (getForwardOnNoAnswerPfx() != null) {
            _hashCode += getForwardOnNoAnswerPfx().hashCode();
        }
        if (getGroupCallPickUpPfx() != null) {
            _hashCode += getGroupCallPickUpPfx().hashCode();
        }
        if (getImmediateForwardPfx() != null) {
            _hashCode += getImmediateForwardPfx().hashCode();
        }
        if (getForwardOnBusyPfx() != null) {
            _hashCode += getForwardOnBusyPfx().hashCode();
        }
        if (getOverflowOnAssociatePfx() != null) {
            _hashCode += getOverflowOnAssociatePfx().hashCode();
        }
        if (getPadlockPfx() != null) {
            _hashCode += getPadlockPfx().hashCode();
        }
        if (getSpeedDialAssociatePfx() != null) {
            _hashCode += getSpeedDialAssociatePfx().hashCode();
        }
        if (getWakeUpPfx() != null) {
            _hashCode += getWakeUpPfx().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlcServicePrefixes.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcServicePrefixes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelAutoCallbackPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelAutoCallbackPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelOverflowPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelOverflowPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelWakeUpPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelWakeUpPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelForwardPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelForwardPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directCallPickUpPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "directCallPickUpPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doNotDisturbPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doNotDisturbPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardOnBusyOrNoAnswerPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardOnBusyOrNoAnswerPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardOnNoAnswerPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardOnNoAnswerPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupCallPickUpPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupCallPickUpPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("immediateForwardPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "immediateForwardPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forwardOnBusyPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forwardOnBusyPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overflowOnAssociatePfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overflowOnAssociatePfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("padlockPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "padlockPfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("speedDialAssociatePfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "speedDialAssociatePfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wakeUpPfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wakeUpPfx"));
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
