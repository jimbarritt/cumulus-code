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
        final List<Denomination> sortedDenominations = denominations.getSortedList();
        for( Denomination denomination: sortedDenominations) {
            processDenomination( total, coinSets, denomination );
        }
        if( coinSets.size() > 0 ) {
            final SolutionFactory solutionFactory = getSolutionFactory();
            final Solution solution = solutionFactory.createSolution( coinSets );
            memoizeSolution( solution );
            return solution;
        }
        throw new NoSolutionException( denominations, total );
    }

    public Solution getMemoizedSolution( Money total ) {
        Solution ret = getPossiblyNullSolution( total );
        if( null == ret ) {
            throw new IllegalArgumentException( "Request for non-memoized solution for total = " + total );
        }
        return ret;
    }

    private Solution getPossiblyNullSolution( Money total ) {
        final int totalInt = total.intValue();
        return chart.get( totalInt );
    }

    public CoinSet getFewestCoinsSolution( Money total ) {
        Solution solution = getMemoizedSolution( total );
        return solution.getFewestCoinsSolution();
    }
        
    private void processDenomination( Money total, Collection<CoinSet> coinSets, Denomination denomination ) {
        final int denominationInt = denomination.intValue();
        final int totalInt = total.intValue();
        if( denominationInt == totalInt ) {
            CoinSet coinSet = CoinSet.createCoinSet( denomination );
            coinSets.add( coinSet );
            return;
        }
        if( denominationInt < totalInt ) {
            recurse( total, coinSets, denomination );
        }
    }

    private void recurse( Money total, Collection<CoinSet> coinSets, Denomination denomination ) {
        final int totalInt = total.intValue();
        final int denominationInt = denomination.intValue();
        Money smallerTotal = new Money( totalInt - denominationInt );
        Solution partialSolution = solve( smallerTotal  );
        if( null != partialSolution ) {
            mergePartialSolution( coinSets, denomination, partialSolution );
        }
    }

    private void mergePartialSolution(
            Collection<CoinSet> coinSets, Denomination denomination, Solution partialSolution ) {
        final Collection<CoinSet> partialSolutionCoinSets = partialSolution.getCoinSets();
        for( CoinSet coinSet: partialSolutionCoinSets) {
            final CoinSet augmentedCoinSet = CoinSet.createAugmentedCoinSet( coinSet, denomination );
            coinSets.add( augmentedCoinSet );
        }
    }

    SolutionFactory solutionFactory;

    public void setSolutionFactory( SolutionFactory solutionFactory ) {
        this.solutionFactory = solutionFactory;
    }

    private SolutionFactory getSolutionFactory() {
        if( null != solutionFactory ) {
            return solutionFactory;
        }
        return SolutionFactoryInventory.OPTIMIZED_SOLUTION_FACTORY;
    }

    private DenominationSet denominations;

    private boolean isMemoized( Money total ) {
        return chart.containsKey( total.intValue() );
    }

    private void memoizeSolution( Solution solution ) {
        final Money solutionTotal = solution.getTotal();
        final int solutionTotalInt = solutionTotal.intValue();
        chart.put( solutionTotalInt, solution );
    }

    private Map<Integer, Solution> chart = new HashMap<Integer, Solution>();

}
