package com.thoughtworks.cschuyle;

import java.util.List;

import static com.thoughtworks.cschuyle.WrappedInteger.*;

class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, Money total ) {
        if( Denomination.isEmpty( denominations ) ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        final List<Denomination> ordered = denominations.getSortedList();
        CoinSet ret = CoinSet.createCoinSet();

        while( lessThan( ret.sum(), total ) ) {
            ret = accumulateHighestPossibleValue( denominations, total, ordered, ret );
        }
        final Money retTotal = ret.sum();
        if( ! total.equals(retTotal) ) {
            throw new IllegalStateException( "Internal Error" );
        }
        return ret;
    }

    private static CoinSet accumulateHighestPossibleValue(
            DenominationSet denominations, Money total, List<Denomination> ordered, CoinSet target ) {
        final Money targetTotal = target.sum();
        final WrappedInteger maxAddable = minus( total, targetTotal );
        int index = ordered.size() - 1;
        while( index >= 0 && greaterThan( ordered.get( index ), maxAddable) ) {
            --index;
        }
        if( index < 0 ) {
            throw new NoSolutionException( denominations, total );
        }
        final Denomination toAdd = ordered.get( index );
        target = CoinSet.createAugmentedCoinSet( target, toAdd );
        return target;
    }

}
