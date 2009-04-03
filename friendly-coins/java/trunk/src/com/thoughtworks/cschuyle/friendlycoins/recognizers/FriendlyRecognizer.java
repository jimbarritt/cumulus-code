package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.collections.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.recognizers.ResultIsFriendly;
import com.thoughtworks.cschuyle.friendlycoins.recognizers.FriendlinessResult;
import com.thoughtworks.cschuyle.friendlycoins.recognizers.FriendlyChecker;
import com.thoughtworks.cschuyle.friendlycoins.solvers.MinimumCoinCountSolver;

public class FriendlyRecognizer {

    public FriendlinessResult checkFriendliness( DenominationSet denominationSet, Money checkUpToTotal ) {
        if( checkUpToTotal.intValue() < 1 ) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        final MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominationSet );
        FriendlinessResult failureException = null;
        int total = 0;
        for( total = 1 ; total <= checkUpToTotal.intValue() && null == failureException ; ++total ) {
            FriendlyChecker checker = new FriendlyChecker( denominationSet, solver );
            failureException = checker.checkIfFriendly( new Money( total ) );
        }
        if( null != failureException) {
            return failureException;
        }
        return new ResultIsFriendly( new Money( total ) );
    }

}
