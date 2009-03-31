package com.thoughtworks.cschuyle.util;

public class IntegerHelpers {

    private IntegerHelpers() {}

    public static int intCompareTo( int v1, int v2) {
        return (
                v1 < v2
                    ? -1 : v1 > v2
                        ? 1 : 0 );
    }

    public static String toString( int value ) {
        return String.format( "%d", value );
    }
}
