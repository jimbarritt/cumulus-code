package com.thoughtworks.cschuyle.friendlycoins.solvers;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.solvers.FriendlyChecker;

public class FriendlyRecognizer {

    Money highestFriendlyTotal = null;

    public void checkFriendliness( DenominationSet denominationSet, Money checkUpToTotal ) {
        if( checkUpToTotal.intValue() < 1 ) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        final MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominationSet );
        for( int total = 1 ; total <= checkUpToTotal.intValue() && null == failureException ; ++total ) {
            FriendlyChecker checker = new FriendlyChecker( denominationSet, solver, new Money( total ) );
            failureException = checker.checkIfFriendly();
        }
    }

    public boolean isFriendly() {
        return (null == failureException);
    }

    public Exception getFailureException() {
        return failureException;
    }

    private Exception failureException;
}
