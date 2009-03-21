package com.thoughtworks.cschuyle;

import java.util.*;

class MinNumCoinsSolver {

    public MinNumCoinsSolver( DenominationSet denominations ) {
        this.denominations = denominations;
    }

    public Solution solve( int total ) {
        /*
        solve(x):
            if x is a solution
                return
            for all den
                if x == den
                    den is a solution
                else if solve x-den
                    partial solution + den is a solution


        more than one solution for a given x arises out of the for loop
        */
        if( isMemoized( total ) ) {
            return getMemoizedSolution( total );
        }
        Collection<CoinSet> coinSets = new ArrayList<CoinSet>();
        for( int denomination: denominations.getSortedList() ) {
            processDenomination(total, coinSets, denomination);
        }
        if( coinSets.size() > 0 ) {
            final Solution solution = getSolutionFactory().createSolution(coinSets);
            memoizeSolution( solution );
            return solution;
        }
        throw new NoSolutionException( denominations, total );
    }

    public Solution getMemoizedSolution( int total ) {
        Solution ret = chart.get( total );
        if( null == ret ) {
            throw new IllegalArgumentException( "Request for non-memoized solution for total = " + total );
        }
        return ret;
    }

    public CoinSet getFewestCoinsSolution( int total ) {
        Solution solution = getMemoizedSolution( total );
        return solution.getFewestCoinsSolution();
    }
        
    private void processDenomination(int total, Collection<CoinSet> coinSets, int denomination) {
        if( denomination == total ) {
            CoinSet coinSet = CoinSet.createCoinSet( denomination );
            coinSets.add( coinSet );
        } else if( denomination < total ) {
            recurse(total, coinSets, denomination);
        }
    }

    private void recurse(int total, Collection<CoinSet> coinSets, int denomination) {
        solve( total - denomination );
        if( isMemoized( total - denomination )) {
            Solution partialSolution = getMemoizedSolution( total - denomination );
            mergePartialSolution(coinSets, denomination, partialSolution);
        }
    }

    private void mergePartialSolution(Collection<CoinSet> coinSets, int denomination, Solution partialSolution) {
        for( CoinSet coinSet: partialSolution.getCoinSets() ) {
            coinSets.add( CoinSet.createAugmentedCoinSet( coinSet, denomination ) );
        }
    }

    SolutionFactory solutionFactory;

    private SolutionFactory getSolutionFactory() {
        if( null == solutionFactory ) {
            solutionFactory = SolutionFactoryInventory.OPTIMIZED_SOLUTION_FACTORY;
        }
        return solutionFactory;
    }

    private DenominationSet denominations;

    private boolean isMemoized( int total ) {
        return chart.containsKey( total );
    }

    private void memoizeSolution( Solution solution ) {
        chart.put( solution.getTotal(), solution );
    }

    private Map<Integer, Solution> chart = new HashMap<Integer, Solution>();

}
