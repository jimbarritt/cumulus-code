package com.thoughtworks.cschuyle.friendlycoins;

import junit.framework.TestCase;
import junit.framework.Assert;

import java.util.List;
import java.util.ArrayList;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;

public class DenominationSetTest extends TestCase {

    public void testGetOrderedList() {
        DenominationSet denominationSet1 = new DenominationSet(TestConstants.TWO, TestConstants.ONE);
        List<Denomination> list = denominationSet1.getOrderedList();
        List<Denomination> expected = new ArrayList<Denomination>();
        expected.add( Denomination.getInstance( 1 ) );
        expected.add( Denomination.getInstance( 2 ) );
        assertEquals( expected, list );
    }

    public void testHighest() {
        DenominationSet denominationSet1 = new DenominationSet(TestConstants.ONE);
        final Denomination highest = denominationSet1.highest();
        Assert.assertEquals(TestConstants.ONE, highest );
    }

    public void testHighestSimple() {
        DenominationSet DenominationSet12 = new DenominationSet(TestConstants.ONE, TestConstants.TWO);
        final Denomination highest = DenominationSet12.highest();
        Assert.assertEquals(TestConstants.TWO, highest );
    }

    public void testHighestSimpleBackwards() {
        DenominationSet denominationSet21 = new DenominationSet(TestConstants.TWO, TestConstants.ONE);
        final Denomination highest = denominationSet21.highest();
        Assert.assertEquals(TestConstants.TWO, highest );
    }

    public void testHighestEmpty() {
        DenominationSet denominationSet = new DenominationSet();
        try {
            denominationSet.highest();
            fail();
        } catch( IllegalStateException e) {
        }
    }

    public void testToString() {
        DenominationSet denominationSet21 = new DenominationSet(TestConstants.TWO, TestConstants.ONE);
        assertEquals( "DenominationSet<Denomination<1>,Denomination<2>>", denominationSet21.toString() );
    }

}
