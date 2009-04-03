package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.IntegerHelpers;

import java.util.*;

public class SortedWrappedIntegerList<T extends WrappedInteger> extends TreeSet<T> {

    public SortedWrappedIntegerList() {
        super( new Comparator<WrappedInteger>() {

            public int compare( WrappedInteger wrappedInteger, WrappedInteger wrappedInteger1 ) {
                return - IntegerHelpers.intCompareTo( wrappedInteger.intValue(), wrappedInteger1.intValue() );
            }
        });
    }
}
