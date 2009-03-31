package com.thoughtworks.cschuyle.friendlycoins.primitives;

import com.thoughtworks.cschuyle.util.IntegerHelpers;
import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;

import java.util.HashMap;
import java.util.Map;

public class Denomination extends WrappedInteger implements Comparable<Denomination> {

    public static boolean isEmpty( DenominationSet denominations ) {
        return null == denominations || 0 == denominations.size();
    }
    
    private Denomination( int value ) {
        super( value );
    }

    public int compareTo( Denomination rhs ) {
        final int thisValue = this.value;
        final int rhsValue = rhs.value;
        return IntegerHelpers.intCompareTo( thisValue, rhsValue);
    }

    public static Denomination getInstance( int value ) {
        return intern( value );

    }
    private static Denomination intern( int value ) {
        if( cache.containsKey( value ) ) {
            return cache.get( value );
        }
        final Denomination newDenomination = new Denomination( value );
        cache.put( value, newDenomination );
        return newDenomination;
    }

    private static Map<Integer, Denomination> cache = new HashMap<Integer, Denomination>();

}
