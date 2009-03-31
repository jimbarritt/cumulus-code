package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.Iterator;

import static com.thoughtworks.cschuyle.TestConstants.*;

public class DenominationSetReaderTest extends TestCase {

    private static DenominationSet readInputLine( String inputLine ) {
        DenominationSet input = DenominationSetReader.read( inputLine );
        assertNotNull( input );
        return input;
    }

    // TESTS

    public void testReadsInputLineEmpty() {
        final String inputLine = "";
        DenominationSet input = readInputLine( inputLine );
        assertEquals( 0, input.size());
    }

    public void testReadsInputLineOne() {
        final String inputLine = "1";
        DenominationSet input = readInputLine( inputLine );
        assertEquals( 1, input.size());
    }

    public void testReadsInputLineMany() {
        final String inputLine = "1 2";
        DenominationSet input = readInputLine( inputLine );
        assertEquals( 2, input.size());
        Iterator<Denomination> iter = input.iterator();
        boolean one = false, two = false;
        while( iter.hasNext() ) {
            Denomination d = iter.next();
            if( d.equals( ONE ) ) {
                one = true;
            } else if( d.equals( TWO ) ) {
                two = true;
            } else {
                fail( "Unexpected value " + d );
            }
        }
        assertTrue( one );
        assertTrue( two );
    }


    public void testListCannotContainDuplicates() {
        final String inputLine = "1 1";
        try {
            DenominationSetReader.read( inputLine );
            fail();
        } catch( IllegalArgumentException e) {
            assertEquals( "Attempt to add a duplicate value, 1 cents", e.getMessage() );
        }
    }
}
