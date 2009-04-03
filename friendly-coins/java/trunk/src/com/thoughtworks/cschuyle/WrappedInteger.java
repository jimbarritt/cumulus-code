package com.thoughtworks.cschuyle;

public class WrappedInteger extends AbstractWrappedInteger {

    private WrappedInteger() {}

    public WrappedInteger( int value ) {
        this(); // prevent warning private constructor not called
        this.value = value;
    }

    public WrappedInteger( AbstractWrappedInteger rhs ) {
        this( rhs.value );
    }

    public int sign() {
        return Integer.signum( value );
    }

    public static int hashCode( WrappedInteger ... sequence ) {
        int hashCode = 0;
        for( WrappedInteger i: sequence ) {
            hashCode ^= 17 * i.intValue();
        }
        return hashCode;
    }
}
