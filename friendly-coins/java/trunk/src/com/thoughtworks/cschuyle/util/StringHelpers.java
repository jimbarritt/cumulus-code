package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class StringHelpers {

    private StringHelpers() {}

    public static final Joiner EMPTY_STRING = new Joiner( "" );

    public static String join( Collection<?> joinees, Joiner joiner ) {
        StringBuilder builder = new StringBuilder();
        Joiner useJoiner = EMPTY_STRING;
        for( Object joinee : joinees ) {
            stringJoinAppend( new Joinee( joinee ), useJoiner, builder );
            useJoiner = joiner;
        }
        return builder.toString();
    }

    private static final String NULL_STRING = "null";

    public static String toString( int value ) {
        return String.format( "%d", value );
    }

    private static class Joinee {
        private Object joinee;

        public Joinee( Object joinee ) {
            this.joinee = joinee;
        }

        public @Override String toString() {
            return possiblyNullString( joinee );
        }

    }
    
    private static void stringJoinAppend( Joinee joinee, Joiner joiner, StringBuilder builder ) {
        builder.append( joiner );
        builder.append( possiblyNullString( joinee ) );
    }

    private static String possiblyNullString( Object joinee) {
        return (null == joinee ? NULL_STRING : joinee.toString() );
    }

    public static class Joiner {

        public static final Joiner COMMA = new Joiner( "," );

        private String joiner;

        public Joiner( String joiner ) {
            this.joiner = joiner;
        }

        public @Override String toString() {
            return joiner;
        }

    }
}
