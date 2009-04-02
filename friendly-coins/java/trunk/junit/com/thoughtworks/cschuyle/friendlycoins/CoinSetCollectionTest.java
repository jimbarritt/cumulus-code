package com.thoughtworks.cschuyle.friendlycoins;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class CoinSetCollectionTest extends TestCase {

    public void testEquals() {
        CoinSet coinSet = new CoinSet( ONE );
        CoinSetCollection coinSets = new CoinSetCollection();
        coinSets.add( coinSet );

        CoinSetCollection coinSets2 = new CoinSetCollection();
        coinSets2.add( coinSet );
        assertEquals( coinSets, coinSets2 );
        assertEquals( coinSets2, coinSets );
    }

    public void testToString() {
        CoinSet coinSet = new CoinSet( ONE, ONE );
        CoinSetCollection coinSets = new CoinSetCollection();
        coinSets.add( coinSet );
        assertEquals( "[CoinSet<1's:2>]", coinSets.toString() );        
    }

    public void testContains() {
        CoinSet coinSet = new CoinSet( ONE, ONE );
        CoinSetCollection coinSets = new CoinSetCollection();
        coinSets.add( coinSet );

        CoinSet duplicateCoinSet = new CoinSet( ONE, ONE );
        assertTrue( coinSets.contains( duplicateCoinSet ) );
    }
}
