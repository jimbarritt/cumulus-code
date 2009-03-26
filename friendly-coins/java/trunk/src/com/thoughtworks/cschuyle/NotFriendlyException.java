package com.thoughtworks.cschuyle;

public class NotFriendlyException extends RuntimeException {
    public NotFriendlyException( String msg ) {
        super( msg );
    }

    public NotFriendlyException( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        super( createMessage( leastCoinsSolution, greedySolution ) );
    }

    private static String createMessage(CoinSet leastCoinsSolution, CoinSet greedySolution) {
        final Cardinality leastCoins = leastCoinsSolution.getNumCoins();
        final Cardinality greedyCoins = greedySolution.getNumCoins();
        return "NOT FRIENDLY.  For " + leastCoinsSolution.sum() + " cents, highest-first gives " +
                greedySolution + " (" + greedyCoins + " coins), but change can be given in " +
                leastCoins + " coins: " + leastCoinsSolution;
    }
}
