package com.thoughtworks.cschuyle.friendlycoins.solvers;

import junit.framework.TestCase;

import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSetReader;
import com.thoughtworks.cschuyle.friendlycoins.TestConstants;
import com.thoughtworks.cschuyle.friendlycoins.solvers.HighestFirstSolver;

public class HighestFirstSolverTest extends TestCase {

    public void testTrivialCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TestConstants.TOTAL_ONE);
        CoinSet expected = CoinSet.createCoinSet(TestConstants.ONE);
        assertEquals( expected, solution );
    }

    public void testSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 2" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TestConstants.TOTAL_TWO);
        CoinSet expected = CoinSet.createCoinSet(TestConstants.TWO);
        assertEquals( expected, solution );
    }

    public void testNonSimpleCase() {
        {
            DenominationSet denominations = DenominationSetReader.readLine( "1 2 5" );
            CoinSet solution = HighestFirstSolver.solve( denominations, TestConstants.TOTAL_FOUR);
            CoinSet expected = CoinSet.createCoinSet(TestConstants.TWO, TestConstants.TWO);
            assertEquals( expected, solution );
        }
        {
            DenominationSet denominations = DenominationSetReader.readLine( "1 4 5" );
            CoinSet solution = HighestFirstSolver.solve( denominations, TestConstants.TOTAL_EIGHT);
            CoinSet expected = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.ONE, TestConstants.ONE, TestConstants.FIVE);
            assertEquals( expected, solution );
            assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
        }
    }

    public void testAnotherNonSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 4 5" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TestConstants.TOTAL_EIGHT);
        CoinSet expected = CoinSet.createCoinSet(TestConstants.ONE, TestConstants.ONE, TestConstants.ONE, TestConstants.FIVE);
        assertEquals( expected, solution );
        assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
    }

    public void testImpossibleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "2 5" );
        try {
            HighestFirstSolver.solve( denominations, TestConstants.TOTAL_THREE);
            fail();
        } catch( NoSolutionException e) {
            assertEquals( "There is no solution given the denominations DenominationSet<Denomination<2>,Denomination<5>> to give Money<3> cents change.",
                    e.getMessage() );            
        }
    }

}
