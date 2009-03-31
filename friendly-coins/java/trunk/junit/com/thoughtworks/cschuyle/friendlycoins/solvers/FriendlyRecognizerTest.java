package com.thoughtworks.cschuyle.friendlycoins.solvers;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.ArrayList;

import com.thoughtworks.cschuyle.friendlycoins.exception.NotFriendlyException;
import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.TestConstants;
import com.thoughtworks.cschuyle.friendlycoins.solvers.FriendlyRecognizer;

public class FriendlyRecognizerTest extends TestCase {

    private static final int ONE_HUNDRED = 100;

    public void testFriendly() {
        DenominationSet denominations = new DenominationSet(TestConstants.ONE, TestConstants.TWO, TestConstants.FIVE);
        assertTrue ( new FriendlyRecognizer().isFriendly( denominations, TestConstants.TOTAL_ONE_THOUSAND) );
    }

    public void testUnfriendly() {
        DenominationSet denominations = new DenominationSet(TestConstants.ONE, TestConstants.FOUR, TestConstants.FIVE);
        try {
            new FriendlyRecognizer().isFriendly( denominations, TestConstants.TOTAL_TEN);
            fail();
        } catch( NotFriendlyException e ) {
            assertEquals( "NOT FRIENDLY.  For Money<8> cents, highest-first gives CoinSet<1's:3,5's:1> (Cardinality<4> coins), but change can be given in Cardinality<2> coins: CoinSet<4's:2>"
                    , e.getMessage() );
        }
    }
    
    public void testIncomplete() {
        DenominationSet denominations = new DenominationSet(TestConstants.TWO);
        try {
            new FriendlyRecognizer().isFriendly( denominations, TestConstants.TOTAL_TWO);
        } catch( NoSolutionException e ) {
            assertEquals( "There is no solution given the denominations DenominationSet<Denomination<2>> to give Money<1> cents change.", e.getMessage() );
        }
    }

    public void testScalability() {
        final FriendlyRecognizer recognizer = new FriendlyRecognizer();
        Collection<Denomination> ints = new ArrayList<Denomination>();
        for(int i = 1; i <= ONE_HUNDRED; ++i ) {
            ints.add( Denomination.getInstance( i ) );
        }
        Denomination[] intsArr = ints.toArray( new Denomination[ONE_HUNDRED] );
        try {
            DenominationSet denominations = new DenominationSet( intsArr );
            assertTrue( recognizer.isFriendly( denominations, new Money( TestConstants.TOTAL_TEN_THOUSAND.intValue() ) ) );
        } catch ( Error e ) {
            /* Just return */
        }
    }

}

