package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;

public class AllSolutionsSolverTest extends TestCase {


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

    public void testTrivialCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1");
        final int solveFor = 1;
        AllSolutionsSolver solver = new AllSolutionsSolver( denominations );
        solver.solve( solveFor );

        AllSolutionsSolver.Solution solution = solver.getMemoizedSolution( solveFor );

        CoinSet expected = new CoinSet( solveFor );

        final CoinSet firstCoinSet = solution.getCoinSets().iterator().next();
        assertEquals( expected, firstCoinSet );
        assertEquals( firstCoinSet, expected );
    }

    public void testTrivialCaseNegative() {
        DenominationSet denominations = DenominationSetReader.readLine("1");
        final int solveFor = 1;
        AllSolutionsSolver solver = new AllSolutionsSolver( denominations );
        solver.solve( solveFor );
        AllSolutionsSolver.Solution solution = solver.getMemoizedSolution( solveFor );
        CoinSet expected = new CoinSet( solveFor + 1 );

        final CoinSet firstCoinSet = solution.getCoinSets().iterator().next();
        assertFalse( expected.equals(firstCoinSet) );
        assertFalse( firstCoinSet.equals(expected) );
    }

    public void testSimpleCase() {
        DenominationSet denominations = DenominationSetReader.readLine("1 2");
        final int solveFor = 2;
        AllSolutionsSolver solver = new AllSolutionsSolver( denominations );
        solver.solve( solveFor );

        AllSolutionsSolver.Solution solution = solver.getMemoizedSolution( solveFor );

        CoinSetList expectedList = new CoinSetList();
        {
            CoinSet expected = new CoinSet( new Integer[] { 1, 1 } );
            expectedList.add( expected );
        }
        {
            CoinSet expected = new CoinSet( solveFor );
            expectedList.add( expected );
        }

        final Collection<CoinSet> solutionCoinSets = solution.getCoinSets();
        assertEquals( expectedList, solutionCoinSets );
        assertEquals( solutionCoinSets, expectedList );
    }

}
