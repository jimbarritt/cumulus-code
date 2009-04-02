package com.thoughtworks.cschuyle.friendlycoins.solvers;

import static com.thoughtworks.cschuyle.util.WrappedIntegerHelpers.*;
import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.WrappedInteger;

public class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, Money requiredTotal ) {
        if( Denomination.isEmpty( denominations ) ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        CoinSet solution = CoinSet.createCoinSet();

        while( lessThan( solution.total(), requiredTotal ) ) {
            solution = accumulateHighestPossibleValue( denominations, requiredTotal, solution );
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
        final WrappedInteger addable = minus( total, targetTotal );

        for( Denomination denomination : denominations ) {
            if( ! greaterThan( denomination, addable ) ) {
                destinationCoinSet = CoinSet.createAugmentedCoinSet( destinationCoinSet, denomination );
                return destinationCoinSet;
            }
        }
        throw new NoSolutionException( denominations, total );
    }
}
