package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.*;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.collections.DenominationSet;
import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.WrappedIntegerHelpers;

public class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, Money requiredTotal ) {
        if( Denomination.isEmpty( denominations ) ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        CoinSet solution = new CoinSet();

        while( null != solution && WrappedIntegerHelpers.lessThan( solution.total(), requiredTotal ) ) {
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
        final WrappedInteger addable = WrappedIntegerHelpers.minus( total, targetTotal );

        for( Denomination denomination : denominations ) {
            if( ! WrappedIntegerHelpers.greaterThan( denomination, addable ) ) {
                destinationCoinSet = CoinSet.createAugmentedCoinSet( destinationCoinSet, denomination );
                return destinationCoinSet;
            }
        }
        return null;
    }
}
