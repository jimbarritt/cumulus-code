package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;

public class MinNumCoinsSolverTest extends TestCase {


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
            } catch(ClassCastException e) {
                return false;
            }
            int size = 0;
            for(CoinSet coinSet: rhs) {
                size++;
                if( ! this.contains( coinSet )) {
                    return false;
                }
            }
            return(this.size() == size);
        }

        // ArrayList contains() appears to NOT use iterator().  So I have to override it here.
        public @Override boolean contains( Object rhsObj ) {
            if( null == rhsObj ) {
                return false;
            }
            if( this == rhsObj ) {
                return true;
            }
            CoinSet rhs = (CoinSet)rhsObj;
            for(CoinSet coinSet: this) {
                if( coinSet.equals( rhsObj )) {
                    return true;
                }
            }
            return false;
        }
    }

    final static SolutionFactory COMPLETE_SOLUTION_FACTORY = new SolutionFactory() {

        public Solution createSolution(Collection<CoinSet> coinSets) {
            return new CompleteSolution(coinSets);
        }
    };

    final static SolutionFactory OPTIMIZED_SOLUTION_FACTORY = new SolutionFactory() {

        public Solution createSolution(Collection<CoinSet> coinSets) {
            return new OptimizedSolution(coinSets);
        }
    };


    public void testTrivialCase_OPTIMIZED() {
        testTrivialCase( OPTIMIZED_SOLUTION_FACTORY );
    }
    public void testTrivialCase_COMPLETE() {
        testTrivialCase( COMPLETE_SOLUTION_FACTORY );
    }

    private void testTrivialCase( SolutionFactory solutionFactory) {
        DenominationSet denominations = DenominationSetReader.readLine("1");
        final int solveFor = 1;
        MinNumCoinsSolver solver = new MinNumCoinsSolver( denominations );
        solver.solutionFactory = solutionFactory;
        solver.solve( solveFor );

        Solution solution = solver.getMemoizedSolution( solveFor );

        CoinSet expected = CoinSet.createCoinSet( solveFor );

        final CoinSet firstCoinSet = solution.getCoinSets().iterator().next();
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
        DenominationSet denominations = DenominationSetReader.readLine("1");
        final int solveFor = 1;
        MinNumCoinsSolver solver = new MinNumCoinsSolver( denominations );
        solver.solutionFactory = solutionFactory;
        solver.solve( solveFor );
        Solution solution = solver.getMemoizedSolution( solveFor );
        CoinSet expected = CoinSet.createCoinSet( solveFor + 1 );

        final CoinSet firstCoinSet = solution.getCoinSets().iterator().next();
        assertFalse( expected.equals(firstCoinSet) );
        assertFalse( firstCoinSet.equals(expected) );
    }

    // Can only use complete; optimized throws some away ...
    public void testMultipleSolutionCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1 2");
        final int solveFor = 2;
        MinNumCoinsSolver solver = new MinNumCoinsSolver( denominations );
        solver.solutionFactory = COMPLETE_SOLUTION_FACTORY;
        solver.solve( solveFor );

        Solution solution = solver.getMemoizedSolution( solveFor );

        CoinSetList expectedList = new CoinSetList();
        {
            CoinSet expected = CoinSet.createCoinSet( new Integer[] { 1, 1 } );
            expectedList.add( expected );
        }
        {
            CoinSet expected = CoinSet.createCoinSet( solveFor );
            expectedList.add( expected );
        }

        final Collection<CoinSet> solutionCoinSets = solution.getCoinSets();
        assertEquals( expectedList, solutionCoinSets );
        assertEquals( solutionCoinSets, expectedList );
    }

}
