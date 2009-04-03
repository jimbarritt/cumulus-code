package com.thoughtworks.cschuyle.friendlycoins.collections;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class CoinSetTest extends TestCase {

    public void testEqualsNull() {
        Object a = null;
        CoinSet b = new CoinSet();
        assertFalse( b.equals(a) );
    }

    public void testEqualsTrivial() {
        CoinSet a = new CoinSet(ONER);
        CoinSet b = new CoinSet(ONER) ;

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsTrivial() {
        CoinSet a = new CoinSet(ONER);
        CoinSet b = new CoinSet(TWOER);

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testEqualsSimple() {
        CoinSet a = new CoinSet(TWOER, ONER);
        CoinSet b = new CoinSet(ONER, TWOER);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsCardinality() {
        CoinSet a = new CoinSet(ONER, ONER, TWOER);
        CoinSet b = new CoinSet(TWOER, ONER, ONER);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsCardinality() {
        CoinSet a = new CoinSet(ONER, TWOER);
        CoinSet b = new CoinSet(TWOER, ONER, ONER);

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testSum() {
        CoinSet a = new CoinSet();
        assertEquals(ZERO_CENTS, a.total );
        a = new CoinSet(ONER);
        assertEquals(ONE_CENT, a.total );
        a = new CoinSet(ONER, ONER);
        assertEquals(TWO_CENTS, a.total );
        a = new CoinSet(ONER, ONER, FIVER);
        assertEquals(SEVEN_CENTS, a.total );
    }

    public void testClonePlusDenominationConstructor() {
        CoinSet a = new CoinSet(ONER);
        CoinSet b = CoinSet.createAugmentedCoinSet( a, TWOER);
        assertEquals(THREE_CENTS, b.total );
    }

    public void testAugmentCoinSet() {
        CoinSet a = new CoinSet(ONER, ONER);
        CoinSet b = CoinSet.createAugmentedCoinSet( a, TWOER);
        assertEquals( new CoinSet(ONER, ONER, TWOER), b );
    }
}
