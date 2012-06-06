/**
 * AlcAddOnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming.types;

public class AlcAddOnType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AlcAddOnType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NO_EXTENSION = "NO_EXTENSION";
    public static final java.lang.String _ADD_ON_10_KEYS = "ADD_ON_10_KEYS";
    public static final java.lang.String _ADD_ON_16_KEYS = "ADD_ON_16_KEYS";
    public static final java.lang.String _ADD_ON_20_KEYS = "ADD_ON_20_KEYS";
    public static final java.lang.String _ADD_ON_40_KEYS = "ADD_ON_40_KEYS";
    public static final java.lang.String _ADD_ON_EL_14_KEYS = "ADD_ON_EL_14_KEYS";
    public static final java.lang.String _UNDEFINED = "UNDEFINED";
    public static final AlcAddOnType NO_EXTENSION = new AlcAddOnType(_NO_EXTENSION);
    public static final AlcAddOnType ADD_ON_10_KEYS = new AlcAddOnType(_ADD_ON_10_KEYS);
    public static final AlcAddOnType ADD_ON_16_KEYS = new AlcAddOnType(_ADD_ON_16_KEYS);
    public static final AlcAddOnType ADD_ON_20_KEYS = new AlcAddOnType(_ADD_ON_20_KEYS);
    public static final AlcAddOnType ADD_ON_40_KEYS = new AlcAddOnType(_ADD_ON_40_KEYS);
    public static final AlcAddOnType ADD_ON_EL_14_KEYS = new AlcAddOnType(_ADD_ON_EL_14_KEYS);
    public static final AlcAddOnType UNDEFINED = new AlcAddOnType(_UNDEFINED);
    public java.lang.String getValue() { return _value_;}
    public static AlcAddOnType fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        AlcAddOnType enum = (AlcAddOnType)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static AlcAddOnType fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
