package com.thoughtworks.cschuyle.friendlycoins.collections;

import com.thoughtworks.cschuyle.friendlycoins.primitives.*;

public class CoinRoll {

    private Denomination denomination;
    private Cardinality count;

    public CoinRoll( Denomination denomination ) {
        this.denomination = denomination;
        this.count = Cardinality.getInstance( 1 );
    }

    public CoinRoll( Denomination denomination, Cardinality count ) {
        this.denomination = denomination;
        this.count = count;
    }

    public Cardinality getCount() {
        return count;
    }

    public Denomination getDenomination() {
        return denomination;
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
        final int denominationInt = denomination.intValue();
        final int countInt = count.intValue();
        return (17 * denominationInt) ^ countInt;
    }
}
