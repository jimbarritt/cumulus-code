package com.thoughtworks.cschuyle.friendlycoins.solvers;

import junit.framework.TestCase;

import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSetReader;
import com.thoughtworks.cschuyle.friendlycoins.TestConstants;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class HighestFirstSolverTest extends TestCase {

    public void testTrivialCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TestConstants.TOTAL_ONE);
        CoinSet expected = new CoinSet(ONE);
        assertEquals( expected, solution );
    }

    public void testSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 2" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TOTAL_TWO);
        CoinSet expected = new CoinSet(TWO);
        assertEquals( expected, solution );
    }

    public void testNonSimpleCase() {
        {
            DenominationSet denominations = DenominationSetReader.readLine( "1 2 5" );
            CoinSet solution = HighestFirstSolver.solve( denominations, TOTAL_FOUR);
            CoinSet expected = new CoinSet(TWO, TWO);
            assertEquals( expected, solution );
        }
        {
            DenominationSet denominations = DenominationSetReader.readLine( "1 4 5" );
            CoinSet solution = HighestFirstSolver.solve( denominations, TOTAL_EIGHT);
            CoinSet expected = new CoinSet(ONE, ONE, ONE, FIVE);
            assertEquals( expected, solution );
            assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
        }
    }

    public void testAnotherNonSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 4 5" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TOTAL_EIGHT);
        CoinSet expected = new CoinSet(ONE, ONE, ONE, FIVE);
        assertEquals( expected, solution );
        assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
    }

    public void testImpossibleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "2 5" );
        try {
            HighestFirstSolver.solve( denominations, TOTAL_THREE);
            fail();
        } catch( NoSolutionException e) {
            assertEquals( "There is no solution given the denominations DenominationSet<Denomination<5>,Denomination<2>> to give Money<3> cents change.",
                    e.getMessage() );            
        }
    }

}
