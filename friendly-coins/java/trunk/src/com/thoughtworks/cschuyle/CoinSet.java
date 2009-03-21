package com.thoughtworks.cschuyle;

import java.util.*;
import com.thoughtworks.cschuyle.util.Helpers;

class CoinSet {

    private static Map<CoinSet, CoinSet> hash = Collections.synchronizedMap(new HashMap<CoinSet, CoinSet>());

    // Private constructors, you must use factory methods
    
    private static CoinSet intern( final CoinSet instance ) {
        final CoinSet existingInstance = getInstance( instance );
        if( null != existingInstance ) {
            return existingInstance;
        }
        hash.put( instance, instance );
        return instance;
    }

    private static CoinSet getInstance( CoinSet instance ) {
        return hash.get( instance );
    }

    private CoinSet( Integer... denominations ) {
        for(int d : denominations ) {
            incrementDenomination( d );
        }
    }

    // Factory methods

    public static CoinSet createCoinSet(Integer... denominations) {
        return intern( new CoinSet( denominations ) );
    }

    public static CoinSet createAugmentedCoinSet(CoinSet coinSet, int denomination) {
        return intern( new CoinSet( coinSet, denomination ) );
    }

    //

    public int sum() {
        return sum;
    }

    public int getCardinality( int denomination ) {
        if(containsDenomination( denomination )) {
            return denominations.get( denomination );
        }
        return 0;
    }

    public int getNumCoins() {
        // TODO There must be an algorithm for this
        int ret = 0;
        for( int count : denominations.values() ) {
            ret += count;
        }
        return ret;
    }

    @Override public boolean equals(Object rhs) {
        if( null == rhs || ! (rhs instanceof CoinSet) ) {
            return false;
        }
        return this.denominations.equals( ((CoinSet)rhs).denominations);
    }

    @Override public int hashCode() {
        return toString().hashCode();
    }


    @Override public String toString() {
        final Collection<String> items = new ArrayList<String>();
        for( int item : denominations.keySet() ) {
            items.add( denominationToString( item ) );
        }
        return this.getClass().getSimpleName() + "<" + Helpers.stringJoin( items, "," ) + ">";
    }

    private String denominationToString( int den ) {
        String item = new Integer( den ).toString();
        item += "'s:";
        item += denominations.get( den );
        return item;
    }

    private CoinSet( CoinSet rhs ) {
        for( int k: rhs.denominations.keySet() ) {
            denominations.put( k, rhs.denominations.get( k ));
        }
        sum = rhs.sum;
    }

    private CoinSet( CoinSet coinSet, int denomination ) {
        this( coinSet );
        incrementDenomination( denomination );
    }

    Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    boolean containsDenomination( int i ) {
        return denominations.containsKey( i );
    }

    int sum = 0;

    private void incrementDenomination( int denomination ) {
        int card = getCardinality( denomination );
        denominations.put( denomination, 1 + card );
        sum += denomination;
    }

}
