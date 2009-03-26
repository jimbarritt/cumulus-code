package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import static com.thoughtworks.cschuyle.TestConstants.*;

public class MoneyTest extends TestCase {

    public void testDefault() {
        Money m = new Money();
        assertEquals( 0, m.intValue() ); 
    }

    public void testConstructorInt() {
        Money m = new Money( 1 );
        assertEquals( 1, m.intValue() );
    }

    public void testAddCoin() {
        Money m = new Money();
        assertEquals( 0, m.intValue() );
        m.addCoin( ONE );
        assertEquals( 1, m.intValue() );
    }

    public void testRemoveCoin() {
        Money m = new Money();
        m.removeCoin( ONE );
        assertEquals( -1, m.intValue() );
    }
}
