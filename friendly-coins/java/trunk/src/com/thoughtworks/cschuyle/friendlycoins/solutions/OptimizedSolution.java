package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSet;

import java.util.Collection;

class OptimizedSolution extends Solution {

    private CoinSet solution;
    
    public OptimizedSolution( Collection<CoinSet> coinSets ) {
        CoinSet theLeast = findMinimalCoinCountSolution( coinSets );
        this.solution = theLeast;
    }

    public @Override CoinSet getFewestCoinsSolution() {
        return solution;
    }

    public @Override CoinSetCollection getCoinSets() {
        final CoinSetCollection coinSets = new CoinSetCollection();
        coinSets.add( solution );
        return coinSets;
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
        final Cardinality coinSetNumCoins = coinSet.getTotalCoinCount();
        final int coinSetNumCoinsInt = coinSetNumCoins.intValue();

        final Cardinality theLeastNumCoins = theLeast.getTotalCoinCount();
        final int theLeastNumCoinsInt = theLeastNumCoins.intValue();

        if( coinSetNumCoinsInt < theLeastNumCoinsInt ) {
            return coinSet;
        }
        return theLeast;
    }
}
