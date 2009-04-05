package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class StringHelpers {

    public static final String NULL_STRING = "null";

    private StringHelpers() {}

    public static String join( Collection<?> joinees, Joiner joiner ) {
        return new StringJoiner( joinees, joiner ).join();
    }

    public static boolean isEmpty(String message) {
        return ( null == message || message.length() == 0 );
    }
}
