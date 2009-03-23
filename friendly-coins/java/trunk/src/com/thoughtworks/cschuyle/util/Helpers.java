package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class Helpers {

    public static final String EMPTY_STRING = "";

    public static String stringJoin( Collection<?> objects, String joiner ) {
        StringBuilder builder = new StringBuilder();
        String useJoiner = EMPTY_STRING;
        for( Object o : objects ) {
            stringJoinAppend( o, useJoiner, builder );
            useJoiner = joiner;
        }
        return builder.toString();
    }

    private static void stringJoinAppend( Object o, String joiner, StringBuilder builder ) {
        builder.append( joiner );
        builder.append( (null == o) ? "null" : o.toString() );
    }

}
