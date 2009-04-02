package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.util.WrappedIntegerHelpers;
import com.thoughtworks.cschuyle.util.ClassHelpers;
import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.Joiner;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;

import java.util.*;

class CoinRollSet extends AbstractMap<Integer, CoinRoll> {

    private Map<Integer, CoinRoll> coinRolls = new HashMap<Integer, CoinRoll>();

    public Set<Entry<Integer, CoinRoll>> entrySet() {
        return coinRolls.entrySet();
    }

    public @Override CoinRoll put( Integer denomination, CoinRoll coinRoll ) {
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
