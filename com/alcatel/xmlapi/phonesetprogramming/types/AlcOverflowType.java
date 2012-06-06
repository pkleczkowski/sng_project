/**
 * AlcOverflowType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcOverflowType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AlcOverflowType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NO_OVERFLOW = "NO_OVERFLOW";
    public static final java.lang.String _ON_BUSY = "ON_BUSY";
    public static final java.lang.String _ON_NO_ANSWER = "ON_NO_ANSWER";
    public static final java.lang.String _ON_BUSY_OR_NO_ANSWER = "ON_BUSY_OR_NO_ANSWER";
    public static final AlcOverflowType NO_OVERFLOW = new AlcOverflowType(_NO_OVERFLOW);
    public static final AlcOverflowType ON_BUSY = new AlcOverflowType(_ON_BUSY);
    public static final AlcOverflowType ON_NO_ANSWER = new AlcOverflowType(_ON_NO_ANSWER);
    public static final AlcOverflowType ON_BUSY_OR_NO_ANSWER = new AlcOverflowType(_ON_BUSY_OR_NO_ANSWER);
    public java.lang.String getValue() { return _value_;}
    public static AlcOverflowType fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        AlcOverflowType enum = (AlcOverflowType)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static AlcOverflowType fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
