package com.thoughtworks.cschuyle;

import java.util.*;

public class SortedWrappedIntegerList<T extends AbstractWrappedInteger> extends TreeSet<T> {

    public SortedWrappedIntegerList() {
        super( new Comparator<AbstractWrappedInteger>() {

            public int compare( AbstractWrappedInteger wrappedInteger, AbstractWrappedInteger wrappedInteger1 ) {
                return - wrappedInteger.compareTo( wrappedInteger1 );
            }
        });
    }
}
