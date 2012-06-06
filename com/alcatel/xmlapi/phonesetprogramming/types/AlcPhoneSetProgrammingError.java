/**
 * AlcPhoneSetProgrammingError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcPhoneSetProgrammingError implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AlcPhoneSetProgrammingError(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _ADMINISTRATION_ERROR = "ADMINISTRATION_ERROR";
    public static final java.lang.String _UPK_REFRESH_REQUIRED = "UPK_REFRESH_REQUIRED";
    public static final java.lang.String _PBX_LINK_NOT_CONNECTED = "PBX_LINK_NOT_CONNECTED";
    public static final java.lang.String _UNKNOWN_LINE = "UNKNOWN_LINE";
    public static final java.lang.String _UNKNOWN_ERROR = "UNKNOWN_ERROR";
    public static final java.lang.String _NOT_AUTHORIZED = "NOT_AUTHORIZED";
    public static final java.lang.String _ACAPI_ERROR = "ACAPI_ERROR";
    public static final java.lang.String _INVALID_SECRET_CODE = "INVALID_SECRET_CODE";
    public static final java.lang.String _INVALID_PARAMETER = "INVALID_PARAMETER";
    public static final java.lang.String _OUT_OF_BOUND = "OUT_OF_BOUND";
    public static final java.lang.String _NOT_IMPLEMENTED = "NOT_IMPLEMENTED";
    public static final AlcPhoneSetProgrammingError ADMINISTRATION_ERROR = new AlcPhoneSetProgrammingError(_ADMINISTRATION_ERROR);
    public static final AlcPhoneSetProgrammingError UPK_REFRESH_REQUIRED = new AlcPhoneSetProgrammingError(_UPK_REFRESH_REQUIRED);
    public static final AlcPhoneSetProgrammingError PBX_LINK_NOT_CONNECTED = new AlcPhoneSetProgrammingError(_PBX_LINK_NOT_CONNECTED);
    public static final AlcPhoneSetProgrammingError UNKNOWN_LINE = new AlcPhoneSetProgrammingError(_UNKNOWN_LINE);
    public static final AlcPhoneSetProgrammingError UNKNOWN_ERROR = new AlcPhoneSetProgrammingError(_UNKNOWN_ERROR);
    public static final AlcPhoneSetProgrammingError NOT_AUTHORIZED = new AlcPhoneSetProgrammingError(_NOT_AUTHORIZED);
    public static final AlcPhoneSetProgrammingError ACAPI_ERROR = new AlcPhoneSetProgrammingError(_ACAPI_ERROR);
    public static final AlcPhoneSetProgrammingError INVALID_SECRET_CODE = new AlcPhoneSetProgrammingError(_INVALID_SECRET_CODE);
    public static final AlcPhoneSetProgrammingError INVALID_PARAMETER = new AlcPhoneSetProgrammingError(_INVALID_PARAMETER);
    public static final AlcPhoneSetProgrammingError OUT_OF_BOUND = new AlcPhoneSetProgrammingError(_OUT_OF_BOUND);
    public static final AlcPhoneSetProgrammingError NOT_IMPLEMENTED = new AlcPhoneSetProgrammingError(_NOT_IMPLEMENTED);
    public java.lang.String getValue() { return _value_;}
    public static AlcPhoneSetProgrammingError fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        AlcPhoneSetProgrammingError enum = (AlcPhoneSetProgrammingError)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static AlcPhoneSetProgrammingError fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
