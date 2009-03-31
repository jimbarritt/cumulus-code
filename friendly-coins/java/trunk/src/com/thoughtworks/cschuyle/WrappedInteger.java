package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.ClassHelpers;
import com.thoughtworks.cschuyle.util.StringHelpers;

public abstract class WrappedInteger {

    protected int value;

    private WrappedInteger() {}

    WrappedInteger( int value ) {
        this();
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public String stringValue() {
        return StringHelpers.toString( value );
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        return className + "<" + value + ">";
    }

    public @Override int hashCode() {
        return value;
    }

    public static boolean lessThan( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        return int1 < int2;
    }

    public static boolean greaterThan( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        return int1 > int2;
    }

    public static WrappedInteger minus( WrappedInteger v1, WrappedInteger v2 ) {
        final int i1 = v1.intValue();
        final int i2 = v2.intValue();
        return new WrappedInteger( i1 - i2 ) {};
    }
    
}
