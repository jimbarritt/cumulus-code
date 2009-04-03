package com.thoughtworks.cschuyle.friendlycoins.collections;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;

public class CoinRollCollection extends CoinRollCollectionBase {

    public CoinRollCollection() {}

    public Cardinality totalCoinCount() {
        int sum = 0;
        for( CoinRoll coinRoll: coinRolls.values() ) {
            final Cardinality count = coinRoll.count;
            sum += count.intValue();
        }
        return Cardinality.getInstance( sum );
    }

    public CoinRollCollection deepCopy() {
        CoinRollSet copy = new CoinRollSet();
        for( CoinRoll coinRoll: coinRolls.values() ) {
            final Denomination denomination = coinRoll.denomination;
            final Cardinality count = coinRoll.count;
            final int denominationInt = denomination.intValue();
            copy.put( denominationInt, new CoinRoll( denomination, count ) );
        }
        return new CoinRollCollection( copy );
    }

    public boolean containsDenomination(Denomination denomination) {
        return coinRolls.containsKey( denomination.intValue() );
    }

    private CoinRollCollection( CoinRollSet set ) {
        this.coinRolls = set;
    }
}
