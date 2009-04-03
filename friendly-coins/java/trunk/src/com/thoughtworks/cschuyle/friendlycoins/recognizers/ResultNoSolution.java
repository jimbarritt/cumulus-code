package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.collections.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

public class ResultNoSolution extends ResultNotFriendly {

    public ResultNoSolution( String msg ) {
        super( msg );
    }

    public ResultNoSolution(DenominationSet denominations, Money total) {
        super( "There is no solution given the denominations " + denominations +
                " to give " + total + " cents change." );
    }
}
