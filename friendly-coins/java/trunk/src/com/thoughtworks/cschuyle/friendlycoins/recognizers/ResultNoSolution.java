package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.model.DenominationSet;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;

public class ResultNoSolution extends ResultNotFriendly {

    public ResultNoSolution( String msg ) {
        super( msg );
    }

    public ResultNoSolution(DenominationSet denominations, Money total) {
        super( "There is no solution given the denominations " + denominations +
                " to give " + total + " cents change." );
    }
}
