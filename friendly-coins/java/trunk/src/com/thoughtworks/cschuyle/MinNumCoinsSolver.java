package com.thoughtworks.cschuyle;

import java.util.*;

class MinNumCoinsSolver {

    public MinNumCoinsSolver( DenominationSet denominations ) {
        this.denominations = denominations;
    }

    public Solution solve( Money total ) {
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
        for( Denomination denomination: denominations.getSortedList() ) {
            processDenomination(total, coinSets, denomination);
        }
        if( coinSets.size() > 0 ) {
            final Solution solution = getSolutionFactory().createSolution(coinSets);
            memoizeSolution( solution );
            return solution;
        }
        throw new NoSolutionException( denominations, total );
    }

    public Solution getMemoizedSolution( Money total ) {
        Solution ret = chart.get( total.intValue() );
        if( null == ret ) {
            throw new IllegalArgumentException( "Request for non-memoized solution for total = " + total );
        }
        return ret;
    }

    public CoinSet getFewestCoinsSolution( Money total ) {
        Solution solution = getMemoizedSolution( total );
        return solution.getFewestCoinsSolution();
    }
        
    private void processDenomination(Money total, Collection<CoinSet> coinSets, Denomination denomination) {
        if( denomination.intValue() == total.intValue() ) {
            CoinSet coinSet = CoinSet.createCoinSet( denomination );
            coinSets.add( coinSet );
            return;
        }
        if( denomination.intValue() < total.intValue() ) {
            recurse(total, coinSets, denomination);
        }
    }

    private void recurse(Money total, Collection<CoinSet> coinSets, Denomination denomination) {
        Money smallerTotal = new Money( total.intValue() - denomination.intValue() );
        Solution partialSolution = solve( smallerTotal  );
        if( null != partialSolution ) {
            mergePartialSolution( coinSets, denomination, partialSolution );
        }
    }

    private void mergePartialSolution(
            Collection<CoinSet> coinSets, Denomination denomination, Solution partialSolution) {
        for( CoinSet coinSet: partialSolution.getCoinSets() ) {
            coinSets.add( CoinSet.createAugmentedCoinSet( coinSet, denomination ) );
        }
    }

    SolutionFactory solutionFactory;

    public void setSolutionFactory( SolutionFactory solutionFactory) {
        this.solutionFactory = solutionFactory;
    }

    private SolutionFactory getSolutionFactory() {
        if( null == solutionFactory ) {
            solutionFactory = SolutionFactoryInventory.OPTIMIZED_SOLUTION_FACTORY;
        }
        return solutionFactory;
    }

    private DenominationSet denominations;

    private boolean isMemoized( Money total ) {
        return chart.containsKey( total.intValue() );
    }

    private void memoizeSolution( Solution solution ) {
        chart.put( solution.getTotal().intValue(), solution );
    }

    private Map<Integer, Solution> chart = new HashMap<Integer, Solution>();

}
