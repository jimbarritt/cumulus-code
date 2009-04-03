package com.thoughtworks.cschuyle;

public abstract class ComparableInteger implements WrappedInteger {

    public abstract boolean greaterThan( WrappedInteger rhs );

    public boolean lessThan( WrappedInteger rhs ) {
        return intValue() < rhs.intValue();
    }

    public boolean lessThanOrEqual( WrappedInteger rhs ) {
        return ! greaterThan( rhs );
    }

    public boolean greaterThanOrEqual( WrappedInteger rhs ) {
        return ! lessThan( rhs );
    }
}
