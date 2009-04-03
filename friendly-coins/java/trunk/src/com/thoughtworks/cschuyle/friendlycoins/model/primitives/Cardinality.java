package com.thoughtworks.cschuyle.friendlycoins.model.primitives;

import com.thoughtworks.cschuyle.AbstractWrappedInteger;
import com.thoughtworks.cschuyle.WrappedInteger;

import java.util.Map;
import java.util.HashMap;

public class Cardinality extends AbstractWrappedInteger {

    private Cardinality( int value ) {
        super( value );
    }

    public static Cardinality getInstance( int value ) {
        return intern( value );
    }

    public static Cardinality getInstance( WrappedInteger value ) {
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
