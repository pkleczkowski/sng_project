/**
 * AlcServiceError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.common;

public class AlcServiceError implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AlcServiceError(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _BAD_DATA_ACCESS_CONNECTION = "BAD_DATA_ACCESS_CONNECTION";
    public static final java.lang.String _BAD_FRAMEWORK_SESSION_IDENTIFIER = "BAD_FRAMEWORK_SESSION_IDENTIFIER";
    public static final java.lang.String _INVALID_OPERATION = "INVALID_OPERATION";
    public static final java.lang.String _INVALID_SVC_SESSION_ID = "INVALID_SVC_SESSION_ID";
    public static final java.lang.String _LICENSE_REQUIRED = "LICENSE_REQUIRED";
    public static final java.lang.String _LOGIN_REQUIRED = "LOGIN_REQUIRED";
    public static final java.lang.String _SERVICE_UNAVAILABLE = "SERVICE_UNAVAILABLE";
    public static final java.lang.String _SOAP_ACTION_REQUIRED = "SOAP_ACTION_REQUIRED";
    public static final java.lang.String _BAD_PARAMETER_VALUE = "BAD_PARAMETER_VALUE";
    public static final java.lang.String _UNAUTHORIZED = "UNAUTHORIZED";
    public static final AlcServiceError BAD_DATA_ACCESS_CONNECTION = new AlcServiceError(_BAD_DATA_ACCESS_CONNECTION);
    public static final AlcServiceError BAD_FRAMEWORK_SESSION_IDENTIFIER = new AlcServiceError(_BAD_FRAMEWORK_SESSION_IDENTIFIER);
    public static final AlcServiceError INVALID_OPERATION = new AlcServiceError(_INVALID_OPERATION);
    public static final AlcServiceError INVALID_SVC_SESSION_ID = new AlcServiceError(_INVALID_SVC_SESSION_ID);
    public static final AlcServiceError LICENSE_REQUIRED = new AlcServiceError(_LICENSE_REQUIRED);
    public static final AlcServiceError LOGIN_REQUIRED = new AlcServiceError(_LOGIN_REQUIRED);
    public static final AlcServiceError SERVICE_UNAVAILABLE = new AlcServiceError(_SERVICE_UNAVAILABLE);
    public static final AlcServiceError SOAP_ACTION_REQUIRED = new AlcServiceError(_SOAP_ACTION_REQUIRED);
    public static final AlcServiceError BAD_PARAMETER_VALUE = new AlcServiceError(_BAD_PARAMETER_VALUE);
    public static final AlcServiceError UNAUTHORIZED = new AlcServiceError(_UNAUTHORIZED);
    public java.lang.String getValue() { return _value_;}
    public static AlcServiceError fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        AlcServiceError enum = (AlcServiceError)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static AlcServiceError fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
