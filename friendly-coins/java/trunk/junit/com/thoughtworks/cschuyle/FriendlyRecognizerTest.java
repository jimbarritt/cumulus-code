package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.ArrayList;

public class FriendlyRecognizerTest extends TestCase {

    private static final int TEN_THOUSAND = 10000;
    private static final int ONE_HUNDRED = 100;

    public void testFriendly() {
        DenominationSet denominations = new DenominationSet( 1, 2, 5 );
        assertTrue ( new FriendlyRecognizer().isFriendly( denominations, 10));
    }

    public void testUnfriendly() {
        DenominationSet denominations = new DenominationSet( 1, 4, 5 );
        try {
            new FriendlyRecognizer().isFriendly( denominations, 10);
            fail();
        } catch( NotFriendlyException e) {
            assertEquals( "NOT FRIENDLY.  For 8 cents, highest-first gives CoinSet<1's:3,5's:1> (4 coins), but change can be given in 2 coins: CoinSet<4's:2>"
                    , e.getMessage() );
        }
    }
    
    public void testIncomplete() {
        DenominationSet denominations = new DenominationSet( 2 );
        try {
            new FriendlyRecognizer().isFriendly( denominations, 2 );
        } catch( NoSolutionException e) {
            assertEquals( "There is no solution given the denominations DenominationSet<2> to give 1 cents change.", e.getMessage() );
        }
    }

    // TODO Takes a minute or more.  Optimize sufficiantly to enable.
    public void DISABLED_testScalability() {
        final FriendlyRecognizer recognizer = new FriendlyRecognizer();
        Collection<Integer> ints = new ArrayList<Integer>();
        for(int i = 1; i <= ONE_HUNDRED; ++i ) {
            ints.add( i );
        }
        Integer[] intsArr = ints.toArray( new Integer[ONE_HUNDRED] );
        try {
            DenominationSet denominations = new DenominationSet( intsArr );
            assertTrue ( recognizer.isFriendly( denominations, TEN_THOUSAND ));
        } catch ( Error e ) {
            return;
        }
    }

}

