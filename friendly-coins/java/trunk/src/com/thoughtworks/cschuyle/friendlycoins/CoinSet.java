package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.util.*;
import com.thoughtworks.cschuyle.friendlycoins.primitives.*;
import static com.thoughtworks.cschuyle.util.Joiner.*;

public class CoinSet {

    private Money total = new Money();

    private CoinRollCollection coinRolls = new CoinRollCollection();

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
            return coinRolls.get( denomination.intValue() ).getCount();
        }
        Cardinality zero = Cardinality.getInstance( 0 );
        return zero;
    }

    private void setCount( Denomination denomination, Cardinality count ) {
        coinRolls.put( denomination.intValue(), new CoinRoll( denomination,  count ) );
    }

    public Cardinality getTotalCoinCount() {
        return coinRolls.getTotalCoinCount();
    }

    public @Override boolean equals( Object rhs ) {
        if( ! (rhs instanceof CoinSet ) ) {
            return false;
        }
        final CoinSet rhsCoinSet = (CoinSet) rhs;
        final CoinRollCollection rhsCoinRolls = rhsCoinSet.coinRolls;
        return( this.coinRolls.equals( rhsCoinRolls ) );
    }

    public @Override int hashCode() {
        return coinRolls.hashCode();
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        final String body = StringHelpers.join( coinRolls.values(), COMMA );
        return className + "<" + body + ">";
    }

    private CoinSet( CoinSet rhs ) {
        this.coinRolls = rhs.coinRolls.deepCopy();
        total = new Money( rhs.total() );
    }

    private CoinSet( CoinSet coinSet, Denomination denomination ) {
        this( coinSet );
        incrementDenomination( denomination );
    }

    private boolean containsDenomination( Denomination d ) {
        return coinRolls.containsKey( d.intValue() );
    }

    private void incrementDenomination( Denomination denomination ) {
        Cardinality cardinality = getCoinCount( denomination );
        final int cardinalityPlus1 = cardinality.intValue() + 1;
        setCount( denomination, Cardinality.getInstance( cardinalityPlus1 ));
        total.addCoin( denomination );
    }
}
