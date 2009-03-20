package com.thoughtworks.cschuyle;

import java.util.Collection;

class CompleteSolution extends Solution {

    Collection<CoinSet> coinSets;
    int total;

    public @Override int getTotal() {
        return total;
    }

    public @Override CoinSet getFewestCoinsSolution() {
        CoinSet leastSolution = null;

        // TODO There must be an algorithm for this
        for( CoinSet coinSet: coinSets) {
            if( null == leastSolution || coinSet.getNumCoins() < leastSolution.getNumCoins() ) {
                leastSolution = coinSet;
            }
        }
        return leastSolution;
    }

    public CompleteSolution( Collection<CoinSet> coinSets ) {
        super();
        this.coinSets = coinSets;
        for( CoinSet coinSet: coinSets ) {
            if( 0 == total ) {
                total = coinSet.sum();
            } else {
                if( coinSet.sum() != total ) {
                    throw new IllegalStateException( "All coinSets must have the same sum" );
                }
            }
        }
    }

    protected Collection<CoinSet> getCoinSets() {
        return coinSets;
    }

}
