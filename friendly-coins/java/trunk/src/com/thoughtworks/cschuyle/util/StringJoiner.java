package com.thoughtworks.cschuyle.util;

import java.util.Collection;

class StringJoiner {

    private Joiner joiner;
    private Collection<?> joinees;
    private StringBuilder builder = new StringBuilder();

    public StringJoiner( Collection<?> joinees, Joiner joiner ) {
        this.joinees = joinees;
        this.joiner = joiner;
    }
    
    public String join( ) {
        Joiner useJoiner = Joiner.EMPTY_STRING;
        for( Object joinee : joinees ) {
            stringJoinAppend( new Joinee( joinee ), useJoiner );
            useJoiner = joiner;
        }
        return builder.toString();
    }

    private static class Joinee {
        private String joinee;

        public Joinee( Object joinee ) {
            this.joinee = possiblyNullString( joinee );
        }

        public @Override String toString() {
            return joinee;
        }

        static String possiblyNullString( Object joinee) {
            return (null == joinee
                    ? StringHelpers.NULL_STRING
                    : joinee.toString() );
        }
    }

    private void stringJoinAppend( Joinee joinee, Joiner joiner ) {
        builder.append( joiner );
        builder.append( joinee.toString() );
    }
}
