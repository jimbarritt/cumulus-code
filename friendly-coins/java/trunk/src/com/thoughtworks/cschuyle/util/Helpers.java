package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class Helpers {

    public static final Joiner EMPTY_STRING = new Joiner( "" );
    private static final String NULL_STRING = "null";

    public static int intCompareTo( int v1, int v2) {
        return (
                v1 < v2
                    ? -1 : v1 > v2
                        ? 1 : 0 );
    }

    static class Joinee {
        private Object joinee;

        public Joinee( Object joinee ) {
            this.joinee = joinee;
        }

        public @Override String toString() {
            return possiblyNullString( joinee );
        }

    }

    public static String stringJoin( Collection<?> joinees, Joiner joiner ) {
        StringBuilder builder = new StringBuilder();
        Joiner useJoiner = EMPTY_STRING;
        for( Object joinee : joinees ) {
            stringJoinAppend( new Joinee( joinee ), useJoiner, builder );
            useJoiner = joiner;
        }
        return builder.toString();
    }

    public static String getSimpleClassName( Object object ) {
        final Class<? extends Object> objectClass = object.getClass();
        return objectClass.getSimpleName();
    }

    private static void stringJoinAppend( Joinee joinee, Joiner joiner, StringBuilder builder ) {
        builder.append( joiner );
        builder.append( possiblyNullString( joinee ) );
    }

    private static String possiblyNullString( Object joinee) {
        return (null == joinee ? NULL_STRING : joinee.toString() );
    }

}
