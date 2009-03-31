package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.TestConstants.*;

public class CoinSetTest extends TestCase {

    public void testEqualsNull() {
        Object a = null;
        CoinSet b = CoinSet.createCoinSet();
        assertFalse( b.equals(a) );
    }

    public void testEqualsTrivial() {
        CoinSet a = CoinSet.createCoinSet( ONE );
        CoinSet b = CoinSet.createCoinSet( ONE );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsTrivial() {
        CoinSet a = CoinSet.createCoinSet( ONE );
        CoinSet b = CoinSet.createCoinSet( TWO );

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testEqualsSimple() {
        CoinSet a = CoinSet.createCoinSet( TWO, ONE );
        CoinSet b = CoinSet.createCoinSet( ONE, TWO );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsCardinality() {
        CoinSet a = CoinSet.createCoinSet( ONE, ONE, TWO );
        CoinSet b = CoinSet.createCoinSet( TWO, ONE, ONE );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsCardinality() {
        CoinSet a = CoinSet.createCoinSet( ONE, TWO );
        CoinSet b = CoinSet.createCoinSet( TWO, ONE, ONE );

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testSum() {
        CoinSet a = CoinSet.createCoinSet();
        assertEquals( TOTAL_ZERO, a.total() );
        a = CoinSet.createCoinSet( ONE );
        assertEquals( TOTAL_ONE, a.total() );
        a = CoinSet.createCoinSet( ONE, ONE );
        assertEquals( TOTAL_TWO, a.total() );
        a = CoinSet.createCoinSet( ONE, ONE, FIVE );
        assertEquals( TOTAL_SEVEN, a.total() );
    }

    public void testClonePlusDenominationConstructor() {
        CoinSet a = CoinSet.createCoinSet( ONE );
        CoinSet b = CoinSet.createAugmentedCoinSet( a, TWO );
        assertEquals( TOTAL_THREE, b.total() );
    }

}
