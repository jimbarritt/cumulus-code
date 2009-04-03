package com.thoughtworks.cschuyle.friendlycoins.collections;

import com.thoughtworks.cschuyle.util.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;

public class CoinSetBase {

    protected Money total = new Money();
    protected CoinRollCollection coinRolls = new CoinRollCollection();

    public Money total() {
        return this.total;
    }

    public Cardinality denominationCount( Denomination denomination ) {
        if( containsDenomination( denomination ) ) {
            return coinRolls.get( denomination ).count;
        }
        return Cardinality.getInstance( 0 );
    }

    public Cardinality totalCoinCount() {
        return coinRolls.totalCoinCount();
    }

    public @Override boolean equals( Object rhs ) {
        if( ! (rhs instanceof CoinSet ) ) {
            return false;
        }
        final CoinSet rhsCoinSet = (CoinSet) rhs;
        final CoinRollCollection rhsCoinRolls = rhsCoinSet.coinRolls;
        return( this.coinRolls.equals( rhsCoinRolls ) );
    }

    public @Override int hashCode() {
        return coinRolls.hashCode();
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        final String body = StringHelpers.join( coinRolls.values(), com.thoughtworks.cschuyle.util.Joiner.COMMA);
        return className + "<" + body + ">";
    }

    private boolean containsDenomination( Denomination d ) {
        return coinRolls.containsDenomination( d );
    }
}
