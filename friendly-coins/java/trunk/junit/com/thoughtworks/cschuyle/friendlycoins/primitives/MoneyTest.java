package com.thoughtworks.cschuyle.friendlycoins.primitives;

import junit.framework.TestCase;

import com.thoughtworks.cschuyle.friendlycoins.TestConstants;

public class MoneyTest extends TestCase {

    public void testDefault() {
        Money money = new Money();
        assertEquals( 0, money.intValue() );
    }

    public void testConstructorInt() {
        Money money = new Money( 1 );
        assertEquals( 1, money.intValue() );
    }

    public void testAddCoin() {
        Money money = new Money();
        assertEquals( 0, money.intValue() );
        money.addCoin(TestConstants.ONER);
        assertEquals( 1, money.intValue() );
    }

    public void testRemoveCoin() {
        Money money = new Money();
        money.removeCoin(TestConstants.ONER);
        assertEquals( -1, money.intValue() );
    }
}
