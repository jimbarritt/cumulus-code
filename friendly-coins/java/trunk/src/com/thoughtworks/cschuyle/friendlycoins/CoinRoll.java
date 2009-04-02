package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;

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
        String item = denomination.stringValue();
        item += "'s:";
        item += count.stringValue();
        return item;
    }

    public @Override boolean equals( Object rhs ) {
        final CoinRoll rhsCoinRoll = (CoinRoll) rhs;
        return( rhs instanceof CoinRoll &&
            this.denomination.equals( rhsCoinRoll.denomination) &&
            this.count.equals( rhsCoinRoll.count)
        );
    }

    public @Override int hashCode() {
        final int denominationInt = denomination.intValue();
        final int countInt = count.intValue();
        return denominationInt ^ countInt;
    }
}
