package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.collections.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.solutions.MinimumCoinCountSolver;
import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.AbstractWrappedInteger;

public class FriendlyRecognizer {

    public FriendlinessResult checkFriendliness( DenominationSet denominationSet, Money checkUpToTotal ) {
        if( checkUpToTotal.lessThan (new WrappedInteger( 1 ) ) ) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        final MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominationSet );
        FriendlinessResult failureException = null;
        AbstractWrappedInteger total;
        for( total = new WrappedInteger( 1 )
                ; total.lessThanOrEqual( checkUpToTotal ) && null == failureException
                ; total = total.plusOne() ) {
            FriendlyChecker checker = new FriendlyChecker( denominationSet, solver );
            failureException = checker.checkIfFriendly( new Money( total ) );
        }
        if( null != failureException) {
            return failureException;
        }
        return new ResultIsFriendly( new Money( total ) );
    }

}
