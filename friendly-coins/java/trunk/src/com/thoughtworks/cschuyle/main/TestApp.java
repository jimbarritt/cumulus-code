package com.thoughtworks.cschuyle.main;

import com.thoughtworks.cschuyle.friendlycoins.exception.NotFriendlyException;
import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSetReader;
import com.thoughtworks.cschuyle.friendlycoins.solvers.FriendlyRecognizer;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

import java.io.*;

public class TestApp {

    public static void main( String[] args ) {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        try {
            mainBody( reader );
        } finally {
            closeReader( reader );
        }
    }

    private static void closeReader(BufferedReader reader) {
        if( null != reader) {
            closeNonNullReader( reader );
        }
    }

    private static void closeNonNullReader(BufferedReader reader) {
        try {
            reader.close();
        } catch( IOException e ) { /* GULP */ }
    }

    private static void mainBody(BufferedReader reader) {
        FriendlyRecognizer recognizer = new FriendlyRecognizer();
        for(;;) {
            readAndProcessLine( reader, recognizer );
        }
    }

    private static void readAndProcessLine( BufferedReader reader, FriendlyRecognizer recognizer ) {
        try {
            String line = reader.readLine();
            DenominationSet den = DenominationSetReader.read( line );
            processLine( recognizer, den );
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private final static Money UP_TO = TOTAL_ONE_THOUSAND;

    private static void processLine( FriendlyRecognizer recognizer, DenominationSet denominationSet ) {
        if( denominationSet.isEmpty() ) {
            return;
        }
        try {
            boolean friendly = recognizer.isFriendly( denominationSet,  UP_TO );
            message( friendly ? "Friendly" : "Not Friendly" );
        } catch( NoSolutionException e) {
            message( "Not Complete: " + e.getMessage());
        } catch( NotFriendlyException e) {
            message( "Not Friendly: " + e.getMessage() );
        }
    }

    private final static PrintStream cout = System.out;

    private static void message( String message ) {
        cout.println( message );
    }
}
