package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class HighestFirstSolverTest extends TestCase {

    public void testTrivialCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1");
        CoinSet solution = HighestFirstSolver.solve( denominations, 1 );
        CoinSet expected = new CoinSet( 1 );
        assertEquals(expected, solution);
    }

    public void testSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1 2");
        CoinSet solution = HighestFirstSolver.solve( denominations, 2 );
        CoinSet expected = new CoinSet( 2 );
        assertEquals(expected, solution);
    }

    public void testNonSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1 2 5");
        CoinSet solution = HighestFirstSolver.solve( denominations, 4 );
        CoinSet expected = new CoinSet( 2, 2 );
        assertEquals(expected, solution);
    }

    public void testAnotherNonSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1 4 5");
        CoinSet solution = HighestFirstSolver.solve( denominations, 8 );
        CoinSet expected = new CoinSet( 1, 1, 1, 5 );
        assertEquals(expected, solution);
        assertEquals( "CoinSet<1's:3,5's:1>", solution.toString() );
    }

    public void testImpossibleCase() {
        DenominationSet denominations = DenominationSetReader.readLine("2 5");
        try {
            HighestFirstSolver.solve( denominations, 3 );
            fail();
        } catch( NoSolutionException e) {
            assertEquals( "There is no solution given the denominations DenominationSet<2,5> to give 3 cents change.",
                    e.getMessage() );            
        }
    }

}
