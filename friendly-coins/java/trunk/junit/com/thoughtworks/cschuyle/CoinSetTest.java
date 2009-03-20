package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class CoinSetTest extends TestCase {

    public void testEqualsNull() {
        Object a = null;
        CoinSet b = new CoinSet();
        assertFalse( b.equals(a) );
    }

    public void testEqualsTrivial() {
        CoinSet a = new CoinSet( 1 );
        CoinSet b = new CoinSet( 1 );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsTrivial() {
        CoinSet a = new CoinSet( 1 );
        CoinSet b = new CoinSet( 2 );

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testEqualsSimple() {
        CoinSet a = new CoinSet( 2, 1 );
        CoinSet b = new CoinSet( 1, 2 );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsSubClass() {
        CoinSet a = new CoinSet( 1 ) {

        };
        CoinSet b = new CoinSet( 1 );
        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testEqualsCardinality() {
        CoinSet a = new CoinSet( 1, 1, 2 );
        CoinSet b = new CoinSet( 2, 1, 1 );

        assertEquals( a, b );
        assertEquals( b, a );
    }

    public void testNotEqualsCardinality() {
        CoinSet a = new CoinSet( 1, 2 );
        CoinSet b = new CoinSet( 2, 1, 1 );

        assertFalse( a.equals(b) );
        assertFalse( b.equals(a) );
    }

    public void testSum() {
        CoinSet a = new CoinSet();
        assertEquals( 0, a.sum() );
        a = new CoinSet ( 1 );
        assertEquals( 1, a.sum () );
        a = new CoinSet( 1, 1 );
        assertEquals( 2, a.sum() );
        a = new CoinSet( 1, 1, 5 );
        assertEquals( 7, a.sum() );
    }

    public void testCloneConstructor() {
        CoinSet a = new CoinSet( 1 );
        CoinSet b = CoinSet.createClone( a );
        assertEquals( a, b );
        assertEquals( b, a );
        assertEquals( 1, b.sum() );
        assertEquals( a.sum(), b.sum() );
    }

    public void testClonePlusDenominationConstructor() {
        CoinSet a = new CoinSet( 1 );
        CoinSet b = CoinSet.createAugmentedCoinSet( a, 2 );
        assertEquals( 3, b.sum() );
    }
}
