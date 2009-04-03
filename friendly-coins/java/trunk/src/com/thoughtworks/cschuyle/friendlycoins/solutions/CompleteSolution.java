package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.model.*;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;
import static com.thoughtworks.cschuyle.WrappedIntegerHelpers.*;

public class CompleteSolution extends Solution {
    private CoinSetCollection coinSets;
    private Money total = new Money();

    public CompleteSolution( CoinSetCollection coinSets ) {
        this.coinSets = coinSets;
        for( CoinSet coinSet: coinSets ) {
            this.total = verifyTotalSame( coinSet, total );
        }
    }

    public @Override CoinSet getFewestCoinsSolution() {
        CoinSet leastSolution = null;
        for( CoinSet coinSet: coinSets ) {
            leastSolution = isItLess( leastSolution, coinSet );
        }
        return leastSolution;
    }

    public @Override CoinSetCollection getCoinSets() {
        return coinSets;
    }
    
    private CoinSet isItLess( CoinSet leastSolution, CoinSet coinSet ) {
        final Cardinality coinSetNumCoins = coinSet.totalCoinCount();
        final Cardinality leastSolutionNumCoins = leastSolution.totalCoinCount();
        if( null == leastSolution || coinSetNumCoins.lessThan( leastSolutionNumCoins ) ) {
            leastSolution = coinSet;
        }
        return leastSolution;
    }

    private Money verifyTotalSame( CoinSet coinSet, Money total ) {
        if( total.equals( ZERO ) ) {
            return coinSet.total();
        }
        final Money coinSetTotal = coinSet.total();
        if( ! coinSetTotal.equals( total ) ) {
            throw new IllegalStateException( "All coinSets must have the same sum" );
        }
        return coinSetTotal;
    }
}
