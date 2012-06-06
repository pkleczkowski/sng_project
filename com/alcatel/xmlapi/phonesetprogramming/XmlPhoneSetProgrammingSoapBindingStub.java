/**
 * XmlPhoneSetProgrammingSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming;

public class XmlPhoneSetProgrammingSoapBindingStub extends org.apache.axis.client.Stub implements com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgramming {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[19];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setCurrentLine");
        oper.addParameter(new javax.xml.namespace.QName("", "pLineNumber"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPhoneSetProgrammingCapabilities");
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingCapabilities"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPhoneSetProgrammingCapabilitiesReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPhoneSetInfo");
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetInfo"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPhoneSetInfoReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getServicePrefixes");
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcServicePrefixes"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getServicePrefixesReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getStaticState");
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcStaticState"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getStaticStateReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setLockState");
        oper.addParameter(new javax.xml.namespace.QName("", "pLocked"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setDoNotDisturbState");
        oper.addParameter(new javax.xml.namespace.QName("", "pDoNotDisturbActivated"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setCampOnState");
        oper.addParameter(new javax.xml.namespace.QName("", "pCampOnActivated"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setForwardState");
        oper.addParameter(new javax.xml.namespace.QName("", "pForwardState"), new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcForwardState"), com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setOverflowType");
        oper.addParameter(new javax.xml.namespace.QName("", "pOverflowType"), new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcOverflowType"), com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[9] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setAssociate");
        oper.addParameter(new javax.xml.namespace.QName("", "pAssociatedNumber"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSdkList");
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "ArrayOf_tns1_AlcSpeedDialingKey"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSdkListReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSdk");
        oper.addParameter(new javax.xml.namespace.QName("", "pPosition"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcSpeedDialingKey"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSdkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setSdk");
        oper.addParameter(new javax.xml.namespace.QName("", "pSdk"), new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcSpeedDialingKey"), com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUpkList");
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "ArrayOf_tns1_AlcUserProgrammableKey"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUpkListReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUpk");
        oper.addParameter(new javax.xml.namespace.QName("", "pPosition"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcUserProgrammableKey"));
        oper.setReturnClass(com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUpkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setUpk");
        oper.addParameter(new javax.xml.namespace.QName("", "pUpk"), new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcUserProgrammableKey"), com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("changeSecretCode");
        oper.addParameter(new javax.xml.namespace.QName("", "pOldSecretCode"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "pNewSecretCode"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("clickAndDial");
        oper.addParameter(new javax.xml.namespace.QName("", "pCalledNumber"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "pspFault"),
                      "com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "fault"),
                      "com.alcatel.xmlapi.common.AlcServiceException",
                      new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException"), 
                      true
                     ));
        _operations[18] = oper;

    }

    public XmlPhoneSetProgrammingSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public XmlPhoneSetProgrammingSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public XmlPhoneSetProgrammingSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcServicePrefixes");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingCapabilities");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcAddOnType");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcAddOnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceError");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.common.AlcServiceError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcStaticState");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcUpkType");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcUpkType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcUserProgrammableKey");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "ArrayOf_tns1_AlcSpeedDialingKey");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingError");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "ArrayOf_tns1_AlcUserProgrammableKey");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetProgrammingException");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcForwardType");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcForwardTargetType");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardTargetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/common", "AlcServiceException");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.common.AlcServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcSpeedDialingKey");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcOverflowType");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "ArrayOf_tns1_AlcAddOnType");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcAddOnType[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcPhoneSetInfo");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming/types", "AlcForwardState");
            cachedSerQNames.add(qName);
            cls = com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public void setCurrentLine(java.lang.String pLineNumber) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setCurrentLine");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setCurrentLine"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pLineNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities getPhoneSetProgrammingCapabilities() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getPhoneSetProgrammingCapabilities");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getPhoneSetProgrammingCapabilities"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities.class);
            }
        }
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo getPhoneSetInfo() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getPhoneSetInfo");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getPhoneSetInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo.class);
            }
        }
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes getServicePrefixes() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getServicePrefixes");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getServicePrefixes"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes.class);
            }
        }
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState getStaticState() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getStaticState");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getStaticState"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState.class);
            }
        }
    }

    public void setLockState(boolean pLocked) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setLockState");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setLockState"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(pLocked)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void setDoNotDisturbState(boolean pDoNotDisturbActivated) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setDoNotDisturbState");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setDoNotDisturbState"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(pDoNotDisturbActivated)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void setCampOnState(boolean pCampOnActivated) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setCampOnState");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setCampOnState"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(pCampOnActivated)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void setForwardState(com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState pForwardState) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setForwardState");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setForwardState"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pForwardState});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void setOverflowType(com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType pOverflowType) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setOverflowType");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setOverflowType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pOverflowType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void setAssociate(java.lang.String pAssociatedNumber) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setAssociate");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setAssociate"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pAssociatedNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[] getSdkList() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getSdkList");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getSdkList"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[].class);
            }
        }
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey getSdk(int pPosition) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getSdk");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getSdk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(pPosition)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey.class);
            }
        }
    }

    public void setSdk(com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey pSdk) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setSdk");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setSdk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pSdk});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[] getUpkList() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getUpkList");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getUpkList"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[].class);
            }
        }
    }

    public com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey getUpk(int pPosition) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("getUpk");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "getUpk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(pPosition)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey) org.apache.axis.utils.JavaUtils.convert(_resp, com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey.class);
            }
        }
    }

    public void setUpk(com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey pUpk) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("setUpk");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "setUpk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pUpk});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void changeSecretCode(java.lang.String pOldSecretCode, java.lang.String pNewSecretCode) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("changeSecretCode");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "changeSecretCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pOldSecretCode, pNewSecretCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void clickAndDial(java.lang.String pCalledNumber) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("clickAndDial");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "clickAndDial"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pCalledNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

}
