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
        CoinSet theLeast = findMinimalCoinCountSolution( coinSets );
        this.solution = theLeast;
        final Money theLeastSum = theLeast.total();
        this.total = theLeastSum;
    }

    private CoinSet findMinimalCoinCountSolution( Collection<CoinSet> coinSets ) {
        CoinSet theLeast = null;
        for( CoinSet coinSet : coinSets ) {
            theLeast = isItLess( theLeast, coinSet );
        }
        return theLeast;
    }

    private CoinSet isItLess( CoinSet theLeast, CoinSet coinSet ) {
        if( null == theLeast ) {
            return coinSet;
        }
        final Cardinality coinSetNumCoins = coinSet.getCoinCount();
        final int coinSetNumCoinsInt = coinSetNumCoins.intValue();

        final Cardinality theLeastNumCoins = theLeast.getCoinCount();
        final int theLeastNumCoinsInt = theLeastNumCoins.intValue();

        if( coinSetNumCoinsInt < theLeastNumCoinsInt ) {
            return coinSet;
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
