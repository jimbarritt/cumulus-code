package com.thoughtworks.cschuyle.friendlycoins;

import junit.framework.TestCase;
import junit.framework.Assert;

import com.thoughtworks.cschuyle.friendlycoins.CoinSet;

public class CoinSetTest extends TestCase {

    public void testEqualsNull() {
        Object a = null;
        CoinSet b = CoinSet.createCoinSet();
        assertFalse( b.equals(a) );
    }

    public void testEqualsTrivial() {
        CoinSet a = CoinSet.createCoinSet(TestConstants.ONE);
        CoinSet b = CoinSet.createCoinSet(TestConstants.ONE);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsTrivial() {
        CoinSet a = CoinSet.createCoinSet(TestConstants.ONE);
        CoinSet b = CoinSet.createCoinSet(TestConstants.TWO);

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testEqualsSimple() {
        CoinSet a = CoinSet.createCoinSet(TestConstants.TWO, TestConstants.ONE);
        CoinSet b = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.TWO);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsCardinality() {
        CoinSet a = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.ONE, TestConstants.TWO);
        CoinSet b = CoinSet.createCoinSet(TestConstants.TWO, TestConstants.ONE, TestConstants.ONE);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsCardinality() {
        CoinSet a = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.TWO);
        CoinSet b = CoinSet.createCoinSet(TestConstants.TWO, TestConstants.ONE, TestConstants.ONE);

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testSum() {
        CoinSet a = CoinSet.createCoinSet();
        Assert.assertEquals(TestConstants.TOTAL_ZERO, a.total() );
        a = CoinSet.createCoinSet(TestConstants.ONE);
        Assert.assertEquals(TestConstants.TOTAL_ONE, a.total() );
        a = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.ONE);
        Assert.assertEquals(TestConstants.TOTAL_TWO, a.total() );
        a = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.ONE, TestConstants.FIVE);
        Assert.assertEquals(TestConstants.TOTAL_SEVEN, a.total() );
    }

    public void testClonePlusDenominationConstructor() {
        CoinSet a = CoinSet.createCoinSet(TestConstants.ONE);
        CoinSet b = CoinSet.createAugmentedCoinSet( a, TestConstants.TWO);
        Assert.assertEquals(TestConstants.TOTAL_THREE, b.total() );
    }

}
