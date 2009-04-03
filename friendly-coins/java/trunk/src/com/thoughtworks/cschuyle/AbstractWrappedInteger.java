package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.ClassHelpers;

public abstract class AbstractWrappedInteger implements Comparable<AbstractWrappedInteger> {
    protected Integer value;

    public int intValue() {
        return value;
    }

    public String stringValue() {
        final int intValue = value.intValue();
        return String.format( "%d", intValue);
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        return className + "<" + value + ">";
    }

    public @Override int hashCode() {
        return value;
    }

    public int compareTo( AbstractWrappedInteger rhs ) {
        return new Integer( value ).compareTo( rhs.value );
    }
}
