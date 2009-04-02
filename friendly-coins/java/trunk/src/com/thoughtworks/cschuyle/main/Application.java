package com.thoughtworks.cschuyle.main;

import com.thoughtworks.cschuyle.friendlycoins.exception.*;
import com.thoughtworks.cschuyle.friendlycoins.*;
import com.thoughtworks.cschuyle.friendlycoins.solvers.FriendlyRecognizer;
import com.thoughtworks.cschuyle.util.IOHelpers;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

import java.io.*;

public class Application {

    public static void main( String[] args ) {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        try {
            mainBody( reader );
        } finally {
            IOHelpers.closeReader( reader );
        }
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
            DenominationSet denominationSet = DenominationSetReader.read( line );
            if( ! denominationSet.isEmpty()) {
                processLine( recognizer, denominationSet );
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void processLine( FriendlyRecognizer recognizer, DenominationSet denominationSet ) {
        try {
            recognizer.checkFriendliness( denominationSet,  TOTAL_TEN_THOUSAND );
            IOHelpers.message( recognizer.isFriendly() ? "Friendly" : "Not Friendly" );
        } catch( NoSolutionException e) {
            IOHelpers.message( "Not Complete: " + e.getMessage());
        } catch( NotFriendlyException e) {
            IOHelpers.message( "Not Friendly: " + e.getMessage() );
        }
    }
}
