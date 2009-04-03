package com.thoughtworks.cschuyle;

public class WrappedInteger extends AbstractWrappedInteger {

    private WrappedInteger() {}

    protected WrappedInteger( int value ) {
        this(); // prevent warning private constructor not called
        this.value = value;
    }

    public WrappedInteger( AbstractWrappedInteger rhs ) {
        this( rhs.value );
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

    public @Override boolean equals( Object rhs ) {
        return ( rhs instanceof AbstractWrappedInteger && value == ((AbstractWrappedInteger)rhs).value.intValue() );
    }

    public int sign() {
        return (value < 0
                ? -1
                : value > 0
                    ? 1
                    : 0 );
    }
}
