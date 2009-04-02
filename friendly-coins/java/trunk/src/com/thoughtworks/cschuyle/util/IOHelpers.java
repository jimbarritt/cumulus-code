package com.thoughtworks.cschuyle.util;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;

public class IOHelpers {

    private IOHelpers() {}

    public final static PrintStream cout = System.out;

    public static void message( String message ) {
        cout.println( message );
    }

    public static void closeReader(BufferedReader reader) {
        if( null != reader) {
            closeNonNullReader( reader );
        }
    }

    public static void closeNonNullReader(BufferedReader reader) {
        try {
            reader.close();
        } catch( IOException e ) { /* GULP */ }
    }

}
