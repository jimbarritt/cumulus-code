package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class Helpers {
    
    public static String stringJoin( Collection<?> objects, String joiner ) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for( Object o : objects ) {
            first = stringJoinAppend( o, joiner, builder, first );
        }
        return builder.toString();
    }

    private static boolean stringJoinAppend( Object o, String joiner, StringBuilder builder, boolean first ) {
        if( ! first ) {
            builder.append( joiner );
        } else {
            first = false;
        }
        builder.append( (null == o) ? "null" : o.toString() );        
        return first;
    }

}
