/**
 * AlcForwardType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcForwardType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AlcForwardType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NO_FORWARD = "NO_FORWARD";
    public static final java.lang.String _IMMEDIATE = "IMMEDIATE";
    public static final java.lang.String _ON_BUSY = "ON_BUSY";
    public static final java.lang.String _ON_NO_ANSWER = "ON_NO_ANSWER";
    public static final java.lang.String _ON_BUSY_OR_NO_ANSWER = "ON_BUSY_OR_NO_ANSWER";
    public static final AlcForwardType NO_FORWARD = new AlcForwardType(_NO_FORWARD);
    public static final AlcForwardType IMMEDIATE = new AlcForwardType(_IMMEDIATE);
    public static final AlcForwardType ON_BUSY = new AlcForwardType(_ON_BUSY);
    public static final AlcForwardType ON_NO_ANSWER = new AlcForwardType(_ON_NO_ANSWER);
    public static final AlcForwardType ON_BUSY_OR_NO_ANSWER = new AlcForwardType(_ON_BUSY_OR_NO_ANSWER);
    public java.lang.String getValue() { return _value_;}
    public static AlcForwardType fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        AlcForwardType enum = (AlcForwardType)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static AlcForwardType fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
