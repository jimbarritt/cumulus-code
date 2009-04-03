package com.thoughtworks.cschuyle.friendlycoins.primitives;

import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.AbstractWrappedInteger;

public class Money extends WrappedInteger {

    public Money() {
        super( 0 );
    }

    public Money( AbstractWrappedInteger rhs ) {
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
}
