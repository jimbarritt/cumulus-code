package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class WrappedIntegerTest extends TestCase {

    public void testEquality() {
        assertTrue( new AbstractWrappedInteger( 1 ) {}.equals( new AbstractWrappedInteger( 1 ) {} ) );
    }
}
