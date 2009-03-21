package com.thoughtworks.cschuyle.main;

import com.thoughtworks.cschuyle.*;

import java.io.*;

public class TestApp {

    public static void main( String[] args ) {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        try {
            mainBody( reader );
        } catch (IOException e) {
        } finally {
            closeReader( reader );
        }
    }

    private static void closeReader(BufferedReader reader) {
        if( null != reader) {
            closeNonNullReader(reader);
        }
    }

    private static void closeNonNullReader(BufferedReader reader) {
        try {
            reader.close();
        } catch( IOException e ) {}
    }

    private static void mainBody(BufferedReader reader) throws IOException {
        FriendlyRecognizer recognizer = new FriendlyRecognizer();
        for(;;) {
            readAndProcessLine(reader, recognizer);
        }
    }

    private static void readAndProcessLine(BufferedReader reader, FriendlyRecognizer recognizer) throws IOException {
        try {
            String line = reader.readLine();
            DenominationSet den = DenominationSetReader.read( line );
            processLine( recognizer, den );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static int UP_TO = 1000;

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
