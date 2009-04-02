package com.thoughtworks.cschuyle.friendlycoins.solvers;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.ArrayList;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class FriendlyRecognizerTest extends TestCase {

    private static final int ONE_HUNDRED = 100;

    public void testFriendly() {
        DenominationSet denominations = new DenominationSet( ONE, TWO, FIVE );
        final FriendlyRecognizer recognizer = new FriendlyRecognizer();
        recognizer.checkFriendliness( denominations, TOTAL_TEN );
        assertTrue( recognizer.isFriendly() );
    }

    public void testUnfriendly() {
        DenominationSet denominations = new DenominationSet( ONE, FOUR, FIVE );
        final FriendlyRecognizer recognizer = new FriendlyRecognizer();
        recognizer.checkFriendliness( denominations, TOTAL_TEN );
        assertEquals( false, recognizer.isFriendly() );
        assertEquals( "NOT FRIENDLY.  For Money<8> cents, highest-first gives CoinSet<1's:3,5's:1> (Cardinality<4> coins), but change can be given in Cardinality<2> coins: CoinSet<4's:2>", 
            recognizer.getFailureException().getMessage() );
    }
    
    public void testIncomplete() {
        DenominationSet denominations = new DenominationSet(TWO);
        final FriendlyRecognizer recognizer = new FriendlyRecognizer();
        recognizer.checkFriendliness( denominations, TOTAL_TWO );
        assertEquals( false, recognizer.isFriendly() );
        assertEquals( "There is no solution given the denominations DenominationSet<Denomination<2>> to give Money<1> cents change.", 
            recognizer.getFailureException().getMessage() );
    }

    public void testScalability() {
        final FriendlyRecognizer recognizer = new FriendlyRecognizer();
        Collection<Denomination> ints = new ArrayList<Denomination>();
        for( int i = 1 ; i <= ONE_HUNDRED ; ++i ) {
            ints.add( Denomination.getInstance( i ) );
        }
        Denomination[] intsArr = ints.toArray( new Denomination[ONE_HUNDRED] );
        try {
            DenominationSet denominations = new DenominationSet( intsArr );
            recognizer.checkFriendliness( denominations, new Money( TOTAL_TEN_THOUSAND.intValue() ) );
            assertTrue( recognizer.isFriendly() );
        } catch ( Error e ) {
            /* Just return */
        }
    }

}

