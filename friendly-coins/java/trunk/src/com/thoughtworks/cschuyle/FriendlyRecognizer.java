package com.thoughtworks.cschuyle;

public class FriendlyRecognizer {

    public boolean isFriendly( DenominationSet den, Money checkUpToTotal ) {
        if( checkUpToTotal.intValue() < 1) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        Money highestFriendlyTotal = null;
        final MinNumCoinsSolver solver = new MinNumCoinsSolver( den );
        try {
            highestFriendlyTotal = checkUpToTotal( den, checkUpToTotal, solver );
        } catch( Error e ) {
            System.out.println( "OOPS. Error after checking up to total=" + highestFriendlyTotal);
            throw e;
        }

        return true;
    }

    public static boolean isNotFriendly( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final Cardinality leastCoins = leastCoinsSolution.getNumCoins();
        final Cardinality greedyCoins = greedySolution.getNumCoins();
        return( greedyCoins.intValue() > leastCoins.intValue() );
    }

    private Money checkUpToTotal( DenominationSet den, Money checkUpToTotal, MinNumCoinsSolver solver ) {
        // TODO Make an iterator for a range of Moneys.
        Money highestFriendlyTotal = null;
        for( int total = 1 ; total <= checkUpToTotal.intValue() ; ++total ) {
            highestFriendlyTotal = checkIfFriendly(den, solver, new Money( total ) );
        }
        return highestFriendlyTotal;
    }

    private Money checkIfFriendly(DenominationSet den, MinNumCoinsSolver solver, Money total) {
        solver.solve( total );
        CoinSet leastCoinsSolution = solver.getFewestCoinsSolution( total );
        final CoinSet greedySolution = HighestFirstSolver.solve( den, total );
        checkAndThrowIfNotFriendly( leastCoinsSolution, greedySolution );
        return total;
    }

    private void checkAndThrowIfNotFriendly(CoinSet leastCoinsSolution, CoinSet greedySolution) {
        boolean isNotFriendly = isNotFriendly( leastCoinsSolution, greedySolution );
        if( isNotFriendly ) {
            throw new NotFriendlyException( leastCoinsSolution, greedySolution );
        }
    }

}
