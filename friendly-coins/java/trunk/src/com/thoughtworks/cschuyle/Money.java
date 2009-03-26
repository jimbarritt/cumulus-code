package com.thoughtworks.cschuyle;

public class Money extends WrappedInteger {

    public Money() {
        super( 0 );
    }

    public Money( int i ) {
        super( i );
    }

    public void addCoin( Denomination denomination ) {
        this.value += denomination.intValue();
        rehash();
    }

    public void removeCoin( Denomination denomination ) {
        this.value -= denomination.intValue();
        rehash();
    }

    public @Override boolean equals( Object rhsObj) {
        return (rhsObj instanceof Money && ((Money)rhsObj).intValue() == this.intValue() );
    }
}
