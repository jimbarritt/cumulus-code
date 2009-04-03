package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class WrappedIntegerTest extends TestCase {

    public void testEquality() {
        assertTrue( new WrappedInteger( 1 ).equals( new WrappedInteger( 1 ) ) );
    }
}
