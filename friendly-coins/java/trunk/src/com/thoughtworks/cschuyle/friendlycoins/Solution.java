package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.ClassHelpers;

import static com.thoughtworks.cschuyle.util.Joiner.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

import java.util.Collection;

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
