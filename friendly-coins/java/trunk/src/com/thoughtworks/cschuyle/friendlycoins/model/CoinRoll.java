package com.thoughtworks.cschuyle.friendlycoins.model;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Cardinality;
import com.thoughtworks.cschuyle.WrappedIntegerHelpers;

public class CoinRoll {

    Denomination denomination;
    Cardinality count;

    public CoinRoll( Denomination denomination ) {
        this.denomination = denomination;
        this.count = Cardinality.getInstance( 1 );
    }

    public CoinRoll( Denomination denomination, Cardinality count ) {
        this.denomination = denomination;
        this.count = count;
    }

    public @Override String toString() {
        final String denominationStr = denomination.stringValue();
        final String countStr = count.stringValue();
        return denominationStr + "'s:" + countStr;
    }

    public @Override boolean equals( Object rhs ) {
        if( ! ( rhs instanceof CoinRoll ) ) {
            return false;
        }
        final CoinRoll rhsCoinRoll = (CoinRoll)rhs;
        final Cardinality rhsCount = rhsCoinRoll.count;
        final Denomination rhsDenomination = rhsCoinRoll.denomination;
        return( denomination.equals( rhsDenomination ) && count.equals( rhsCount ) );
    }

    public @Override int hashCode() {
        return WrappedIntegerHelpers.hashCode( denomination, count );
    }
}
