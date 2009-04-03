package com.thoughtworks.cschuyle.friendlycoins.model.primitives;

import junit.framework.TestCase;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;

public class DenominationTest extends TestCase {


    public void testSingleton() {
        Denomination denomination1 = Denomination.getInstance( 1 );
        Denomination denomination1again = Denomination.getInstance( 1 );
        assertSame( denomination1, denomination1again );
    }

    public void testSingletonNotSame() {
        Denomination denomination1 = Denomination.getInstance( 1 );
        Denomination denomination2 = Denomination.getInstance( 2 );
        assertNotSame( denomination1, denomination2 );
    }

}
