package com.thoughtworks.cschuyle.friendlycoins.primitives;

import junit.framework.TestCase;
import junit.framework.Assert;

import com.thoughtworks.cschuyle.WrappedInteger;

import java.util.Collection;
import java.util.HashSet;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class DenominationTest extends TestCase {

    private static WrappedInteger wrap( int i ) {
        return new WrappedInteger( i );
    }

    public void testIntValue() {
        {
            Denomination denomination1 = Denomination.getInstance( 1 );
            assertEquals( wrap( 1 ), denomination1 );
        }
        {
            Denomination denomination2 = Denomination.getInstance( 2 );
            assertEquals( wrap( 2 ), denomination2 );
        }
    }

    public void testEquality() {
        Denomination denomination1 = Denomination.getInstance( 1 );
        Assert.assertEquals( ONER, denomination1 );
    }

    public void testStringValue() {
        Assert.assertEquals( "1", ONER.stringValue() );
        Assert.assertEquals( "2", TWOER.stringValue() );
    }

    public void testCompareTo() {
        Assert.assertEquals( 0, ONER.compareTo(ONER) );
        Assert.assertEquals( -1, ONER.compareTo(TWOER) );
        Assert.assertEquals( 1, TWOER.compareTo(ONER) );
    }

    public void testHashCode() {

        Collection<Denomination> c = new HashSet<Denomination>();
        assertFalse( c.contains(ONER) );
        c.add(ONER);
        assertTrue( c.contains(ONER) );
        assertFalse( c.contains(TWOER) );
        c.add(TWOER);
        assertTrue( c.contains(TWOER) );
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
