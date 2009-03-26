package com.thoughtworks.cschuyle;

import java.util.List;

class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, Money total ) {
        if( null == denominations || 0 == denominations.size() ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        final List<Denomination> ordered = denominations.getSortedList();
        CoinSet ret = CoinSet.createCoinSet();
        while( ret.sum().intValue() < total.intValue() ) {
            ret = accumulateHighestPossibleValue( denominations, total, ordered, ret );
        }
        if( ! total.equals( ret.sum() ) ) {
            throw new IllegalStateException( "Internal Error" );
        }
        return ret;
    }

    private static CoinSet accumulateHighestPossibleValue(
            DenominationSet denominations, Money total, List<Denomination> ordered, CoinSet ret) {
        int index = ordered.size() - 1;
        while( index >= 0 && ordered.get(index).intValue() > total.intValue() - ret.sum().intValue() ) {
            --index;
        }
        if( index < 0 ) {
            throw new NoSolutionException( denominations, total );
        }
        final Denomination toAdd = ordered.get(index);
        ret = CoinSet.createAugmentedCoinSet( ret, toAdd );
        return ret;
    }

}
