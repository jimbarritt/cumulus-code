package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;

import java.util.Collection;

public abstract class Solution {

    public abstract int getTotal();

    public abstract CoinSet getFewestCoinsSolution();

    public String toString() {
        return Helpers.stringJoin( getCoinSets(), "," ) + ">";
    }

    protected abstract Collection<CoinSet> getCoinSets();

}
