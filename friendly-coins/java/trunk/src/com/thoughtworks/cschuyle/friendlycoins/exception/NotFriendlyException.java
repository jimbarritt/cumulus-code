package com.thoughtworks.cschuyle.friendlycoins.exception;

import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

public class NotFriendlyException extends RuntimeException {
    public NotFriendlyException( String msg ) {
        super( msg );
    }

    public NotFriendlyException( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        super( createMessage( leastCoinsSolution, greedySolution ) );
    }

    private static String createMessage( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final Cardinality leastCoins = leastCoinsSolution.getCoinCount();
        final Cardinality greedyCoins = greedySolution.getCoinCount();
        final Money leastCoinsSolutionTotal = leastCoinsSolution.total();
        return "NOT FRIENDLY.  For " + leastCoinsSolutionTotal + " cents, highest-first gives " +
                greedySolution + " (" + greedyCoins + " coins), but change can be given in " +
                leastCoins + " coins: " + leastCoinsSolution;
    }
}
