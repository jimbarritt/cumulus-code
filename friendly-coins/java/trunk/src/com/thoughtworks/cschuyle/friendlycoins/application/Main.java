package com.thoughtworks.cschuyle.friendlycoins.application;

import com.thoughtworks.cschuyle.friendlycoins.model.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.recognizers.FriendlyRecognizer;
import com.thoughtworks.cschuyle.friendlycoins.recognizers.FriendlinessResult;
import com.thoughtworks.cschuyle.util.IOHelpers;
import com.thoughtworks.cschuyle.util.StringHelpers;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

import java.io.*;

public class Main {

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
        FriendlinessResult result = recognizer.checkFriendliness( denominationSet, TEN_THOUSAND_CENTS);
        final String message = result.getMessage();
        String extraMessage = (StringHelpers.isEmpty( message )
                ? ""
                : "[ " + message + " ]" );
        IOHelpers.message( result.isFriendly() ? "Friendly" : "Not Friendly" + extraMessage );
    }
}
