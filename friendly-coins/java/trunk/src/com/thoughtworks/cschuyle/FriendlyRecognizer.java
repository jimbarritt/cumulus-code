package com.thoughtworks.cschuyle;

class FriendlyRecognizer {

    public boolean isFriendly( DenominationSet den, int checkUpToTotal ) {
        final MinNumCoinsSolver solver = new MinNumCoinsSolver( den );
        if( checkUpToTotal < 1) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        int total = 0;
        try {
            for( total = 1 ; total <= checkUpToTotal ; ++total ) {
                solver.solve( total );
                CoinSet leastCoinsSolution = solver.getFewestCoinsSolution( total );
                final CoinSet greedySolution = HighestFirstSolver.solve( den, total );

                boolean isNotFriendly = isNotFriendly( leastCoinsSolution, greedySolution );
                if( isNotFriendly ) {
                    throw new NotFriendlyException( leastCoinsSolution, greedySolution );
                }
            }
        } catch( Error e ) {
            System.out.println( "OOPS. Error after checking up to total=" + total);
            throw e;
        }

        return true;
    }

    public static boolean isNotFriendly( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final int leastCoins = leastCoinsSolution.getNumCoins();
        final int greedyCoins = greedySolution.getNumCoins();
        return( greedyCoins > leastCoins );
    }
}
