package com.thoughtworks.cschuyle.friendlycoins.exception;

import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

public class NotFriendlyException extends RuntimeException {
    public NotFriendlyException( String msg ) {
        super( msg );
    }

    public NotFriendlyException( CoinSet fewestCoinsSolution, CoinSet highestFirstSolution ) {
        super( createMessage( fewestCoinsSolution, highestFirstSolution ) );
    }

    private static String createMessage( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final Cardinality leastCoins = leastCoinsSolution.getTotalCoinCount();
        final Cardinality greedyCoins = greedySolution.getTotalCoinCount();
        final Money leastCoinsSolutionTotal = leastCoinsSolution.total();
        return "NOT FRIENDLY.  For " + leastCoinsSolutionTotal + " cents, highest-first gives " +
                greedySolution + " (" + greedyCoins + " coins), but change can be given in " +
                leastCoins + " coins: " + leastCoinsSolution;
    }
}
