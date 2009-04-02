package com.thoughtworks.cschuyle.friendlycoins;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;

public class CoinRollCollectionTest extends TestCase {

    public void testConstructor() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        assertEquals( 0, coinRolls.size() );
    }

    public void testSimplePut() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll( ONE );
        coinRolls.put( 1, coinRoll );
        assertEquals( 1, coinRolls.size() );
    }

    public void testDoublePut() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll1 = new CoinRoll( ONE );
        CoinRoll coinRoll2 = new CoinRoll( TWO );
        CoinRoll coinRoll3 = new CoinRoll( THREE );
        coinRolls.put( 1, coinRoll1 );
        coinRolls.put( 2, coinRoll2 );
        coinRolls.put( 3, coinRoll3 );
        coinRolls.put( 1, coinRoll3 );
        coinRolls.put( 2, coinRoll2 );
        coinRolls.put( 3, coinRoll1 );
        assertEquals( 3, coinRolls.size() );
    }

    public void testTotalCoinCount() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll( ONE );
        coinRolls.put( 1, coinRoll );
        Cardinality count = coinRolls.getTotalCoinCount();
        assertEquals( 1, count.intValue() );
    }

    public void testTotalCoinCountAfterReputting() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll( ONE );
        CoinRoll coinRoll2 = new CoinRoll( TWO );
        coinRolls.put( 1, coinRoll );
        coinRolls.put( 1, coinRoll2 );
        Cardinality count = coinRolls.getTotalCoinCount();
        assertEquals( 1, count.intValue() );
    }

    public void testTotalCoinCountTwoDenominations() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll( ONE );
        coinRolls.put( 1, coinRoll );
        coinRolls.put( 2, coinRoll );
        Cardinality count = coinRolls.getTotalCoinCount();
        assertEquals( 2, count.intValue() );
    }

    public void testToString() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll( ONE );
        CoinRoll coinRoll2 = new CoinRoll( TWO );
        coinRolls.put( 1, coinRoll );
        coinRolls.put( 1, coinRoll2 );
        assertEquals( "CoinRollCollection<2's:1>", coinRolls.toString() );
    }

    public void testToStringOtherOrder() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll( ONE );
        CoinRoll coinRoll2 = new CoinRoll( TWO );
        coinRolls.put( 1, coinRoll2 );
        coinRolls.put( 1, coinRoll );
        assertEquals( "CoinRollCollection<1's:1>", coinRolls.toString() );
    }

    public void testEquals() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRollCollection coinRolls2 = new CoinRollCollection();
        assertEquals( coinRolls, coinRolls2 );
    }

    public void testEqualsSimple() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        coinRolls.put( 1, new CoinRoll( ONE ));
        CoinRollCollection coinRolls2 = new CoinRollCollection();
        coinRolls2.put( 1, new CoinRoll( ONE ));
        assertEquals( coinRolls, coinRolls2 );
    }

}
