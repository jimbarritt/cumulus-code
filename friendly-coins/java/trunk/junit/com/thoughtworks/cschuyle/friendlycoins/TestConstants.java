package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;

public class TestConstants {
    private TestConstants() {}

    public final static Denomination ONER = Denomination.getInstance( 1 );
    public final static Denomination TWOER = Denomination.getInstance( 2 );
    public final static Denomination THREER = Denomination.getInstance( 3 );
    public final static Denomination FOURER = Denomination.getInstance( 4 );
    public final static Denomination FIVER = Denomination.getInstance( 5 );

    public final static Money ZERO_CENTS =  new Money( 0 );
    public final static Money ONE_CENT =   new Money( 1 );
    public final static Money TWO_CENTS =   new Money( 2 );
    public final static Money THREE_CENTS = new Money( 3 );
    public final static Money FOUR_CENTS =  new Money( 4 );
    public final static Money FIVE_CENTS =  new Money( 5 );
    public final static Money SEVEN_CENTS = new Money( 7 );
    public final static Money EIGHT_CENTS = new Money( 8 );
    public final static Money TEN_CENTS =   new Money( 10 );
    public final static Money ONE_HUNDRED_CENTS = new Money( 100 );
    public final static Money ONE_THOUSAND_CENTS = new Money( 1000 );
    public final static Money TEN_THOUSAND_CENTS = new Money( 10000 );

}

