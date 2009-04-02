package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;

import java.util.*;

public class CoinSetCollection extends AbstractSet<CoinSet> {

    private Map<CoinSet,CoinSet> set = new HashMap<CoinSet,CoinSet>();

    public static CoinSetCollection createAugmented( CoinSetCollection coinSets, Denomination denomination ) {
        CoinSetCollection augmented = new CoinSetCollection();
        for( CoinSet coinSet: coinSets ) {
            final CoinSet augmentedCoinSet = CoinSet.createAugmentedCoinSet( coinSet, denomination );
            augmented.add( augmentedCoinSet );
        }
        return augmented;
    }

    public int size() {
        return set.size();
    }

    public Iterator<CoinSet> iterator() {
        return set.values().iterator();
    }

    public boolean add( CoinSet coinSet ) {
        if( ! set.containsKey( coinSet ) ) {
            set.put( coinSet, coinSet );
            return true;
        }
        return false;
    }
}
