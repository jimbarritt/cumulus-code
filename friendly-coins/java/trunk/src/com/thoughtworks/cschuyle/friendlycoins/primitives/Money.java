package com.thoughtworks.cschuyle.friendlycoins.primitives;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.WrappedInteger;

public class Money extends WrappedInteger {

    public Money() {
        super( 0 );
    }

    public Money( WrappedInteger rhs ) {
        super( rhs.intValue() );
    }

    public Money( int value ) {
        super( value );
    }

    public void addCoin( Denomination denomination ) {
        final int denominationInt = denomination.intValue();
        this.value += denominationInt;
    }

    public void removeCoin( Denomination denomination ) {
        final int denominationInt = denomination.intValue();
        this.value -= denominationInt;
    }

    public @Override boolean equals( Object rhsObj ) {
        if( ! (rhsObj instanceof Money) ) {
            return false;
        }
        final Money rhsMoney = (Money) rhsObj;
        final int rhsInt = rhsMoney.intValue();
        final int thisInt = this.intValue();
        return ( rhsInt == thisInt );
    }    
}
