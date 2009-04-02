package com.thoughtworks.cschuyle.friendlycoins;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class CoinSetTest extends TestCase {

    public void testEqualsNull() {
        Object a = null;
        CoinSet b = new CoinSet();
        assertFalse( b.equals(a) );
    }

    public void testEqualsTrivial() {
        CoinSet a = new CoinSet(TestConstants.ONE);
        CoinSet b = new CoinSet(ONE);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsTrivial() {
        CoinSet a = new CoinSet(ONE);
        CoinSet b = new CoinSet(TWO);

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testEqualsSimple() {
        CoinSet a = new CoinSet(TWO, ONE);
        CoinSet b = new CoinSet(ONE, TWO);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsCardinality() {
        CoinSet a = new CoinSet(ONE, ONE, TWO);
        CoinSet b = new CoinSet(TWO, ONE, ONE);

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsCardinality() {
        CoinSet a = new CoinSet(ONE, TWO);
        CoinSet b = new CoinSet(TWO, ONE, ONE);

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testSum() {
        CoinSet a = new CoinSet();
        assertEquals(TOTAL_ZERO, a.total() );
        a = new CoinSet(ONE);
        assertEquals(TOTAL_ONE, a.total() );
        a = new CoinSet(ONE, ONE);
        assertEquals(TOTAL_TWO, a.total() );
        a = new CoinSet(ONE, ONE, FIVE);
        assertEquals(TOTAL_SEVEN, a.total() );
    }

    public void testClonePlusDenominationConstructor() {
        CoinSet a = new CoinSet(ONE);
        CoinSet b = CoinSet.createAugmentedCoinSet( a, TWO);
        assertEquals(TOTAL_THREE, b.total() );
    }

    public void testAugmentCoinSet() {
        CoinSet a = new CoinSet( ONE, ONE );
        CoinSet b = CoinSet.createAugmentedCoinSet( a, TWO );
        assertEquals( new CoinSet( ONE, ONE, TWO ), b );
    }
}
