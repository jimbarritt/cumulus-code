package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.ClassHelpers;

import java.util.*;

import static com.thoughtworks.cschuyle.util.Joiner.COMMA;
import com.thoughtworks.cschuyle.friendlycoins.primitives.Denomination;
import com.thoughtworks.cschuyle.SortedList;

public class DenominationSet extends AbstractSet<Denomination> {

    private SortedList<Denomination> denominations;

    public DenominationSet( Denomination ... denominations ) {
        this.denominations = new SortedList<Denomination>();
        this.denominations.addAll( Arrays.asList( denominations ) );
    }
    
    public int size() {
        return denominations.size();
    }

    public Iterator<Denomination> iterator() {
        return denominations.iterator();
    }

    public Denomination highest() {
        if( denominations.size() > 0 ) {
            return denominations.first();
        }
        throw new IllegalStateException( "Cannot get highest element from empty list" );
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
