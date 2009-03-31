package com.thoughtworks.cschuyle;

import java.util.Collection;

class CompleteSolution extends Solution {

    private Collection<CoinSet> coinSets;
    private Money total = new Money();

    public @Override Money getTotal() {
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
            accumulateTotal( coinSet );
        }
    }    

    protected Collection<CoinSet> getCoinSets() {
        return coinSets;
    }
    
    private CoinSet isItLess( CoinSet leastSolution, CoinSet coinSet ) {
        final Cardinality coinSetNumCoins = coinSet.getCoinCount();
        final Cardinality leastSolutionNumCoins = leastSolution.getCoinCount();
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
