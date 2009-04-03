package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.model.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;

public class ResultNotFriendly extends FriendlinessResult {

    public ResultNotFriendly( String theMessage ) {
        super(theMessage);
    }

    public ResultNotFriendly( CoinSet fewestCoinsSolution, CoinSet highestFirstSolution ) {
        this( createMessage( fewestCoinsSolution, highestFirstSolution ) );
    }

    public @Override boolean isFriendly() {
        return false;
    }

    private static String createMessage( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final Cardinality leastCoins = leastCoinsSolution.totalCoinCount();
        final Cardinality greedyCoins = greedySolution.totalCoinCount();
        final Money leastCoinsSolutionTotal = leastCoinsSolution.total();
        return "NOT FRIENDLY.  For " + leastCoinsSolutionTotal + " cents, highest-first gives " +
                greedySolution + " (" + greedyCoins + " coins), but change can be given in " +
                leastCoins + " coins: " + leastCoinsSolution;
    }
}
