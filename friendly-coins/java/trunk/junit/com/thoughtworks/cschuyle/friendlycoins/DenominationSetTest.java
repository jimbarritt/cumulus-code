package com.thoughtworks.cschuyle.friendlycoins;

import junit.framework.TestCase;
import junit.framework.Assert;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.friendlycoins.DenominationSet;

public class DenominationSetTest extends TestCase {

    public void testOrdering() {
        DenominationSet denominationSet1 = new DenominationSet( TestConstants.TWO, TestConstants.ONE );
        Collection<Denomination> list = new ArrayList<Denomination>();
        list.addAll( denominationSet1 );
        List<Denomination> expected = new ArrayList<Denomination>();
        expected.add( Denomination.getInstance( 2 ) );
        expected.add( Denomination.getInstance( 1 ) );
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
        assertEquals( "DenominationSet<Denomination<2>,Denomination<1>>", denominationSet21.toString() );
    }

}
