package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.model.*;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.solutions.factories.SolutionFactoryContainer;
import com.thoughtworks.cschuyle.WrappedIntegerHelpers;

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
            solveInternal( total );
        }
        return chart.get( total );
    }

    private void solveInternal( Money total ) {
        CoinSetCollection coinSets = new CoinSetCollection();
        for( Denomination denomination: denominations ) {
            solveForDenomination( total, coinSets, denomination );
        }
        createNewSolution( chart, total, coinSets );
    }

    private void solveForDenomination( Money total, CoinSetCollection coinSets, Denomination denomination ) {
        if( WrappedIntegerHelpers.wrap( total ).equals( denomination ) ) {
            CoinSet coinSet = new CoinSet( denomination );
            coinSets.add( coinSet );
        }
        if( denomination.lessThan( total ) ) {
            Solution partialSolution = solve( new Money( total.minus( denomination ) ) );
            mergePartialSolution( coinSets, partialSolution.getCoinSets(), denomination );
        }
    }

    private void mergePartialSolution( CoinSetCollection destinationCoinSets,
                                       CoinSetCollection partialSolution, Denomination denomination ) {
        if( null != partialSolution ) {
            CoinSetCollection coinSets = CoinSetCollection.createAugmented( partialSolution, denomination );
            destinationCoinSets.addAll( coinSets );
        }
    }
}
