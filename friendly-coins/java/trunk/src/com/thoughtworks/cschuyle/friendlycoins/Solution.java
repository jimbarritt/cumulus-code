package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.ClassHelpers;

import static com.thoughtworks.cschuyle.util.StringHelpers.Joiner.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

import java.util.Collection;

public abstract class Solution {

    // TODO Do I really need this?
    public abstract Money getTotal();

    // TODO Don't like this name.  Too long, too specialized.
    public abstract CoinSet getFewestCoinsSolution();

    public String toString() {
        final String className = ClassHelpers.simpleName( this );
        return className + "<" + StringHelpers.join( getCoinSets(), COMMA ) + ">";
    }

    // TODO Do I really need this?
    public abstract Collection<CoinSet> getCoinSets();

}
