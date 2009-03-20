package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

import java.util.List;
import java.util.ArrayList;

public class DenominationSetTest extends TestCase {

    public void testGetSortedList() {
        DenominationSet den = new DenominationSet( 1 );
        List<Integer> list = den.getSortedList();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add( 1 );
        assertEquals( expected, list );
    }

    public void testHighest() {
        DenominationSet den = new DenominationSet( 1 );
        final int highest = den.highest();
        assertEquals( 1, highest );
    }

    public void testHighestSimple() {
        DenominationSet den = new DenominationSet( 1, 2 );
        final int highest = den.highest();
        assertEquals( 2, highest );
    }

    public void testHighestSimpleBackwards() {
        DenominationSet den = new DenominationSet( 2, 1 );
        final int highest = den.highest();
        assertEquals( 2, highest );
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
        DenominationSet den = new DenominationSet( 2, 1 );
        assertEquals( "DenominationSet<1,2>", den.toString() );        
    }

}
