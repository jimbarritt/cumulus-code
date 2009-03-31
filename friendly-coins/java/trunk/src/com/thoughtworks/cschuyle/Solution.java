package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;

import static com.thoughtworks.cschuyle.util.Joiner.*;

import java.util.Collection;

public abstract class Solution {

    public abstract Money getTotal();

    public abstract CoinSet getFewestCoinsSolution();

    public String toString() {
        final String className = Helpers.getSimpleClassName( this );
        return className + "<" + Helpers.stringJoin( getCoinSets(), COMMA ) + ">";
    }

    protected abstract Collection<CoinSet> getCoinSets();

}
