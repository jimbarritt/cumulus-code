package com.thoughtworks.cschuyle.friendlycoins.primitives;

import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.friendlycoins.collections.DenominationSet;

import java.util.HashMap;
import java.util.Map;

public class Denomination extends WrappedInteger {

    public static boolean isEmpty( DenominationSet denominations ) {
        return null == denominations || 0 == denominations.size();
    }
    
    private Denomination( int value ) {
        super( value );
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
