/**
 * AlcForwardTargetType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcForwardTargetType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AlcForwardTargetType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NONE = "NONE";
    public static final java.lang.String _NUMBER = "NUMBER";
    public static final java.lang.String _VOICE_MAIL = "VOICE_MAIL";
    public static final java.lang.String _ROUTING_SERVICE = "ROUTING_SERVICE";
    public static final AlcForwardTargetType NONE = new AlcForwardTargetType(_NONE);
    public static final AlcForwardTargetType NUMBER = new AlcForwardTargetType(_NUMBER);
    public static final AlcForwardTargetType VOICE_MAIL = new AlcForwardTargetType(_VOICE_MAIL);
    public static final AlcForwardTargetType ROUTING_SERVICE = new AlcForwardTargetType(_ROUTING_SERVICE);
    public java.lang.String getValue() { return _value_;}
    public static AlcForwardTargetType fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        AlcForwardTargetType enum = (AlcForwardTargetType)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static AlcForwardTargetType fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
