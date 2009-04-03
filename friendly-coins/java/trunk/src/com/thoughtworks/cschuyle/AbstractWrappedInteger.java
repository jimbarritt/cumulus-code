package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.ClassHelpers;

public abstract class AbstractWrappedInteger implements Comparable<AbstractWrappedInteger> {

    protected Integer value;

    @Deprecated
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

    public AbstractWrappedInteger minus( AbstractWrappedInteger rhs ) {
        return new WrappedInteger( value - rhs.value ) {};
    }

    public AbstractWrappedInteger plus( AbstractWrappedInteger rhs ) {
        return new WrappedInteger( value + rhs.value ) {};
    }

    public AbstractWrappedInteger plusOne() {
        return plus( new WrappedInteger( 1 ) );
    }

    public boolean greaterThan( AbstractWrappedInteger rhs ) {
        return value > rhs.value;
    }

    public boolean lessThan( AbstractWrappedInteger rhs ) {
        return value < rhs.value;
    }

    public boolean lessThanOrEqual( AbstractWrappedInteger rhs ) {
        return ! greaterThan( rhs );
    }

    public boolean greaterThanOrEqual( AbstractWrappedInteger rhs ) {
        return ! lessThan( rhs );
    }

    public @Override boolean equals( Object rhs ) {
        return ( rhs instanceof AbstractWrappedInteger && value == ((AbstractWrappedInteger)rhs).value.intValue() );
    }    
}
