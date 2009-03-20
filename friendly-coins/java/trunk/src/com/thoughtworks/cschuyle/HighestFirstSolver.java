package com.thoughtworks.cschuyle;

import java.util.List;

class HighestFirstSolver {

    private HighestFirstSolver() {}
    
    public static CoinSet solve( DenominationSet denominations, int total ) {
        if( null == denominations || 0 == denominations.size() ) {
            throw new NoSolutionException( "No solution - empty denominations set" );
        }
        final List<Integer> ordered = denominations.getSortedList();
        CoinSet ret = CoinSet.createCoinSet();
        while( ret.sum() < total) {
            int index = ordered.size() - 1;
            while( index >= 0 && ordered.get(index) > total - ret.sum()) {
                --index;
            }
            if( index < 0 ) {
                throw new NoSolutionException( denominations, total );
            }
            final Integer toAdd = ordered.get(index);
            ret = CoinSet.createAugmentedCoinSet( ret, toAdd );
        }
        if( total != ret.sum() ) {
            throw new IllegalStateException( "Internal Error" );
        }
        return ret;
    }
    
}
