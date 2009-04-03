package com.thoughtworks.cschuyle.friendlycoins.primitives;

import junit.framework.TestCase;

import com.thoughtworks.cschuyle.friendlycoins.TestConstants;
import static com.thoughtworks.cschuyle.WrappedIntegerHelpers.*;

public class MoneyTest extends TestCase {

    public void testDefault() {
        Money money = new Money();
        assertEquals( wrap( 0 ), money );
    }

    public void testConstructorInt() {
        Money money = new Money( 1 );
        assertEquals( wrap( 1 ), money );
    }

    public void testAddCoin() {
        Money money = new Money();
        assertEquals( wrap( 0 ), money );
        money.add(TestConstants.ONER);
        assertEquals( wrap( 1 ), money );
    }

    public void testRemoveCoin() {
        Money money = new Money();
        money.subtract(TestConstants.ONER);
        assertEquals( wrap( -1 ), money );
    }
}
