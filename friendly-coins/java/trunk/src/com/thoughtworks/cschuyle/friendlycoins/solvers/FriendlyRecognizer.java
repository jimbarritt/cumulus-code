package com.thoughtworks.cschuyle.friendlycoins.solvers;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.solvers.FriendlyChecker;

public class FriendlyRecognizer {

    private Money highestFriendlyTotal = null;
    private Exception failureException;

    public void checkFriendliness( DenominationSet denominationSet, Money checkUpToTotal ) {
        if( checkUpToTotal.intValue() < 1 ) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        final MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominationSet );
        for( int total = 1 ; total <= checkUpToTotal.intValue() && null == failureException ; ++total ) {
            FriendlyChecker checker = new FriendlyChecker( denominationSet, solver );
            failureException = checker.checkIfFriendly( new Money( total ) );
        }
    }

    public boolean isFriendly() {
        return (null == failureException);
    }

    public Exception getFailureException() {
        return failureException;
    }
}
