package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.ClassHelpers;

public abstract class AbstractWrappedInteger
        extends ComparableInteger
        implements WrappedInteger {

    protected Integer value;

    public AbstractWrappedInteger( WrappedInteger i ) {
        value = i.intValue();
    }

    public AbstractWrappedInteger( int i ) {
        value = i;
    }

    public @Override @Deprecated Integer intValue() {
        return value;
    }
    
    public String stringValue() {
        return String.format( "%d", value );
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        return className + "<" + value + ">";
    }

    public @Override int hashCode() {
        return value;
    }

    public int compareTo( WrappedInteger rhs ) {
        return value.compareTo( rhs.intValue() );
    }

    public AbstractWrappedInteger minus( WrappedInteger rhs ) {
        return new AbstractWrappedInteger( value - rhs.intValue() ) {};
    }

    public AbstractWrappedInteger plus( WrappedInteger rhs ) {
        return new AbstractWrappedInteger( value + rhs.intValue() ) {};
    }

    public AbstractWrappedInteger plusOne() {
        return plus( new AbstractWrappedInteger( 1 ) {} );
    }

    public @Override boolean greaterThan( WrappedInteger rhs ) {
        return value > rhs.intValue();
    }

    public @Override boolean equals( Object rhs ) {
        return ( rhs instanceof WrappedInteger && value.equals( ((WrappedInteger)rhs).intValue() ) );
    }

    public int sign() {
        return Integer.signum( value );
    }
}
