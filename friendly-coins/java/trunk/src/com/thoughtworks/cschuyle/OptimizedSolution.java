package com.thoughtworks.cschuyle;

import java.util.Collection;
import java.util.ArrayList;

class OptimizedSolution extends Solution {

    Money total = new Money();

    public @Override Money getTotal() {
        return total;
    }

    public OptimizedSolution(Collection<CoinSet> coinSets) {
        super();
        CoinSet theLeast = findMinimalCoinCountSolution(coinSets);
        this.solution = theLeast;
        this.total = theLeast.sum();
    }

    private CoinSet findMinimalCoinCountSolution(Collection<CoinSet> coinSets) {
        CoinSet theLeast = null;
        for( CoinSet coinSet : coinSets ) {
            theLeast = isItLess( theLeast, coinSet );
        }
        return theLeast;
    }

    private CoinSet isItLess(CoinSet theLeast, CoinSet coinSet) {
        if( null == theLeast || coinSet.getNumCoins().intValue() < theLeast.getNumCoins().intValue() ) {
            theLeast = coinSet;
        }
        return theLeast;
    }

    CoinSet solution;

    public @Override CoinSet getFewestCoinsSolution() {
        return solution;
    }

    protected Collection<CoinSet> getCoinSets() {
        final ArrayList<CoinSet> ret = new ArrayList<CoinSet>();
        ret.add( solution );
        return ret;
    }
}
