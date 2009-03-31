package com.thoughtworks.cschuyle.friendlycoins.primitives;

import junit.framework.TestCase;
import junit.framework.Assert;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
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
        Assert.assertEquals(TestConstants.ONE, denomination1 );
    }

    public void testStringValue() {
        Assert.assertEquals( "1", TestConstants.ONE.stringValue() );
        Assert.assertEquals( "2", TestConstants.TWO.stringValue() );
    }

    public void testCompareTo() {
        Assert.assertEquals( 0, TestConstants.ONE.compareTo(TestConstants.ONE) );
        Assert.assertEquals( -1, TestConstants.ONE.compareTo(TestConstants.TWO) );
        Assert.assertEquals( 1, TestConstants.TWO.compareTo(TestConstants.ONE) );
    }

    public void testHashCode() {

        Collection<Denomination> c = new HashSet<Denomination>();
        assertFalse( c.contains(TestConstants.ONE) );
        c.add(TestConstants.ONE);
        assertTrue( c.contains(TestConstants.ONE) );
        assertFalse( c.contains(TestConstants.TWO) );
        c.add(TestConstants.TWO);
        assertTrue( c.contains(TestConstants.TWO) );
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
