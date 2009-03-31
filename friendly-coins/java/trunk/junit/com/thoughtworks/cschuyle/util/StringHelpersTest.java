package com.thoughtworks.cschuyle.util;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.Arrays;

public class StringHelpersTest extends TestCase {

    public void testJoinNullCollection() {
        try {
            String joined = StringHelpers.join( null, null );
            fail();
        } catch( NullPointerException e ) {
                 /* GULP */
        }
    }

    public void testJoinOneElement() {
        Object[] collection = new Object[] { "1" };
        Collection<Object> collection2 = Arrays.asList( collection );
        String joined = StringHelpers.join( collection2, null );
        assertEquals( "1", joined);
    }

    public void testJoinOneNullElement() {
        Object[] collection = new Object[] { null };
        Collection<Object> collection2 = Arrays.asList( collection );
        String joined = StringHelpers.join( collection2, null );
        assertEquals( "null", joined);
    }

    public void testJoinTwoElementsWithNullJoiner() {
        Object[] collection = new Object[] { "1", "2" };
        Collection<Object> collection2 = Arrays.asList( collection );
        String joined = StringHelpers.join( collection2, null );
        assertEquals( "1null2", joined);
    }

    public void testJoinTwoElementsWithNonNullJoiner() {
        Object[] collection = new Object[] { "1", "2" };
        Collection<Object> collection2 = Arrays.asList( collection );
        String joined = StringHelpers.join( collection2, StringHelpers.Joiner.COMMA );
        assertEquals( "1,2", joined);
    }

    static class MyObject {
        private String className;

        public MyObject( Object object ) {
            className = object.getClass().getSimpleName();
        }

        public @Override String toString() {
            return className;
        }
    }

    public void testJoinTwoObjectsWithNonNullJoiner() {
        final StringHelpers.Joiner comma = StringHelpers.Joiner.COMMA;
        Object[] collection = new Object[] { new MyObject( this ), new MyObject( comma ) };
        Collection<Object> collection2 = Arrays.asList( collection );
        String joined = StringHelpers.join( collection2, comma );
        assertEquals( "StringHelpersTest,Joiner", joined );
    }
}


