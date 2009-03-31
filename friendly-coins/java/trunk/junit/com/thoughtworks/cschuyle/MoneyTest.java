package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.TestConstants.*;

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
        money.addCoin( ONE );
        assertEquals( 1, money.intValue() );
    }

    public void testRemoveCoin() {
        Money money = new Money();
        money.removeCoin( ONE );
        assertEquals( -1, money.intValue() );
    }
}
