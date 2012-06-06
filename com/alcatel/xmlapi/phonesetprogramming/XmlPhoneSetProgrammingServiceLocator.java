/**
 * XmlPhoneSetProgrammingServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming;

public class XmlPhoneSetProgrammingServiceLocator extends org.apache.axis.client.Service implements com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgrammingService {

    // Use to get a proxy class for XmlPhoneSetProgramming
    private final java.lang.String XmlPhoneSetProgramming_address = "http://localhost:8080/api/services/2.2/XMLPhoneSetProgramming";

    public java.lang.String getXmlPhoneSetProgrammingAddress() {
        return XmlPhoneSetProgramming_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String XmlPhoneSetProgrammingWSDDServiceName = "XmlPhoneSetProgramming";

    public java.lang.String getXmlPhoneSetProgrammingWSDDServiceName() {
        return XmlPhoneSetProgrammingWSDDServiceName;
    }

    public void setXmlPhoneSetProgrammingWSDDServiceName(java.lang.String name) {
        XmlPhoneSetProgrammingWSDDServiceName = name;
    }

    public com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgramming getXmlPhoneSetProgramming() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(XmlPhoneSetProgramming_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getXmlPhoneSetProgramming(endpoint);
    }

    public com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgramming getXmlPhoneSetProgramming(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgrammingSoapBindingStub _stub = new com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgrammingSoapBindingStub(portAddress, this);
            _stub.setPortName(getXmlPhoneSetProgrammingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgramming.class.isAssignableFrom(serviceEndpointInterface)) {
                com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgrammingSoapBindingStub _stub = new com.alcatel.xmlapi.phonesetprogramming.XmlPhoneSetProgrammingSoapBindingStub(new java.net.URL(XmlPhoneSetProgramming_address), this);
                _stub.setPortName(getXmlPhoneSetProgrammingWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("XmlPhoneSetProgramming".equals(inputPortName)) {
            return getXmlPhoneSetProgramming();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xmlapi.alcatel.com/phonesetprogramming", "XmlPhoneSetProgrammingService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("XmlPhoneSetProgramming"));
        }
        return ports.iterator();
    }

}
