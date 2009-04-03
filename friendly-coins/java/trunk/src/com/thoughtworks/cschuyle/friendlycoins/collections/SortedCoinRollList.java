package com.thoughtworks.cschuyle.friendlycoins.collections;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;

import java.util.TreeSet;
import java.util.Comparator;

class SortedCoinRollList extends TreeSet<CoinRoll> {

    public SortedCoinRollList( CoinRollCollectionBase coinRolls ) {

        super( new Comparator<CoinRoll>() {
            public int compare( CoinRoll coinRoll1, CoinRoll coinRoll2 ) {
                final Denomination denomination1 = coinRoll1.denomination;
                final Denomination denomination2 = coinRoll2.denomination;
                return denomination1.compareTo( denomination2 );
            }
        });

        addAll( coinRolls.values() );
        
    }
}
