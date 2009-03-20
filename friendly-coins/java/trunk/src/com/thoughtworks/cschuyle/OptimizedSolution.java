package com.thoughtworks.cschuyle;

import java.util.Collection;
import java.util.ArrayList;

class OptimizedSolution extends Solution {

    int total;
    public @Override int getTotal() {
        return total;
    }

    public OptimizedSolution(Collection<CoinSet> coinSets) {
        super();
        CoinSet theLeast = null;
        for( CoinSet coinSet : coinSets ) {
            if( null == theLeast || coinSet.getNumCoins() < theLeast.getNumCoins() ) {
                theLeast = coinSet;
            }
        }
        this.solution = theLeast;
        this.total = theLeast.sum();
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