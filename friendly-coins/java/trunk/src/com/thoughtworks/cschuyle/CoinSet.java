package com.thoughtworks.cschuyle;

import java.util.*;
import com.thoughtworks.cschuyle.util.Helpers;
import static com.thoughtworks.cschuyle.util.Joiner.*;

class CoinSet {

    private CoinSet( Denomination... denominations ) {
        for(Denomination d : denominations ) {
            incrementDenomination( d );
        }
    }

    // Factory methods

    public static CoinSet createCoinSet(Denomination... denominations) {
        return new CoinSet( denominations ) ;
    }

    public static CoinSet createAugmentedCoinSet(CoinSet coinSet, Denomination denomination) {
        return new CoinSet( coinSet, denomination );
    }

    //

    public Money sum() {
        return sum;
    }

    public Cardinality getCardinality( Denomination denomination ) {
        if( containsDenomination( denomination ) ) {
            return denominations.get( denomination );
        }
        Cardinality newCard = Cardinality.getInstance( 0 );
        denominations.put( denomination, newCard );
        return newCard;
    }

    private void setCardinality( Denomination denomination, Cardinality card ) {
        denominations.put( denomination, card );
    }

    public Cardinality getNumCoins() {
        final Collection<Cardinality> denominationsValues = denominations.values();
        return Cardinality.total( denominationsValues );
    }

    public @Override boolean equals(Object rhs) {
        if( ! (rhs instanceof CoinSet) ) {
            return false;
        }
        final CoinSet rhsCoinSet = (CoinSet) rhs;
        final Map<Denomination, Cardinality> rhsDenominations = rhsCoinSet.denominations;
        final Map<Denomination, Cardinality> thisDenominations = this.denominations;
        return thisDenominations.equals( rhsDenominations );
    }

    public @Override int hashCode() {
        // TODO This is inefficient!
        return toString().hashCode();
    }


    public @Override String toString() {
        final Collection<String> items = new ArrayList<String>();
        for( Denomination item : denominations.keySet() ) {
            items.add( denominationToString( item ) );
        }
        final String className = Helpers.getSimpleClassName(this);
        return className + "<" + Helpers.stringJoin( items, COMMA ) + ">";
    }

    private String denominationToString( Denomination den ) {
        String item = den.stringValue();
        item += "'s:";
        final Cardinality card = denominations.get(den);
        item += card.stringValue();
        return item;
    }

    Collection<Denomination> getDenominations() {
        return denominations.keySet();
    }

    private CoinSet( CoinSet rhs ) {
        for( Denomination denomination: rhs.getDenominations() ) {
            final Cardinality rhsDenominationCount = rhs.getCardinality( denomination );
            denominations.put( denomination, rhsDenominationCount );
        }
        sum = new Money( rhs.sum() );
    }

    private CoinSet( CoinSet coinSet, Denomination denomination ) {
        this( coinSet );
        incrementDenomination( denomination );
    }

    Map<Denomination, Cardinality> denominations = new HashMap<Denomination, Cardinality>();

    boolean containsDenomination( Denomination d ) {
        return denominations.containsKey( d );
    }

    private Money sum = new Money();

    private void incrementDenomination( Denomination denomination ) {
        Cardinality card = getCardinality( denomination );
        final int cardPlus1 = card.intValue() + 1;
        setCardinality( denomination, Cardinality.getInstance( cardPlus1 ));
        sum.addCoin( denomination );
    }

}
