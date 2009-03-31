package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;

import java.util.HashMap;
import java.util.Map;

class Denomination extends WrappedInteger implements Comparable<Denomination> {

    public static boolean isEmpty( DenominationSet denominations ) {
        return null == denominations || 0 == denominations.size();
    }
    
    private Denomination( int i ) {
        super(i);
    }

    public int compareTo( Denomination rhs ) {
        final int thisValue = this.value;
        final int rhsValue = rhs.value;
        return Helpers.intCompareTo( thisValue, rhsValue);
    }

    public static Denomination getInstance(int i) {
        return intern( i );

    }
    private static Denomination intern( int i ) {
        if(cache.containsKey( i )) {
            return cache.get( i );
        }
        final Denomination newDenomination = new Denomination(i);
        cache.put( i, newDenomination );
        return newDenomination;
    }

    private static Map<Integer, Denomination> cache = new HashMap<Integer, Denomination>();

}
