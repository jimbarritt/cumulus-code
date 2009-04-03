package com.thoughtworks.cschuyle.friendlycoins.primitives;

import com.thoughtworks.cschuyle.AbstractWrappedInteger;
import com.thoughtworks.cschuyle.WrappedInteger;

public class Money extends AbstractWrappedInteger {

    public Money() {
        super( 0 );
    }

    public Money( WrappedInteger rhs ) {
        super( rhs );
    }

    public Money( int value ) {
        super( value );
    }

    public void add( WrappedInteger denomination ) {
        final int denominationInt = denomination.intValue();
        this.value += denominationInt;
    }

    public void subtract( WrappedInteger denomination ) {
        final int denominationInt = denomination.intValue();
        this.value -= denominationInt;
    }
}
