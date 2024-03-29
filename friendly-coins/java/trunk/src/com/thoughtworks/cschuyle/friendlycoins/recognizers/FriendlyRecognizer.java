package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.model.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.solutions.MinimumCoinCountSolver;
import com.thoughtworks.cschuyle.AbstractWrappedInteger;
import static com.thoughtworks.cschuyle.WrappedIntegerHelpers.*;

public class FriendlyRecognizer {

    public FriendlinessResult checkFriendliness( DenominationSet denominationSet, Money checkUpToTotal ) {
        if( checkUpToTotal.lessThan (new AbstractWrappedInteger( 1 ) {} ) ) {
            throw new IllegalArgumentException( "Must check up to at least total=1!" );
        }
        final MinimumCoinCountSolver solver = new MinimumCoinCountSolver( denominationSet );
        FriendlinessResult failureException = null;
        Money total;
        for( total = new Money( 1 )
                ; total.lessThanOrEqual( checkUpToTotal ) && null == failureException
                ; total.add( ONE ) ) {
            FriendlyChecker checker = new FriendlyChecker( denominationSet, solver );
            failureException = checker.checkIfFriendly( new Money( total ) );
        }
        if( null != failureException) {
            return failureException;
        }
        return new ResultIsFriendly( new Money( total ) );
    }

}
