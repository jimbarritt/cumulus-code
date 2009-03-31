package com.thoughtworks.cschuyle.friendlycoins.solvers;

import com.thoughtworks.cschuyle.friendlycoins.exception.NotFriendlyException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.solvers.MinimumCoinCountSolver;
import com.thoughtworks.cschuyle.friendlycoins.solvers.HighestFirstSolver;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.CoinSet;

import java.io.PrintStream;

public class FriendlyRecognizer {

    public boolean isFriendly( DenominationSet denominationSet, Money checkUpToTotal ) {
        if( checkUpToTotal.intValue() < 1) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        Money highestFriendlyTotal = null;
        final MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominationSet );
        try {
            highestFriendlyTotal = checkUpToTotal( denominationSet, checkUpToTotal, solver );
        } catch( Error e ) {
            message( "OOPS. Error after checking up to total=" + highestFriendlyTotal );
            throw e;
        }

        return true;
    }

    private final static PrintStream cout = System.out;

    private void message( String message ) {
        cout.println( message );
    }

    public static boolean isNotFriendly( CoinSet leastCoinsSolution, CoinSet greedySolution ) {
        final Cardinality leastCoins = leastCoinsSolution.getCoinCount();
        final Cardinality greedyCoins = greedySolution.getCoinCount();
        final int iGreedy = greedyCoins.intValue();
        final int iLeast = leastCoins.intValue();
        return( iGreedy > iLeast );
    }

    private Money checkUpToTotal( DenominationSet denominationSet, Money checkUpToTotal, MinimumCoinCountSolver solver ) {
        // TODO Make an iterator for a range of Moneys.
        Money highestFriendlyTotal = null;
        final int checkUpToTotalInt = checkUpToTotal.intValue();
        for( int total = 1 ; total <= checkUpToTotalInt ; ++total ) {
            highestFriendlyTotal = checkIfFriendly( denominationSet, solver, new Money( total ) );
        }
        return highestFriendlyTotal;
    }

    private Money checkIfFriendly( DenominationSet denominationSet, MinimumCoinCountSolver solver, Money total ) {
        solver.solve( total );
        CoinSet fewestCoinsSolution = solver.getFewestCoinsSolution( total );
        final CoinSet highestFirstSolution = HighestFirstSolver.solve( denominationSet, total );
        checkAndThrowIfNotFriendly( fewestCoinsSolution, highestFirstSolution );
        return total;
    }

    private void checkAndThrowIfNotFriendly( CoinSet fewestCoinsSolution, CoinSet highestFirstSolution ) {
        boolean isNotFriendly = isNotFriendly( fewestCoinsSolution, highestFirstSolution );
        if( isNotFriendly ) {
            throw new NotFriendlyException( fewestCoinsSolution, highestFirstSolution );
        }
    }

}
