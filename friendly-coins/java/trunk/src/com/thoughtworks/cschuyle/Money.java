package com.thoughtworks.cschuyle;

public class Money extends WrappedInteger {

    public Money() {
        super( 0 );
    }

    public Money( Money rhs ) {
        super( rhs.intValue() );
    }

    public Money( int i ) {
        super( i );
    }

    public void addCoin( Denomination denomination ) {
        final int denominationInt = denomination.intValue();
        this.value += denominationInt;
    }

    public void removeCoin( Denomination denomination ) {
        final int denominationInt = denomination.intValue();
        this.value -= denominationInt;
    }

    public @Override boolean equals( Object rhsObj) {
        final Money rhsMoney = (Money) rhsObj;
        final int rhsInt = rhsMoney.intValue();
        final int thisInt = this.intValue();
        return ( rhsObj instanceof Money && rhsInt == thisInt );
    }    
}
