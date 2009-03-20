package com.thoughtworks.cschuyle;

import java.util.Collection;

public abstract class Solution {

    public abstract int getTotal();

    public abstract CoinSet getFewestCoinsSolution();

    public String toString() {
        String ret = this.getClass().getSimpleName() + "<";
        boolean first = true;
        for( CoinSet coinSet: getCoinSets() ) {
            if( ! first ) {
                ret += ",";
            } else {
                first = false;
            }
            ret += coinSet.toString();
        }
        return ret + ">";
    }

    protected abstract Collection<CoinSet> getCoinSets();

}
