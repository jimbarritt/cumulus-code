package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.Iterator;

public class DenominationSetReaderTest extends TestCase {

    private static DenominationSetReader getReader() {
        return new DenominationSetReader();
    }

    private static DenominationSet readInputLine(String inputLine) {
        DenominationSetReader reader = getReader();
        DenominationSet input = reader.read(inputLine);
        return input;
    }

    // TESTS

    public void testReadsInputLineEmpty() {
        final String inputLine = "";
        DenominationSet input = readInputLine(inputLine);
        assertEquals( 0, input.size());
    }

    public void testReadsInputLineOne() {
        final String inputLine = "1";
        DenominationSet input = readInputLine(inputLine);
        assertEquals( 1, input.size());
    }

    public void testReadsInputLineMany() {
        final String inputLine = "1 2";
        DenominationSet input = readInputLine(inputLine);
        assertEquals( 2, input.size());
        Iterator<Integer> iter = input.iterator();
        boolean one = false, two = false;
        while( iter.hasNext()) {
            int i = iter.next();
            switch( i ) {
                case 1:
                    one = true; break;
                case 2:
                    two = true; break;
                default:
                    fail( "Unexpected value " + i );
            }
        }
        assertTrue( one );
        assertTrue( two );
    }


    public void testListCannotContainDuplicates() {
        final String inputLine = "1 1";
        DenominationSetReader reader = getReader();
        try {
            reader.read(inputLine);
            fail();
        } catch( IllegalArgumentException e) {
            assertEquals( "Attempt to add a duplicate denomination, 1 cents", e.getMessage() );
        }
    }
}
