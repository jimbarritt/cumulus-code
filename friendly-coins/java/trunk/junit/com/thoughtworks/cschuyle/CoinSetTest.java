package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class CoinSetTest extends TestCase {

    public void testEqualsNull() {
        Object a = null;
        CoinSet b = CoinSet.createCoinSet();
        assertFalse( b.equals(a) );
    }

    public void testEqualsTrivial() {
        CoinSet a = CoinSet.createCoinSet( 1 );
        CoinSet b = CoinSet.createCoinSet( 1 );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsTrivial() {
        CoinSet a = CoinSet.createCoinSet( 1 );
        CoinSet b = CoinSet.createCoinSet( 2 );

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testEqualsSimple() {
        CoinSet a = CoinSet.createCoinSet( 2, 1 );
        CoinSet b = CoinSet.createCoinSet( 1, 2 );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsCardinality() {
        CoinSet a = CoinSet.createCoinSet( 1, 1, 2 );
        CoinSet b = CoinSet.createCoinSet( 2, 1, 1 );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsCardinality() {
        CoinSet a = CoinSet.createCoinSet( 1, 2 );
        CoinSet b = CoinSet.createCoinSet( 2, 1, 1 );

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testSum() {
        CoinSet a = CoinSet.createCoinSet();
        assertEquals( 0, a.sum() );
        a = CoinSet.createCoinSet( 1 );
        assertEquals( 1, a.sum () );
        a = CoinSet.createCoinSet( 1, 1 );
        assertEquals( 2, a.sum() );
        a = CoinSet.createCoinSet( 1, 1, 5 );
        assertEquals( 7, a.sum() );
    }

    public void testClonePlusDenominationConstructor() {
        CoinSet a = CoinSet.createCoinSet( 1 );
        CoinSet b = CoinSet.createAugmentedCoinSet( a, 2 );
        assertEquals( 3, b.sum() );
    }

    public void testSingleton() {
        CoinSet coinSet = CoinSet.createCoinSet();
        CoinSet coinSet2 = CoinSet.createCoinSet();
        assertSame( coinSet, coinSet2 );
    }

    public void testSingletonAugmentedAndCreated() {
        CoinSet emptyCoinSet = CoinSet.createCoinSet();
        CoinSet coinSet1 = CoinSet.createAugmentedCoinSet( emptyCoinSet, 1 );
        CoinSet coinSet2 = CoinSet.createCoinSet( 1 );
        assertSame( coinSet1, coinSet2 );
    }

    public void testSingletonNotSame() {
        CoinSet emptyCoinSet = CoinSet.createCoinSet();
        CoinSet coinSet1 = CoinSet.createAugmentedCoinSet( emptyCoinSet, 1 );
        CoinSet coinSet2 = CoinSet.createCoinSet( 1 );
        assertSame( coinSet1, coinSet2 );
        CoinSet coinSet3 = CoinSet.createAugmentedCoinSet( coinSet2, 1 );
        assertNotSame( coinSet3, coinSet2 );
        assertNotSame( coinSet3, coinSet1 );
    }

}
