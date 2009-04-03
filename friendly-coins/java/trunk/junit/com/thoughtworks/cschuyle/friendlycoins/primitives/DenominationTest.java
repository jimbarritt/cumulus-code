package com.thoughtworks.cschuyle.friendlycoins.primitives;

import junit.framework.TestCase;
import junit.framework.Assert;

import com.thoughtworks.cschuyle.friendlycoins.TestConstants;

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
        Assert.assertEquals(TestConstants.ONER, denomination1 );
    }

    public void testStringValue() {
        Assert.assertEquals( "1", TestConstants.ONER.stringValue() );
        Assert.assertEquals( "2", TestConstants.TWOER.stringValue() );
    }

    public void testCompareTo() {
        Assert.assertEquals( 0, TestConstants.ONER.compareTo(TestConstants.ONER) );
        Assert.assertEquals( -1, TestConstants.ONER.compareTo(TestConstants.TWOER) );
        Assert.assertEquals( 1, TestConstants.TWOER.compareTo(TestConstants.ONER) );
    }

    public void testHashCode() {

        Collection<Denomination> c = new HashSet<Denomination>();
        assertFalse( c.contains(TestConstants.ONER) );
        c.add(TestConstants.ONER);
        assertTrue( c.contains(TestConstants.ONER) );
        assertFalse( c.contains(TestConstants.TWOER) );
        c.add(TestConstants.TWOER);
        assertTrue( c.contains(TestConstants.TWOER) );
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
