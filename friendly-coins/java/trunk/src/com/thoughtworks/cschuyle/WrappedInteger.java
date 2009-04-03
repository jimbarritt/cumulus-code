package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.ClassHelpers;
import com.thoughtworks.cschuyle.util.IntegerHelpers;

public abstract class WrappedInteger {

    protected int value;

    private WrappedInteger() {}

    public WrappedInteger( int value ) {
        this();
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public String stringValue() {
        return IntegerHelpers.toString( value );
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        return className + "<" + value + ">";
    }

    public @Override int hashCode() {
        return value;
    }
}
