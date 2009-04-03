package com.thoughtworks.cschuyle.friendlycoins.model;

import junit.framework.TestCase;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.TestConstants;

public class DenominationSetTest extends TestCase {

    public void testOrdering() {
        DenominationSet denominationSet1 = new DenominationSet( TestConstants.TWOER, TestConstants.ONER);
        Collection<Denomination> list = new ArrayList<Denomination>();
        list.addAll( denominationSet1 );
        List<Denomination> expected = new ArrayList<Denomination>();
        expected.add( Denomination.getInstance( 2 ) );
        expected.add( Denomination.getInstance( 1 ) );
        assertEquals( expected, list );
    }
    public void testToString() {
        DenominationSet denominationSet21 = new DenominationSet(TestConstants.TWOER, TestConstants.ONER);
        assertEquals( "DenominationSet<Denomination<2>,Denomination<1>>", denominationSet21.toString() );
    }

}
