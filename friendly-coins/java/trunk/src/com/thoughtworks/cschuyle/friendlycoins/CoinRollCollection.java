package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.util.ClassHelpers;
import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.Joiner;
import com.thoughtworks.cschuyle.util.WrappedIntegerHelpers;

import java.util.*;

public class CoinRollCollection extends AbstractMap<Integer, CoinRoll> {

    private Map<Integer, CoinRoll> coinRolls = new HashMap<Integer, CoinRoll>();

    public Set<Entry<Integer, CoinRoll>> entrySet() {
        return coinRolls.entrySet();
    }

    public @Override
    CoinRoll put( Integer denomination, CoinRoll coinRoll ) {
        coinRolls.put( denomination, coinRoll );
        return coinRoll;
    }

    public Cardinality getTotalCoinCount() {
        int sum = 0;
        for( CoinRoll coinRoll: coinRolls.values() ) {
            final Cardinality count = coinRoll.getCount();
            sum += count.intValue();
        }
        return Cardinality.getInstance( sum );
    }

    public CoinRollCollection deepCopy() {
        CoinRollCollection copy = new CoinRollCollection();
        for( CoinRoll coinRoll: coinRolls.values() ) {
            final Denomination denomination = coinRoll.getDenomination();
            final Cardinality count = coinRoll.getCount();
            copy.put( denomination.intValue(), new CoinRoll( denomination, count ) );
        }
        return copy;
    }

    static class SortedCoinRollList extends TreeSet<CoinRoll> {
        public SortedCoinRollList() {
            super( new Comparator<CoinRoll>() {
                public int compare(CoinRoll coinRoll, CoinRoll coinRoll1) {
                    return WrappedIntegerHelpers.compareTo( coinRoll.getDenomination(), coinRoll1.getDenomination() ).intValue();
                }
            });
        }
    }
    private SortedCoinRollList getSortedList() {
        SortedCoinRollList orderedList = new SortedCoinRollList();
        orderedList.addAll( coinRolls.values() );
        return orderedList;
    }

    public @Override String toString() {
        final Collection<CoinRoll> values = this.getSortedList();
        final String className = ClassHelpers.simpleName(this);
        return className + "<" + StringHelpers.join( values, Joiner.COMMA ) + ">";
    }

    public @Override boolean equals( Object rhs ) {
        if( ! (rhs instanceof CoinRollCollection ) ) {
            return false;
        }
        CoinRollCollection rhsCoinRolls =  (CoinRollCollection)rhs;
        for( CoinRoll coinRoll: coinRolls.values() ) {
            if( ! rhsCoinRolls.containsValue( coinRoll ) ) {
                return false;
            }
        }
        return( coinRolls.size() == rhsCoinRolls.size() );
    }

    public @Override int hashCode() {
        int hashCode = 0;
        for( CoinRoll coinRoll: coinRolls.values() ) {
            hashCode ^= coinRoll.hashCode();
        }
        return hashCode;
    }
}
