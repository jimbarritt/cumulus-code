package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.ClassHelpers;

import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSet;

import static com.thoughtworks.cschuyle.util.Joiner.*;

public abstract class Solution {

    public abstract CoinSet getFewestCoinsSolution();

    public String toString() {
        final String className = ClassHelpers.simpleName( this );
        final String body = StringHelpers.join( getCoinSets(), COMMA );
        return className + "<" + body + ">";
    }

    public abstract CoinSetCollection getCoinSets();

    public int size() {
        return getCoinSets().size();
    }
}
