package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

class CompleteSolution extends Solution {

    private CoinSetCollection coinSets;
    private Money total = new Money();

    public @Override CoinSet getFewestCoinsSolution() {
        CoinSet leastSolution = null;
        for( CoinSet coinSet: coinSets ) {
            leastSolution = isItLess( leastSolution, coinSet );
        }
        return leastSolution;
    }

    public CompleteSolution( CoinSetCollection coinSets ) {
        this.coinSets = coinSets;
        for( CoinSet coinSet: coinSets ) {
            accumulateTotal( coinSet );
        }
    }    

    public @Override CoinSetCollection getCoinSets() {
        return coinSets;
    }
    
    private CoinSet isItLess( CoinSet leastSolution, CoinSet coinSet ) {
        final Cardinality coinSetNumCoins = coinSet.getTotalCoinCount();
        final Cardinality leastSolutionNumCoins = leastSolution.getTotalCoinCount();
        if( null == leastSolution || coinSetNumCoins.compareTo( leastSolutionNumCoins ) == -1) {
            leastSolution = coinSet;
        }
        return leastSolution;
    }

    private void accumulateTotal( CoinSet coinSet ) {
        if( 0 == total.intValue() ) {
            total = coinSet.total();
            return;
        }
        final Money coinSetSum = coinSet.total();
        if( ! coinSetSum.equals( total ) ) {
            throw new IllegalStateException( "All coinSets must have the same sum" );
        }
    }
}
