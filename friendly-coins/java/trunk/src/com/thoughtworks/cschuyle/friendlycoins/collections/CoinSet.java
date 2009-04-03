package com.thoughtworks.cschuyle.friendlycoins.collections;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Cardinality;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.AbstractWrappedInteger;

public class CoinSet extends CoinSetBase {

    public CoinSet( Denomination... denominations ) {
        for( Denomination denomination : denominations ) {
            incrementDenomination( denomination );
        }
    }

    // Factory methods

    public static CoinSet deepCopy( CoinSet rhs ) {
        CoinSet newCoinSet = new CoinSet();
        final CoinRollCollection rhsCoinRolls = rhs.coinRolls;
        newCoinSet.coinRolls = rhsCoinRolls.deepCopy();
        final Money copyOfRhsTotal = new Money( rhs.total );
        newCoinSet.total = copyOfRhsTotal;
        return newCoinSet;
    }
    
    // TODO To optimize, make coinSet mutable and change this to .addCoin()
    public static CoinSet createAugmentedCoinSet( CoinSet coinSet, Denomination denomination ) {
        CoinSet newCoinSet = deepCopy( coinSet );
        newCoinSet.incrementDenomination( denomination );
        return newCoinSet;
    }

    private void incrementDenomination( Denomination denomination ) {
        Cardinality cardinality = denominationCount( denomination );
        final AbstractWrappedInteger cardinalityPlus1 = cardinality.plusOne();
        setDenominationCount( denomination, Cardinality.getInstance( cardinalityPlus1 ));
        total.addCoin( denomination );
    }

    protected void setDenominationCount( Denomination denomination, Cardinality count ) {
        coinRolls.put( new CoinRoll( denomination,  count ) );
    }
}
