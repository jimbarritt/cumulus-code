package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.util.WrappedIntegerHelpers;

import java.util.TreeSet;
import java.util.Comparator;

class SortedCoinRollList extends TreeSet<CoinRoll> {

    public SortedCoinRollList( CoinRollCollectionBase coinRolls ) {

        super( new Comparator<CoinRoll>() {
            public int compare( CoinRoll coinRoll1, CoinRoll coinRoll2 ) {
                final Denomination denomination1 = coinRoll1.getDenomination();
                final Denomination denomination2 = coinRoll2.getDenomination();
                final WrappedInteger comparison = WrappedIntegerHelpers.compareTo( denomination1, denomination2 );
                return comparison.intValue();
            }
        });

        addAll( coinRolls.values() );
        
    }
}
