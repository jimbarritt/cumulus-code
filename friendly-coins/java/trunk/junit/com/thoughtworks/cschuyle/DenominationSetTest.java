package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.List;
import java.util.ArrayList;

import static com.thoughtworks.cschuyle.TestConstants.*;

public class DenominationSetTest extends TestCase {

    public void testGetOrderedList() {
        DenominationSet denominationSet1 = new DenominationSet( TWO, ONE );
        List<Denomination> list = denominationSet1.getOrderedList();
        List<Denomination> expected = new ArrayList<Denomination>();
        expected.add( Denomination.getInstance( 1 ) );
        expected.add( Denomination.getInstance( 2 ) );
        assertEquals( expected, list );
    }

    public void testHighest() {
        DenominationSet denominationSet1 = new DenominationSet( ONE );
        final Denomination highest = denominationSet1.highest();
        assertEquals( ONE, highest );
    }

    public void testHighestSimple() {
        DenominationSet DenominationSet12 = new DenominationSet( ONE, TWO );
        final Denomination highest = DenominationSet12.highest();
        assertEquals( TWO, highest );
    }

    public void testHighestSimpleBackwards() {
        DenominationSet denominationSet21 = new DenominationSet( TWO, ONE );
        final Denomination highest = denominationSet21.highest();
        assertEquals( TWO, highest );
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
        DenominationSet denominationSet21 = new DenominationSet( TWO, ONE );
        assertEquals( "DenominationSet<Denomination<1>,Denomination<2>>", denominationSet21.toString() );
    }

}
