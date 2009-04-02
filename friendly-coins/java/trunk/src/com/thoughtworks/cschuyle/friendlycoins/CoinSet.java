package com.thoughtworks.cschuyle.friendlycoins;

import java.util.*;
import com.thoughtworks.cschuyle.util.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.*;
import static com.thoughtworks.cschuyle.util.Joiner.*;

public class CoinSet {

    private Money total = new Money();
    private Map<Denomination, Cardinality> denominations = new HashMap<Denomination, Cardinality>();
                              
    private CoinSet( Denomination... denominations ) {
        for( Denomination denomination : denominations ) {
            incrementDenomination( denomination );
        }
    }

    // Factory methods

    public static CoinSet createCoinSet( Denomination... denominations ) {
        return new CoinSet( denominations ) ;
    }

    // TODO To optimize, make coinSet mutable and change this to .addCoin()
    public static CoinSet createAugmentedCoinSet( CoinSet coinSet, Denomination denomination ) {
        return new CoinSet( coinSet, denomination );
    }

    //

    public Money total() {
        return this.total;
    }

    public Cardinality getCoinCount( Denomination denomination ) {
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

    public Cardinality getTotalCoinCount() {
        final Collection<Cardinality> denominationsValues = denominations.values();
        return Cardinality.total( denominationsValues );
    }

    public @Override boolean equals( Object rhs ) {
        if( ! ( rhs instanceof CoinSet ) ) {
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
        final Collection<String> coinQuantities = new ArrayList<String>();
        for( Denomination denomination : this.denominations.keySet() ) {
            coinQuantities.add( denominationAndCardinalityToString( denomination ) );
        }
        final String className = ClassHelpers.simpleName( this );
        final String body = StringHelpers.join( coinQuantities, COMMA );
        return className + "<" + body + ">";
    }

    // TODO Could use a refactor: Denomination + quantity smells primitive.
    private String denominationAndCardinalityToString( Denomination den ) {
        String item = den.stringValue();
        item += "'s:";
        final Cardinality card = denominations.get(den);
        item += card.stringValue();
        return item;
    }

    private Collection<Denomination> getDenominations() {
        return denominations.keySet();
    }

    private CoinSet( CoinSet rhs ) {
        for( Denomination denomination: rhs.getDenominations() ) {
            final Cardinality rhsDenominationCount = rhs.getCoinCount( denomination );
            denominations.put( denomination, rhsDenominationCount );
        }
        total = new Money( rhs.total() );
    }

    private CoinSet( CoinSet coinSet, Denomination denomination ) {
        this( coinSet );
        incrementDenomination( denomination );
    }

    boolean containsDenomination( Denomination d ) {
        return denominations.containsKey( d );
    }

    private void incrementDenomination( Denomination denomination ) {
        Cardinality cardinality = getCoinCount( denomination );
        final int cardinalityPlus1 = cardinality.intValue() + 1;
        setCardinality( denomination, Cardinality.getInstance( cardinalityPlus1 ));
        total.addCoin( denomination );
    }
}
