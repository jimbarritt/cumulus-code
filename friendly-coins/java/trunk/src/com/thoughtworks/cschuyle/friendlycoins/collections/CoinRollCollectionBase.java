package com.thoughtworks.cschuyle.friendlycoins.collections;

import com.thoughtworks.cschuyle.util.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;

import java.util.*;

public class CoinRollCollectionBase implements Iterable<CoinRoll> {

    protected CoinRollSet coinRolls;

    public CoinRollCollectionBase() {
        this.coinRolls = new CoinRollSet();
    }

    public CoinRoll get( Denomination denomination ) {
        return coinRolls.get( denomination.intValue() );
    }

    public void put( CoinRoll coinRoll ) {
        coinRolls.put( coinRoll.denomination.intValue(), coinRoll );
    }

    public Iterator<CoinRoll> iterator() {
        return coinRolls.values().iterator();
    }

    public Collection<CoinRoll> values() {
        return coinRolls.values();
    }

    public @Override String toString() {
        final Collection<CoinRoll> values = new SortedCoinRollList( this );
        final String className = ClassHelpers.simpleName(this);
        return className + "<" + StringHelpers.join( values, Joiner.COMMA ) + ">";
    }

    public @Override boolean equals( Object rhs) {
        CoinRollCollection rhsCoinRolls = (CoinRollCollection)rhs;
        return( rhs instanceof CoinRollCollection && this.coinRolls.equals( rhsCoinRolls.coinRolls ) );
    }

    public @Override int hashCode() {
        return coinRolls.hashCode();
    }

    public long size() {
        return coinRolls.size();
    }
}
