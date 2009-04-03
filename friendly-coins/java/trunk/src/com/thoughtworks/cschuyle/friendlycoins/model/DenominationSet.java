package com.thoughtworks.cschuyle.friendlycoins.model;

import com.thoughtworks.cschuyle.util.*;

import java.util.*;

import static com.thoughtworks.cschuyle.util.Joiner.COMMA;
import com.thoughtworks.cschuyle.SortedWrappedIntegerList;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Denomination;

public class DenominationSet extends AbstractSet<Denomination> {

    private SortedWrappedIntegerList<Denomination> denominations;

    public DenominationSet( Denomination ... theDenominations ) {
        denominations = new SortedWrappedIntegerList<Denomination>();
        final List<Denomination> denominationsArr = Arrays.asList( theDenominations );
        denominations.addAll( denominationsArr );
    }
    
    public int size() {
        return denominations.size();
    }

    public Iterator<Denomination> iterator() {
        return denominations.iterator();
    }

    public @Override String toString() {
        final String className = ClassHelpers.simpleName( this );
        final String body = StringHelpers.join( denominations, COMMA );
        return className + "<" + body + ">";
    }

    public boolean add( Denomination denomination ) {
        return denominations.add( denomination );
    }

    public boolean isEmpty() {
        return ( 0 == denominations.size() );
    }
}
