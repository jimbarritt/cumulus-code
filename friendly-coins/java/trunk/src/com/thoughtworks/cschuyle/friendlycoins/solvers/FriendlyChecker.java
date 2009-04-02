package com.thoughtworks.cschuyle.friendlycoins.solvers;

import com.thoughtworks.cschuyle.friendlycoins.*;
import com.thoughtworks.cschuyle.friendlycoins.exception.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.*;
import com.thoughtworks.cschuyle.util.WrappedIntegerHelpers;

public class FriendlyChecker {

    private DenominationSet denominationSet;
    private MinimumCoinCountSolver solver;

    public FriendlyChecker( DenominationSet denominationSet, MinimumCoinCountSolver solver ) {
        this.denominationSet = denominationSet;
        this.solver = solver;
    }

    public Exception checkIfFriendly( Money total ) {
        Solution solution = null;
        try {
            solution = solver.solve( total );
        } catch( Exception e) {
            return e;
        }
        if( null == solution ) {
            return new NoSolutionException( denominationSet, total );
        }
        CoinSet fewestCoinsSolution = solution.getFewestCoinsSolution();
        final CoinSet highestFirstSolution = HighestFirstSolver.solve( denominationSet, total );
        boolean isNotFriendly = isNotFriendly( fewestCoinsSolution, highestFirstSolution );
        if( isNotFriendly ) {
            return new NotFriendlyException( fewestCoinsSolution, highestFirstSolution );
        }
        return null;
    }

    private static boolean isNotFriendly( CoinSet fewestCoinsSolution, CoinSet highestFirstSolution ) {
        final Cardinality leastCoinsCount = fewestCoinsSolution.getTotalCoinCount();
        final Cardinality highestFirstCoinsCount = highestFirstSolution.getTotalCoinCount();
        return WrappedIntegerHelpers.lessThan( leastCoinsCount, highestFirstCoinsCount );
    }
}
