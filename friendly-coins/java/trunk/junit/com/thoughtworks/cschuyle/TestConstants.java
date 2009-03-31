package com.thoughtworks.cschuyle;

public class TestConstants {
    private TestConstants() {}

    public final static Denomination ONE = Denomination.getInstance( 1 );
    public final static Denomination TWO = Denomination.getInstance( 2 );
    public final static Denomination THREE = Denomination.getInstance( 3 );
    public final static Denomination FOUR = Denomination.getInstance( 4 );
    public final static Denomination FIVE = Denomination.getInstance( 5 );

    public final static Money TOTAL_ZERO =  new Money( 0 );
    public final static Money TOTAL_ONE =   new Money( 1 );
    public final static Money TOTAL_TWO =   new Money( 2 );
    public final static Money TOTAL_THREE = new Money( 3 );
    public final static Money TOTAL_FOUR =  new Money( 4 );
    public final static Money TOTAL_FIVE =  new Money( 5 );
    public final static Money TOTAL_SEVEN = new Money( 7 );
    public final static Money TOTAL_EIGHT = new Money( 8 );
    public final static Money TOTAL_TEN =   new Money( 10 );
    public final static Money TOTAL_ONE_THOUSAND = new Money( 1000 );
    public final static Money TOTAL_TEN_THOUSAND = new Money( 10000 );

}

