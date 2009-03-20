package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class FriendlyRecognizerTest extends TestCase {

    final int TEN_THOUSAND = 10000;
    // TODO This doesn't scale to ten thousand.  Boo.

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

    public void DISABLED_testScalability() {
        for( int total = 1 ; total <= TEN_THOUSAND ; ++total ) {
            final FriendlyRecognizer recognizer = new FriendlyRecognizer();
            try {
                DenominationSet denominations = new DenominationSet( 1, 2, 5 );
                assertTrue ( recognizer.isFriendly( denominations, total ));
            } catch ( Error e ) {
                return;
            }
        }
    }

}
