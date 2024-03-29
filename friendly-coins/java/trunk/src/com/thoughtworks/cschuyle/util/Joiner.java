package com.thoughtworks.cschuyle.util;

public class Joiner {

    public static final Joiner COMMA = new Joiner( "," );
    public static final Joiner EMPTY_STRING = new Joiner( "" );

    private String joiner;

    public Joiner( String joiner ) {
        this.joiner = joiner;
    }

    public @Override String toString() {
        return joiner;
    }
}
