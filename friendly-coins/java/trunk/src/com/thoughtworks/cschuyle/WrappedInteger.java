package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;

public abstract class WrappedInteger {

    protected int value;

    private WrappedInteger() {}

    WrappedInteger( int i ) {
        value = i;
    }

    public int intValue() {
        return value;
    }

    public String stringValue() {
        return "" + value;
    }

    public @Override String toString() {
        final String className = Helpers.getSimpleClassName( this );
        return className + "<" + value + ">";
    }

    public @Override int hashCode() {
        return value;
    }

    public static boolean lessThan( WrappedInteger v1, WrappedInteger v2 ) {
        final int iv1 = v1.intValue();
        final int iv2 = v2.intValue();
        return iv1 < iv2;
    }

    public static boolean greaterThan( WrappedInteger v1, WrappedInteger v2 ) {
        final int iv1 = v1.intValue();
        final int iv2 = v2.intValue();
        return iv1 > iv2;
    }

    public static WrappedInteger minus( WrappedInteger v1, WrappedInteger v2 ) {
        WrappedInteger ret = new WrappedInteger( 0 ) {};
        final int i1 = v1.intValue();
        final int i2 = v2.intValue();
        ret.value = i1 - i2;
        return ret;
    }
    
}
