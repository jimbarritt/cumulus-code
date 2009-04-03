package com.thoughtworks.cschuyle.friendlycoins.model;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;

public class CoinRollCollection extends CoinRollCollectionBase {

    public CoinRollCollection() {}

    public Cardinality totalCoinCount() {
        Money sum = new Money();
        for( CoinRoll coinRoll: coinRolls.values() ) {
            final Cardinality count = coinRoll.count;
            sum.add( count );
        }
        return Cardinality.getInstance( sum );
    }

    public CoinRollCollection deepCopy() {
        CoinRollSet copy = new CoinRollSet();
        for( CoinRoll coinRoll: coinRolls.values() ) {
            final Denomination denomination = coinRoll.denomination;
            final Cardinality count = coinRoll.count;
            copy.put( denomination, new CoinRoll( denomination, count ) );
        }
        return new CoinRollCollection( copy );
    }

    public boolean containsDenomination(Denomination denomination) {
        return coinRolls.containsKey( denomination );
    }

    private CoinRollCollection( CoinRollSet set ) {
        this.coinRolls = set;
    }
}
