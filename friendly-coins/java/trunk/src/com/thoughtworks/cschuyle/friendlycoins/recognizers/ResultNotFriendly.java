package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

public class ResultNotFriendly extends FriendlinessResult {

    public ResultNotFriendly( String theMessage ) {
        super(theMessage);
    }

    public boolean isFriendly() {
        return false;
    }

    public ResultNotFriendly( CoinSet fewestCoinsSolution, CoinSet highestFirstSolution ) {
        this( createMessage( fewestCoinsSolution, highestFirstSolution ) );
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
