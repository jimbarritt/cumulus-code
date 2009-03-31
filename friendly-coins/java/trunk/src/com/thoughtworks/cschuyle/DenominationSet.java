package com.thoughtworks.cschuyle;

import com.thoughtworks.cschuyle.util.Helpers;

import java.util.*;

import static com.thoughtworks.cschuyle.util.Joiner.COMMA;

public class DenominationSet {

    Collection<Denomination> list;

    public DenominationSet() {
        list = new ArrayList<Denomination>();
    }

    public DenominationSet( Denomination ... list ) {
        this();
        for( Denomination i : list ) {
            add( i );
        }
    }
    
    public int size() {
        return list.size();
    }

    public Iterator<Denomination> iterator() {
        return list.iterator();
    }

    public boolean contains(Denomination d) {
        return list.contains( d );
    }

    public List<Denomination> getSortedList() {
        List<Denomination> ret = new ArrayList<Denomination>( this.list );
        Collections.sort( ret );
        return ret;
    }

    public Denomination highest() {
        final List<Denomination> list = getSortedList();
        final int listSize = list.size();
        if( listSize > 0 ) {
            return list.get( listSize - 1 );
        }
        throw new IllegalStateException( "Cannot get highest element from empty list");
    }

    public @Override String toString() {
        List<Denomination> orderedList = getSortedList();
        String ret =  this.getClass().getSimpleName() + "<";
        ret += Helpers.stringJoin( orderedList, COMMA ) + ">";
        return ret;
    }

    private void add( Denomination d ) {
        list.add( d );
    }

    public boolean isEmpty() {
        return ( 0 == list.size() );
    }
}
