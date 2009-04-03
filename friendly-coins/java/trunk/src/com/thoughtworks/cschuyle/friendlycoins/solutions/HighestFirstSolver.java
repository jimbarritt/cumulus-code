package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.model.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.model.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;
import com.thoughtworks.cschuyle.WrappedInteger;

public class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, Money requiredTotal ) {
        if( Denomination.isEmpty( denominations ) ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        CoinSet solution = new CoinSet();

        while( null != solution && solution.total().lessThan( requiredTotal ) ) {
            solution = accumulateHighestPossibleValue( denominations, requiredTotal, solution );
        }
        if( null == solution ) {
            throw new NoSolutionException( denominations, requiredTotal );
        }
        final Money solutionTotal = solution.total();
        if( ! requiredTotal.equals( solutionTotal ) ) {
            throw new IllegalStateException( "Internal Error" );
        }
        return solution;
    }

    private static CoinSet accumulateHighestPossibleValue(
            DenominationSet denominations, Money total, CoinSet destinationCoinSet ) {
        final Money targetTotal = destinationCoinSet.total();
        final WrappedInteger addable = total.minus( targetTotal );

        for( Denomination denomination : denominations ) {
            if( ! denomination.greaterThan( addable ) ) {
                destinationCoinSet = CoinSet.createAugmentedCoinSet( destinationCoinSet, denomination );
                return destinationCoinSet;
            }
        }
        return null;
    }
}
