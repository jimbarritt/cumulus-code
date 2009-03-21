package com.thoughtworks.cschuyle;

public class FriendlyRecognizer {

    public boolean isFriendly( DenominationSet den, int checkUpToTotal ) {
        final MinNumCoinsSolver solver = new MinNumCoinsSolver( den );
        if( checkUpToTotal < 1) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        int highestCheckedValue = 0;
        try {
            highestCheckedValue = checkUpToTotal(den, checkUpToTotal, solver, highestCheckedValue);
        } catch( Error e ) {
            System.out.println( "OOPS. Error after checking up to total=" + highestCheckedValue);
            throw e;
        }

        return true;
    }

    public static boolean isNotFriendly( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final int leastCoins = leastCoinsSolution.getNumCoins();
        final int greedyCoins = greedySolution.getNumCoins();
        return( greedyCoins > leastCoins );
    }

    private int checkUpToTotal(DenominationSet den, int checkUpToTotal, MinNumCoinsSolver solver, int total) {
        for( total = 1 ; total <= checkUpToTotal ; ++total ) {
            solver.solve( total );
            CoinSet leastCoinsSolution = solver.getFewestCoinsSolution( total );
            final CoinSet greedySolution = HighestFirstSolver.solve( den, total );
            checkAndThrowIfnotFriendly(leastCoinsSolution, greedySolution);
        }
        return total;
    }

    private void checkAndThrowIfnotFriendly(CoinSet leastCoinsSolution, CoinSet greedySolution) {
        boolean isNotFriendly = isNotFriendly( leastCoinsSolution, greedySolution );
        if( isNotFriendly ) {
            throw new NotFriendlyException( leastCoinsSolution, greedySolution );
        }
    }

}
