package com.thoughtworks.cschuyle.friendlycoins.model;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;

public class CoinRollTest extends TestCase {

    public void testDenominationConstructor() {
        CoinRoll coinRoll = new CoinRoll(ONER);
        assertEquals( Denomination.getInstance( 1 ), coinRoll.denomination );
        assertEquals( Cardinality.getInstance( 1 ), coinRoll.count );
    }

    public void test2ArgConstructor() {
        CoinRoll coinRoll = new CoinRoll(ONER, Cardinality.getInstance( 2 ));
        assertEquals( Denomination.getInstance( 1 ), coinRoll.denomination );
        assertEquals( Cardinality.getInstance( 2 ), coinRoll.count );
    }

    public void testToString() {
        CoinRoll coinRoll = new CoinRoll(ONER);
        assertEquals( "1's:1", coinRoll.toString() );        
    }

    public void testToString2() {
        CoinRoll coinRoll = new CoinRoll(THREER, Cardinality.getInstance( 2 ));
        assertEquals( "3's:2", coinRoll.toString() );
    }

    public void testEquals() {
        CoinRoll coinRoll = new CoinRoll(ONER, Cardinality.getInstance( 2 ));
        CoinRoll coinRoll2 = new CoinRoll(ONER, Cardinality.getInstance( 2 ));
        assertEquals( coinRoll, coinRoll2 );
    }
}
