package com.thoughtworks.cschuyle.util;

public class Joiner {
    private String joiner;

    public Joiner( String joiner ) {
        this.joiner = joiner;
    }

    public @Override String toString() {
        return joiner;
    }
    
    public static final Joiner COMMA = new Joiner( "," );
}
