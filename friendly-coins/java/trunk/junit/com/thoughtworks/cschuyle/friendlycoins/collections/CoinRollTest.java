package com.thoughtworks.cschuyle.friendlycoins.collections;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinRoll;

public class CoinRollTest extends TestCase {

    public void testDenominationConstructor() {
        CoinRoll coinRoll = new CoinRoll( ONE );
        assertEquals( Denomination.getInstance( 1 ), coinRoll.getDenomination() );
        assertEquals( Cardinality.getInstance( 1 ), coinRoll.getCount() );
    }

    public void test2ArgConstructor() {
        CoinRoll coinRoll = new CoinRoll( ONE, Cardinality.getInstance( 2 ));
        assertEquals( Denomination.getInstance( 1 ), coinRoll.getDenomination() );
        assertEquals( Cardinality.getInstance( 2 ), coinRoll.getCount() );
    }

    public void testToString() {
        CoinRoll coinRoll = new CoinRoll( ONE );
        assertEquals( "1's:1", coinRoll.toString() );        
    }

    public void testToString2() {
        CoinRoll coinRoll = new CoinRoll( THREE, Cardinality.getInstance( 2 ));
        assertEquals( "3's:2", coinRoll.toString() );
    }

    public void testEquals() {
        CoinRoll coinRoll = new CoinRoll( ONE, Cardinality.getInstance( 2 ));
        CoinRoll coinRoll2 = new CoinRoll( ONE, Cardinality.getInstance( 2 ));
        assertEquals( coinRoll, coinRoll2 );
    }
}
