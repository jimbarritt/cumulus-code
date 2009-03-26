package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.TestConstants.*;

import java.util.Collection;
import java.util.HashSet;

public class DenominationTest extends TestCase {

    public void testIntValue() {
        Denomination d = Denomination.getInstance( 1 );
        assertEquals( 1, d.intValue() );

        Denomination d2 = Denomination.getInstance( 2 );
        assertEquals( 2, d2.intValue() );
    }

    public void testEquality() {
        Denomination d = Denomination.getInstance( 1 );
        assertEquals( ONE, d );
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
        c.add( TWO );
        assertTrue( c.contains( TWO ) );
        assertEquals( 2, c.size() );
    }

    public void testSingleton() {
        Denomination d1 = Denomination.getInstance( 1 );
        Denomination d2 = Denomination.getInstance( 1 );
        assertSame( d1, d2 );
    }

    public void testSingletonNotSame() {
        Denomination d1 = Denomination.getInstance( 1 );
        Denomination d2 = Denomination.getInstance( 2 );
        assertNotSame( d1, d2 );
    }

}
