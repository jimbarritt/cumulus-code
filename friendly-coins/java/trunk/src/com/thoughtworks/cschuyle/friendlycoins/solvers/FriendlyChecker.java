package com.thoughtworks.cschuyle.friendlycoins.solvers;

import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.Solution;
import com.thoughtworks.cschuyle.friendlycoins.CoinSet;
import com.thoughtworks.cschuyle.friendlycoins.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.exception.NotFriendlyException;
import com.thoughtworks.cschuyle.friendlycoins.exception.NoSolutionException;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.util.WrappedIntegerHelpers;
import com.thoughtworks.cschuyle.WrappedInteger;

public class FriendlyChecker {
    private DenominationSet denominationSet;
    private MinimumCoinCountSolver solver;
    private Money total;

    public FriendlyChecker( DenominationSet denominationSet, MinimumCoinCountSolver solver, Money total ) {
        this.denominationSet = denominationSet;
        this.solver = solver;
        this.total = total;
    }

    public Exception checkIfFriendly() {
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
