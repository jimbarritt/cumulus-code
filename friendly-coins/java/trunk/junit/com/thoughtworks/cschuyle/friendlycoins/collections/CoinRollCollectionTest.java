package com.thoughtworks.cschuyle.friendlycoins.collections;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.AbstractWrappedInteger;
import com.thoughtworks.cschuyle.WrappedInteger;

public class CoinRollCollectionTest extends TestCase {

    private static AbstractWrappedInteger wrap( int i ) {
        return new WrappedInteger( i );
    }

    public void testConstructor() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        assertEquals( 0, coinRolls.size() );
    }

    public void testSimplePut() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll(ONER);
        coinRolls.put( coinRoll );
        assertEquals( 1, coinRolls.size() );
    }

    public void testDoublePut() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll1 = new CoinRoll(ONER);
        CoinRoll coinRoll2 = new CoinRoll(TWOER);
        CoinRoll coinRoll3 = new CoinRoll(THREER);
        coinRolls.put( coinRoll1 );
        coinRolls.put( coinRoll2 );
        coinRolls.put( coinRoll3 );
        coinRolls.put( coinRoll3 );
        coinRolls.put( coinRoll2 );
        coinRolls.put( coinRoll1 );
        assertEquals( 3, coinRolls.size() );
    }

    public void testTotalCoinCount() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll(ONER);
        coinRolls.put( coinRoll );
        Cardinality count = coinRolls.totalCoinCount();
        assertEquals( wrap( 1 ), count );
    }

    public void testTotalCoinCountAfterReputting() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll(ONER);
        coinRolls.put( coinRoll );
        Cardinality count = coinRolls.totalCoinCount();
        assertEquals( wrap( 1 ), count );
    }

    public void testTotalCoinCountTwoDenominations() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll(ONER);
        CoinRoll coinRoll2 = new CoinRoll(TWOER);
        coinRolls.put( coinRoll );
        coinRolls.put( coinRoll2 );
        Cardinality count = coinRolls.totalCoinCount();
        assertEquals( wrap( 2 ), count );
    }

    public void testToString() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll(ONER);
        CoinRoll coinRoll2 = new CoinRoll(TWOER);
        coinRolls.put( coinRoll );
        coinRolls.put( coinRoll2 );
        assertEquals( "CoinRollCollection<1's:1,2's:1>", coinRolls.toString() );
    }

    public void testToStringOtherOrder() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRoll coinRoll = new CoinRoll(ONER);
        CoinRoll coinRoll2 = new CoinRoll(TWOER);
        coinRolls.put( coinRoll2 );
        coinRolls.put( coinRoll );
        assertEquals( "CoinRollCollection<1's:1,2's:1>", coinRolls.toString() );
    }

    public void testEquals() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        CoinRollCollection coinRolls2 = new CoinRollCollection();
        assertEquals( coinRolls, coinRolls2 );
    }

    public void testEqualsSimple() {
        CoinRollCollection coinRolls = new CoinRollCollection();
        coinRolls.put( new CoinRoll(ONER));
        CoinRollCollection coinRolls2 = new CoinRollCollection();
        coinRolls2.put( new CoinRoll(ONER));
        assertEquals( coinRolls, coinRolls2 );
    }

}
