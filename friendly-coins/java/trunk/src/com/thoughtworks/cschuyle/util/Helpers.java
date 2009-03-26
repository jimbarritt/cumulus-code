package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class Helpers {

    public static final Joiner EMPTY_STRING = new Joiner("");

    public static int intCompareTo( int v1, int v2) {
        return (
                v1 < v2
                    ? -1 : v1 > v2
                        ? 1 : 0 );
    }

    static class Joinee {
        private Object joinee;

        public Joinee( Object o) {
            this.joinee = o;
        }

        public @Override String toString() {
            return (null == joinee) ? "null" : joinee.toString();
        }

    }

    public static String stringJoin( Collection<?> objects, Joiner joiner ) {
        StringBuilder builder = new StringBuilder();
        Joiner useJoiner = EMPTY_STRING;
        for( Object o : objects ) {
            stringJoinAppend( new Joinee(o), useJoiner, builder );
            useJoiner = joiner;
        }
        return builder.toString();
    }

    private static void stringJoinAppend( Joinee o, Joiner joiner, StringBuilder builder ) {
        builder.append( joiner );
        builder.append( o.toString() );
    }

}
