package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

class Cardinality extends WrappedInteger implements Comparable<Cardinality> {

    private Cardinality( int i ) {
        super( i );
    }

    public static Cardinality total(Collection<Cardinality> cardinalities) {
        int i = 0;
        for( Cardinality card : cardinalities ) {
            i += card.intValue();
        }
        return getInstance( i );

    }

    public int compareTo( Cardinality rhs ) {
        return Helpers.intCompareTo( this.value, rhs.value );
    }

    public static Cardinality getInstance(int i) {
        return intern( i );

    }
    private static Cardinality intern( int i ) {
        if(cache.containsKey( i )) {
            return cache.get( i );
        }
        final Cardinality cardinality = new Cardinality(i);
        cache.put( i, cardinality);
        return cardinality;
    }

    private static Map<Integer, Cardinality> cache = new HashMap<Integer, Cardinality>();
}
