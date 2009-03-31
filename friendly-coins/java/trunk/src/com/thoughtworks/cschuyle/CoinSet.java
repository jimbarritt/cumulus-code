package com.thoughtworks.cschuyle;

import java.util.*;
import com.thoughtworks.cschuyle.util.Helpers;
import com.thoughtworks.cschuyle.util.Joiner;

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
        return Cardinality.total( denominations.values() );
    }

    public @Override boolean equals(Object rhs) {
        if( null == rhs || ! (rhs instanceof CoinSet) ) {
            return false;
        }
        return this.denominations.equals( ((CoinSet)rhs).denominations);
    }

    public @Override int hashCode() {
        return toString().hashCode();
    }


    public @Override String toString() {
        final Collection<String> items = new ArrayList<String>();
        for( Denomination item : denominations.keySet() ) {
            items.add( denominationToString( item ) );
        }
        return this.getClass().getSimpleName() + "<" + Helpers.stringJoin( items, Joiner.COMMA ) + ">";
    }

    private String denominationToString( Denomination den ) {
        String item = den.stringValue();
        item += "'s:";
        item += denominations.get( den ).stringValue();
        return item;
    }

    Collection<Denomination> getDenominations() {
        return denominations.keySet();
    }

    private CoinSet( CoinSet rhs ) {
        for( Denomination d: rhs.getDenominations() ) {
            denominations.put( d, rhs.getCardinality( d ));
        }
        sum = new Money( rhs.sum );
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
        setCardinality( denomination, Cardinality.getInstance( card.intValue() + 1 ));
        sum.addCoin( denomination );
    }

}
