package com.thoughtworks.cschuyle.friendlycoins.solvers;

import java.util.List;

import static com.thoughtworks.cschuyle.WrappedInteger.*;
import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.WrappedInteger;

class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, Money requiredTotal ) {
        if( Denomination.isEmpty( denominations ) ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        final List<Denomination> orderedDenominations = denominations.getOrderedList();
        CoinSet solution = CoinSet.createCoinSet();

        while( lessThan( solution.total(), requiredTotal ) ) {
            solution = accumulateHighestPossibleValue( denominations, requiredTotal, orderedDenominations, solution );
        }
        final Money solutionTotal = solution.total();
        if( ! requiredTotal.equals( solutionTotal ) ) {
            throw new IllegalStateException( "Internal Error" );
        }
        return solution;
    }

    // TODO Wow, what a load of code to do one simple thing.  Could use major refactoring - most of this in orderedDenominations
    private static CoinSet accumulateHighestPossibleValue(
            DenominationSet denominations, Money total, List<Denomination> orderedDenominations, CoinSet destinationCoinSet ) {
        final Money targetTotal = destinationCoinSet.total();
        final WrappedInteger addable = minus( total, targetTotal );
        int index = orderedDenominations.size() - 1;
        while( index >= 0 && greaterThan( orderedDenominations.get( index ), addable) ) {
            --index;
        }
        if( index < 0 ) {
            throw new NoSolutionException( denominations, total );
        }
        final Denomination toAdd = orderedDenominations.get( index );
        destinationCoinSet = CoinSet.createAugmentedCoinSet( destinationCoinSet, toAdd );
        return destinationCoinSet;
    }

}
