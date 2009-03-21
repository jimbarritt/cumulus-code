package com.thoughtworks.cschuyle;

import java.util.Collection;

class CompleteSolution extends Solution {

    private Collection<CoinSet> coinSets;
    private int total;

    public @Override int getTotal() {
        return total;
    }

    public @Override CoinSet getFewestCoinsSolution() {
        CoinSet leastSolution = null;

        for( CoinSet coinSet: coinSets ) {
            leastSolution = isItLess( leastSolution, coinSet );
        }
        return leastSolution;
    }

    public CompleteSolution( Collection<CoinSet> coinSets ) {
        super();
        this.coinSets = coinSets;
        for( CoinSet coinSet: coinSets ) {
            accumulateTotal(coinSet);
        }
    }    

    protected Collection<CoinSet> getCoinSets() {
        return coinSets;
    }
    
    private CoinSet isItLess(CoinSet leastSolution, CoinSet coinSet) {
        if( null == leastSolution || coinSet.getNumCoins() < leastSolution.getNumCoins() ) {
            leastSolution = coinSet;
        }
        return leastSolution;
    }

    private void accumulateTotal(CoinSet coinSet) {
        if( 0 == total ) {
            total = coinSet.sum();
        } else if( coinSet.sum() != total ) {
            throw new IllegalStateException( "All coinSets must have the same sum" );
        }
    }

}
