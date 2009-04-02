package com.thoughtworks.cschuyle.friendlycoins.solvers;

import com.thoughtworks.cschuyle.friendlycoins.primitives.*;
import com.thoughtworks.cschuyle.friendlycoins.*;
import com.thoughtworks.cschuyle.util.WrappedIntegerHelpers;

public class MinimumCoinCountSolver extends SolutionFactoryContainer {

    private SolutionChart chart = new SolutionChart();
    private DenominationSet denominations;

    public MinimumCoinCountSolver( DenominationSet denominations ) {
        this.denominations = denominations;
    }

        /* solve(x):
             if x is a solution
                return
             for all den
                if x == den
                    den is a solution
                else if solve x-den
                    partial solution + den is a solution
        */

    public Solution solve( Money total ) {
        if( null == chart.get( total ) ) {
            solveInternal(total);
        }
        return chart.get( total );
    }

    private void solveInternal( Money total ) {
        CoinSetCollection coinSets = new CoinSetCollection();
        for( Denomination denomination: denominations ) {
            solveForDenomination( total, coinSets, denomination );
        }
        if( coinSets.size() > 0 ) {
            Solution solution = createSolution( coinSets );
            chart.put( total, solution );
        }
    }

    private void solveForDenomination( Money total, CoinSetCollection coinSets, Denomination denomination ) {
        if( WrappedIntegerHelpers.areEqual( total, denomination ) ) {
            CoinSet coinSet = new CoinSet( denomination );
            coinSets.add( coinSet );
        }
        if( WrappedIntegerHelpers.lessThan( denomination, total ) ) {
            Solution partialSolution = solve( new Money( WrappedIntegerHelpers.minus( total, denomination ) ) );
            mergePartialSolution( coinSets, partialSolution.getCoinSets(), denomination );
        }
    }

    private void mergePartialSolution( CoinSetCollection destinationCoinSets, CoinSetCollection partialSolution, Denomination denomination ) {
        if( null != partialSolution ) {
            CoinSetCollection coinSets = CoinSetCollection.createAugmented( partialSolution, denomination );
            destinationCoinSets.addAll( coinSets );
        }
    }
}
