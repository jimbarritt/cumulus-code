package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;
import com.thoughtworks.cschuyle.util.Joiner;

import java.util.Collection;

public abstract class Solution {

    public abstract Money getTotal();

    public abstract CoinSet getFewestCoinsSolution();

    public String toString() {
        return this.getClass().getSimpleName() + "<" + Helpers.stringJoin( getCoinSets(), Joiner.COMMA ) + ">";
    }

    protected abstract Collection<CoinSet> getCoinSets();

}
