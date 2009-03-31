package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.StringHelpers;
import com.thoughtworks.cschuyle.util.ClassHelpers;

import java.util.*;

import static com.thoughtworks.cschuyle.util.StringHelpers.Joiner.COMMA;

public class DenominationSet {

    Collection<Denomination> denominations;

    public DenominationSet() {
        denominations = new ArrayList<Denomination>();
    }

    public DenominationSet( Denomination ... denominations ) {
        this();
        for( Denomination denomination : denominations ) {
            add( denomination );
        }
    }
    
    public int size() {
        return denominations.size();
    }

    public Iterator<Denomination> iterator() {
        return denominations.iterator();
    }

    public boolean contains( Denomination denomination ) {
        return denominations.contains( denomination );
    }

    public List<Denomination> getOrderedList() {
        List<Denomination> sortedList = new ArrayList<Denomination>( this.denominations);
        Collections.sort( sortedList );
        return sortedList;
    }

    public Denomination highest() {
        final List<Denomination> list = getOrderedList();
        final int listLength = list.size();
        if( listLength > 0 ) {
            return list.get( listLength - 1 );
        }
        throw new IllegalStateException( "Cannot get highest element from empty list" );
    }

    public @Override String toString() {
        List<Denomination> orderedList = getOrderedList();
        final String className = ClassHelpers.simpleName( this );
        return className + "<"
            + StringHelpers.join( orderedList, COMMA )
            + ">";
    }

    private void add( Denomination denomination ) {
        denominations.add( denomination );
    }

    public boolean isEmpty() {
        return ( 0 == denominations.size() );
    }
}
