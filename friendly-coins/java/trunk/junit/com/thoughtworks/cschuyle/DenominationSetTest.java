package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.List;
import java.util.ArrayList;

import static com.thoughtworks.cschuyle.TestConstants.*;

public class DenominationSetTest extends TestCase {

    public void testGetSortedList() {
        DenominationSet den = new DenominationSet( ONE );
        List<Denomination> list = den.getSortedList();
        List<Denomination> expected = new ArrayList<Denomination>();
        expected.add(Denomination.getInstance( 1 ));
        assertEquals( expected, list );
    }

    public void testHighest() {
        DenominationSet den = new DenominationSet( ONE );
        final Denomination highest = den.highest();
        assertEquals( ONE, highest );
    }

    public void testHighestSimple() {
        DenominationSet den = new DenominationSet( ONE, TWO );
        final Denomination highest = den.highest();
        assertEquals( TWO, highest );
    }

    public void testHighestSimpleBackwards() {
        DenominationSet den = new DenominationSet( TWO, ONE );
        final Denomination highest = den.highest();
        assertEquals( TWO, highest );
    }

    public void testHighestEmpty() {
        DenominationSet den = new DenominationSet();
        try {
            den.highest();
            fail();
        } catch( IllegalStateException e) {
        }
    }

    public void testToString() {
        DenominationSet den = new DenominationSet( TWO, ONE );
        assertEquals( "DenominationSet<Denomination<1>,Denomination<2>>", den.toString() );        
    }

}
