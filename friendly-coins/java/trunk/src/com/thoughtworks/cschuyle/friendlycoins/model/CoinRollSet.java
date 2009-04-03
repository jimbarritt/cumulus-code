package com.thoughtworks.cschuyle.friendlycoins.model;

import com.thoughtworks.cschuyle.WrappedInteger;

import java.util.*;

class CoinRollSet extends AbstractMap<WrappedInteger, CoinRoll> {

    private Map<WrappedInteger, CoinRoll> coinRolls = new HashMap<WrappedInteger, CoinRoll>();

    public @Override Set<Entry<WrappedInteger, CoinRoll>> entrySet() {
        return coinRolls.entrySet();
    }

    public @Override CoinRoll put( WrappedInteger denomination, CoinRoll coinRoll ) {
        coinRolls.put( denomination, coinRoll );
        return coinRoll;
    }

    public @Override boolean equals( Object rhs ) {
        if( ! (rhs instanceof CoinRollSet) ) {
            return false;
        }
        CoinRollSet rhsCoinRolls =  (CoinRollSet)rhs;
        for( CoinRoll coinRoll: coinRolls.values() ) {
            if( ! rhsCoinRolls.containsValue( coinRoll ) ) {
                return false;
            }
        }
        return( size() == rhsCoinRolls.size() );
    }

    public @Override int hashCode() {
        int hashCode = 0;
        for( CoinRoll coinRoll: coinRolls.values() ) {
            hashCode ^= (coinRoll.hashCode() * 17);
        }
        return hashCode;
    }
}
