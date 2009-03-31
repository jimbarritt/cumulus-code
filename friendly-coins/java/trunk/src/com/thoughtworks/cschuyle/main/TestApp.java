package com.thoughtworks.cschuyle.main;

import com.thoughtworks.cschuyle.*;

import static com.thoughtworks.cschuyle.TestConstants.*;

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
            readAndProcessLine(reader, recognizer);
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

    private static void processLine(FriendlyRecognizer recognizer, DenominationSet den) {
        if( den.isEmpty() ) {
            return;
        }
        try {
            boolean friendly = recognizer.isFriendly( den,  UP_TO );
            System.out.println( friendly ? "Friendly" : "Not Friendly" );
        } catch( NoSolutionException e) {
            System.out.println( "Not Complete: " + e.getMessage() );
        } catch( NotFriendlyException e) {
            System.out.println( "Not Friendly: " + e.getMessage() );
        }
    }
}
