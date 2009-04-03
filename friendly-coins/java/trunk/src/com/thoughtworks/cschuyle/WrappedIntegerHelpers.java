package com.thoughtworks.cschuyle;

public class WrappedIntegerHelpers {

    public final static WrappedInteger ZERO = new AbstractWrappedInteger( 0 ) {};
    public final static WrappedInteger ONE = new AbstractWrappedInteger( 1 ) {};

    public static int hashCode( WrappedInteger... sequence ) {
        int hashCode = 0;
        for( WrappedInteger i: sequence ) {
            hashCode ^= 17 * i.intValue();
        }
        return hashCode;
    }


    public static WrappedInteger wrap( int i ) {
        return new AbstractWrappedInteger( i ) {};
    }

    public static WrappedInteger wrap( WrappedInteger i ) {
        return new AbstractWrappedInteger( i.intValue() ) {};
    }
}
