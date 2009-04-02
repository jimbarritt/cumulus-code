package com.thoughtworks.cschuyle.util;

public class IntegerHelpers {

    private IntegerHelpers() {}

    public static int intCompareTo( int value1, int value2) {
        return (
                value1 < value2
                    ? -1 : value1 > value2
                        ? 1 : 0 );
    }

    public static String toString( int value ) {
        return String.format( "%d", value );
    }
}
