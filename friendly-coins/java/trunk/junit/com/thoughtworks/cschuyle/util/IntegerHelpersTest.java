package com.thoughtworks.cschuyle.util;

import junit.framework.TestCase;

public class IntegerHelpersTest extends TestCase {

    public void testCompareEqual() {
        int comparison = IntegerHelpers.intCompareTo( 1, 1 );
        assertEquals( 0, comparison );
    }

    public void testCompareLess() {
        int comparison = IntegerHelpers.intCompareTo( 0, 1 );
        assertEquals( -1, comparison );
    }

    public void testCompareGreater() {
        int comparison = IntegerHelpers.intCompareTo( 1, 0 );
        assertEquals( 1, comparison );
    }
}
