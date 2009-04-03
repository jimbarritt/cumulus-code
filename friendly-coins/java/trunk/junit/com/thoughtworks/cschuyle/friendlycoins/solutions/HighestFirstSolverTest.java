package com.thoughtworks.cschuyle.friendlycoins.solutions;

import junit.framework.TestCase;

import com.thoughtworks.cschuyle.friendlycoins.model.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.model.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.application.DenominationSetReader;
import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class HighestFirstSolverTest extends TestCase {

    public void testTrivialCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1" );
        CoinSet solution = HighestFirstSolver.solve( denominations, ONE_CENT);
        CoinSet expected = new CoinSet(ONER);
        assertEquals( expected, solution );
    }

    public void testSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 2" );
        CoinSet solution = HighestFirstSolver.solve( denominations, TWO_CENTS);
        CoinSet expected = new CoinSet(TWOER);
        assertEquals( expected, solution );
    }

    public void testNonSimpleCase() {
        {
            DenominationSet denominations = DenominationSetReader.readLine( "1 2 5" );
            CoinSet solution = HighestFirstSolver.solve( denominations, FOUR_CENTS);
            CoinSet expected = new CoinSet(TWOER, TWOER);
            assertEquals( expected, solution );
        }
        {
            DenominationSet denominations = DenominationSetReader.readLine( "1 4 5" );
            CoinSet solution = HighestFirstSolver.solve( denominations, EIGHT_CENTS);
            CoinSet expected = new CoinSet(ONER, ONER, ONER, FIVER);
            assertEquals( expected, solution );
            assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
        }
    }

    public void testAnotherNonSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 4 5" );
        CoinSet solution = HighestFirstSolver.solve( denominations, EIGHT_CENTS);
        CoinSet expected = new CoinSet(ONER, ONER, ONER, FIVER);
        assertEquals( expected, solution );
        assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
    }

    public void testImpossibleCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "2 5" );
        try {
            HighestFirstSolver.solve( denominations, THREE_CENTS);
            fail();
        } catch( NoSolutionException e) {
            assertEquals( "There is no solution: I can't use DenominationSet<Denomination<5>,Denomination<2>> to arrive at Money<3> cents change",
                    e.getMessage() );            
        }
    }

}
