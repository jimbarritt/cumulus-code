package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.solutions.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.*;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.collections.DenominationSet;

public class FriendlyChecker {

    private DenominationSet denominationSet;
    private MinimumCoinCountSolver solver;

    public FriendlyChecker( DenominationSet denominationSet, MinimumCoinCountSolver solver ) {
        this.denominationSet = denominationSet;
        this.solver = solver;
    }

    public FriendlinessResult checkIfFriendly( Money total ) {
        Solution solution = null;
        try {
            solution = solver.solve( total );
        } catch( Exception e) {
            return new ResultError( e );
        }
        if( null == solution ) {
            return new ResultNoSolution( denominationSet, total );
        }
        CoinSet fewestCoinsSolution = solution.getFewestCoinsSolution();
        final CoinSet highestFirstSolution = HighestFirstSolver.solve( denominationSet, total );
        boolean isNotFriendly = isNotFriendly( fewestCoinsSolution, highestFirstSolution );
        if( isNotFriendly ) {
            return new ResultNotFriendly( fewestCoinsSolution, highestFirstSolution );
        }
        return null;
    }

    private static boolean isNotFriendly( CoinSet fewestCoinsSolution, CoinSet highestFirstSolution ) {
        final Cardinality leastCoinsCount = fewestCoinsSolution.totalCoinCount();
        final Cardinality highestFirstCoinsCount = highestFirstSolution.totalCoinCount();
        return leastCoinsCount.lessThan( highestFirstCoinsCount );
    }
}
