package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.IntegerHelpers;

public class WrappedIntegerHelpers {

    private WrappedIntegerHelpers() {}

    public static boolean lessThan( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        return int1 < int2;
    }

    public static boolean greaterThan( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        return int1 > int2;
    }

    public static WrappedInteger minus( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        return new WrappedInteger( int1 - int2 ) {};
    }

    public static boolean areEqual( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        return ( int1 == int2 );
    }

    public static WrappedInteger compareTo( WrappedInteger value1, WrappedInteger value2 ) {
        final int int1 = value1.intValue();
        final int int2 = value2.intValue();
        final int comparison = IntegerHelpers.intCompareTo( int1, int2 );
        return new WrappedInteger( comparison ) {};
    }

    public static WrappedInteger sign( WrappedInteger value1 ) {
        final int int1 = value1.intValue();
        final int sign = (
                int1 < 0 
                        ? -1
                        : (int1 > 0
                            ? 1
                            : 0 ) );
        return new WrappedInteger( sign ) {};
    }
}

