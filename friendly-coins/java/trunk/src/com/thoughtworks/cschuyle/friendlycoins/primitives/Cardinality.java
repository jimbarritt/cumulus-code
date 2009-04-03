package com.thoughtworks.cschuyle.friendlycoins.primitives;

import com.thoughtworks.cschuyle.WrappedInteger;
import com.thoughtworks.cschuyle.AbstractWrappedInteger;

import java.util.Map;
import java.util.HashMap;

public class Cardinality extends WrappedInteger {

    private Cardinality( int value ) {
        super( value );
    }

    public static Cardinality getInstance( int value ) {
        return intern( value );
    }

    public static Cardinality getInstance( AbstractWrappedInteger value ) {
        return getInstance( value.intValue() );
    }

    private static Cardinality intern( int value ) {
        if( cache.containsKey( value ) ) {
            return cache.get( value );
        }
        final Cardinality cardinality = new Cardinality( value );
        cache.put( value, cardinality);
        return cardinality;
    }

    private static Map<Integer, Cardinality> cache = new HashMap<Integer, Cardinality>();
}
