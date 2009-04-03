package com.thoughtworks.cschuyle.friendlycoins.exception;

import com.thoughtworks.cschuyle.friendlycoins.model.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;

public class NoSolutionException extends RuntimeException {

    public NoSolutionException( String message ) {
        super( message );
    }

    public NoSolutionException( DenominationSet denominationSet, Money requiredTotal ) {
        this(  "There is no solution: I can't use " + denominationSet +
                " to arrive at " + requiredTotal + " cents change" );
    }
}
