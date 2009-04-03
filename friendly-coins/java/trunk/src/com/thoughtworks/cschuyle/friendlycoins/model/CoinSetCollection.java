package com.thoughtworks.cschuyle.friendlycoins.model;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;

import java.util.*;

public class CoinSetCollection extends AbstractSet<CoinSet> {

    private Map<CoinSet, CoinSet> coinSets = new HashMap<CoinSet,CoinSet>();

    public static CoinSetCollection createAugmented( CoinSetCollection theCoinSets, Denomination denomination ) {
        CoinSetCollection augmented = new CoinSetCollection();
        for( CoinSet coinSet: theCoinSets ) {
            final CoinSet augmentedCoinSet = CoinSet.createAugmentedCoinSet( coinSet, denomination );
            augmented.add( augmentedCoinSet );
        }
        return augmented;
    }

    public int size() {
        return coinSets.size();
    }

    public Iterator<CoinSet> iterator() {
        final Collection<CoinSet> seValues = coinSets.values();
        return seValues.iterator();
    }

    public @Override boolean add( CoinSet coinSet ) {
        if( ! coinSets.containsKey( coinSet ) ) {
            coinSets.put( coinSet, coinSet );
            return true;
        }
        return false;
    }
}
