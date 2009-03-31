package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.TestConstants.*;

import java.util.Collection;
import java.util.HashSet;

public class DenominationTest extends TestCase {

    public void testIntValue() {
        {
            Denomination denomination1 = Denomination.getInstance( 1 );
            assertEquals( 1, denomination1.intValue() );
        }
        {
            Denomination denomination2 = Denomination.getInstance( 2 );
            assertEquals( 2, denomination2.intValue() );
        }
    }

    public void testEquality() {
        Denomination denomination1 = Denomination.getInstance( 1 );
        assertEquals( ONE, denomination1 );
    }

    public void testStringValue() {
        assertEquals( "1", ONE.stringValue() );
        assertEquals( "2", TWO.stringValue() );
    }

    public void testCompareTo() {
        assertEquals( 0, ONE.compareTo( ONE ) );
        assertEquals( -1, ONE.compareTo( TWO ) );
        assertEquals( 1, TWO.compareTo( ONE ) );
    }

    public void testHashCode() {

        Collection<Denomination> c = new HashSet<Denomination>();
        assertFalse( c.contains( ONE ) );
        c.add( ONE );
        assertTrue( c.contains( ONE ) );
        assertFalse( c.contains( TWO ) );
        c.add( TWO );
        assertTrue( c.contains( TWO ) );
        assertEquals( 2, c.size() );
    }

    public void testSingleton() {
        Denomination denomination1 = Denomination.getInstance( 1 );
        Denomination denomination1again = Denomination.getInstance( 1 );
        assertSame( denomination1, denomination1again );
    }

    public void testSingletonNotSame() {
        Denomination denomination1 = Denomination.getInstance( 1 );
        Denomination denomination2 = Denomination.getInstance( 2 );
        assertNotSame( denomination1, denomination2 );
    }

}
