package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.IntegerHelpers;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

class Cardinality extends WrappedInteger implements Comparable<Cardinality> {

    private Cardinality( int value ) {
        super( value );
    }

    public static Cardinality total( Collection<Cardinality> cardinalities ) {
        int value = 0;
        for( Cardinality cardinality : cardinalities ) {
            value += cardinality.intValue();
        }
        return getInstance( value );
    }

    public int compareTo( Cardinality rhs ) {
        final int thisInt = this.value;
        final int rhsInt = rhs.value;
        return IntegerHelpers.intCompareTo( thisInt, rhsInt );
    }

    public static Cardinality getInstance( int value ) {
        return intern( value );
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
