package com.thoughtworks.cschuyle;

public class WrappedIntegerHelpers {

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
}
