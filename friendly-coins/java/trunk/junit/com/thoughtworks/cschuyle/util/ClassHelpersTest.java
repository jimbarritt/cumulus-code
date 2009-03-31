package com.thoughtworks.cschuyle.util;

import junit.framework.TestCase;

public class ClassHelpersTest extends TestCase {

    static class A {}

    public void test() {
        String aName = ClassHelpers.simpleName( new A() );
        assertEquals( "A", aName );
    }
}
