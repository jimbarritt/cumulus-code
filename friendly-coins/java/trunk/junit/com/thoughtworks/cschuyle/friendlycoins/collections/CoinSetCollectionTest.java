package com.thoughtworks.cschuyle.friendlycoins.collections;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSet;

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
