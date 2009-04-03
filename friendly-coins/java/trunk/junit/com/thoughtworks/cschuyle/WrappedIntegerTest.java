package com.thoughtworks.cschuyle;

import junit.framework.TestCase;

public class WrappedIntegerTest extends TestCase {

    public void testEquality() {
        final AbstractWrappedInteger anotherOne = new AbstractWrappedInteger(1) {};
        assertTrue( WrappedIntegerHelpers.ONE.equals( anotherOne) );
    }
}
