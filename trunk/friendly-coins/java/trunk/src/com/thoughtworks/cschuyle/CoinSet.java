package com.thoughtworks.cschuyle;

import java.util.HashMap;
import java.util.Map;

class CoinSet {

    public CoinSet( int denomination ) {
        add( denomination );
    }

    public CoinSet( Integer... denominations ) {
        for(int d : denominations ) {
            add( d );
        }
    }
    
    public static CoinSet createAugmentedCoinSet(CoinSet coinSet, int denomination) {
        return new CoinSet(coinSet, denomination);
    }

    public static CoinSet createClone(CoinSet rhs) {
        return new CoinSet(rhs);
    }

    public int sum() {
        return sum;
    }

    public int getCardinality( int denomination ) {
        if(containsDenomination( denomination )) {
            return denominations.get( denomination );
        } else {
            return 0;
        }
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

    @Override public String toString() {
        String ret = this.getClass().getSimpleName() + "<";
        boolean first = true;
        for( int k : denominations.keySet() ) {
            if( ! first ) {
                ret += ",";
            } else {
                first = false;
            }
            ret += k;
            ret += "'s:";
            ret += denominations.get( k );
        }
        return ret + ">";
    }

    private CoinSet( CoinSet rhs ) {
        for( int k: rhs.denominations.keySet() ) {
            denominations.put( k, rhs.denominations.get( k ));
        }
        sum = rhs.sum;
    }

    private CoinSet( CoinSet coinSet, int denomination ) {
        this( coinSet );
        add ( denomination );
    }

    Map<Integer, Integer> denominations = new HashMap<Integer, Integer>() {
        // TODO unnecessary? remove
        @Override public boolean equals(Object rhsObj) {
            if( null == rhsObj || !( rhsObj instanceof Map ) ) {
                return false;
            }
            HashMap<Integer, Integer> rhs = (HashMap<Integer, Integer>)rhsObj;
            for(int k : this.keySet()) {
                if( ! rhs.containsKey( k ))
                    return false;
                if(! rhs.get( k ).equals( this.get( k ) ) )
                    return false;
            }
            return( this.size() == rhs.size() );
        }
    };

    private void add(int i) {
        incrementDenomination( i );
    }

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
