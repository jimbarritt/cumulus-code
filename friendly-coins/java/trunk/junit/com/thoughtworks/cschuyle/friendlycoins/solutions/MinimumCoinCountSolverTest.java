package com.thoughtworks.cschuyle.friendlycoins.solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;

import static com.thoughtworks.cschuyle.friendlycoins.solutions.factories.SolutionFactories.*;
import com.thoughtworks.cschuyle.friendlycoins.solutions.factories.SolutionFactory;
import com.thoughtworks.cschuyle.friendlycoins.model.*;
import com.thoughtworks.cschuyle.friendlycoins.application.DenominationSetReader;

import static com.thoughtworks.cschuyle.friendlycoins.TestConstants.*;

public class MinimumCoinCountSolverTest extends TestCase {


    static class CoinSetList extends ArrayList<CoinSet> {
        public @Override boolean equals( Object rhsObj ) {
            if( null == rhsObj ) {
                return false;
            }
            if( this == rhsObj ) {
                return true;
            }
            Iterable<CoinSet> rhs = null;
            try {
                rhs = (Iterable<CoinSet>)rhsObj;
            } catch( ClassCastException e ) {
                return false;
            }
            int size = 0;
            for( CoinSet coinSet: rhs ) {
                size++;
                if( ! this.contains( coinSet ) ) {
                    return false;
                }
            }
            return( this.size() == size );
        }

        // ArrayList contains() appears to NOT use iterator().  So I have to override it here.
        public @Override boolean contains( Object rhsObj ) {
            if( null == rhsObj ) {
                return false;
            }
            if( this == rhsObj ) {
                return true;
            }
            for(CoinSet coinSet: this) {
                if( coinSet.equals( rhsObj )) {
                    return true;
                }
            }
            return false;
        }
    }

    public void testTrivialCase_OPTIMIZED() {
        testTrivialCase( OPTIMIZED_SOLUTION_FACTORY );
    }
    public void testTrivialCase_COMPLETE() {
        testTrivialCase( COMPLETE_SOLUTION_FACTORY );
    }

    private void testTrivialCase( SolutionFactory solutionFactory ) {
        DenominationSet denominations = DenominationSetReader.readLine( "1" );
        MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominations );
        solver.setSolutionFactory( solutionFactory );
        Solution solution = solver.solve(ONE_CENT);

        CoinSet expected = new CoinSet(ONER);

        final CoinSetCollection solutionCoinSets = solution.getCoinSets();
        final Iterator<CoinSet> iterator = solutionCoinSets.iterator();
        final CoinSet firstCoinSet = iterator.next();
        assertEquals( expected, firstCoinSet );
        assertEquals( firstCoinSet, expected );
    }

    public void testTrivialCaseNegative_OPTIMIZED() {
        testTrivialCaseNegative( OPTIMIZED_SOLUTION_FACTORY );
    }
    public void testTrivialCaseNegative_COMPLETE() {
        testTrivialCaseNegative( COMPLETE_SOLUTION_FACTORY );
    }

    private void testTrivialCaseNegative( SolutionFactory solutionFactory ) {
        DenominationSet denominations = DenominationSetReader.readLine( "1" );
        MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominations );
        solver.setSolutionFactory( solutionFactory );
        Solution solution = solver.solve(ONE_CENT);
        CoinSet expected = new CoinSet(TWOER);

        final CoinSetCollection solutionCoinSets = solution.getCoinSets();
        final Iterator<CoinSet> iterator = solutionCoinSets.iterator();
        final CoinSet firstCoinSet = iterator.next();
        assertFalse( expected.equals( firstCoinSet ) );
        assertFalse( firstCoinSet.equals( expected ) );
    }

    public void testDuplicateCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 2" );
        MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominations );
        solver.setSolutionFactory( COMPLETE_SOLUTION_FACTORY );
        Solution solution = solver.solve(THREE_CENTS);

        CoinSetCollection expectedList = new CoinSetCollection();
        {
            CoinSet expected = new CoinSet(ONER, ONER, ONER);
            expectedList.add( expected );
        }
        {
            CoinSet expected = new CoinSet(ONER, TWOER);
            expectedList.add( expected );
        }

        final CoinSetCollection solutionCoinSets = solution.getCoinSets();
        assertEquals( expectedList, solutionCoinSets );
        assertEquals( solutionCoinSets, expectedList );
    }

    // Can only use complete; optimized throws some away ...
    public void testMultipleSolutionCase() {
        DenominationSet denominations = DenominationSetReader.readLine( "1 2" );
        MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominations );
        solver.setSolutionFactory( COMPLETE_SOLUTION_FACTORY );
        Solution solution = solver.solve(TWO_CENTS);

        CoinSetCollection expectedList = new CoinSetCollection();
        {
            CoinSet expected = new CoinSet(TWOER);
            expectedList.add( expected );
        }
        {
            CoinSet expected = new CoinSet(ONER, ONER);
            expectedList.add( expected );
        }

        final CoinSetCollection solutionCoinSets = solution.getCoinSets();
        assertEquals( expectedList, solutionCoinSets );
        assertEquals( solutionCoinSets, expectedList );
    }

}
