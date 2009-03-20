package com.thoughtworks.cschuyle;

import java.util.*;

class DenominationSet {

    Collection<Integer> list;

    public DenominationSet() {
        list = new ArrayList<Integer>();
    }

    public DenominationSet( Integer ... list ) {
        this();
        for( int i : list ) {
            add( i );
        }
    }
    
    public int size() {
        return list.size();
    }

    public Iterator<Integer> iterator() {
        return list.iterator();
    }

    public boolean contains(int i) {
        return list.contains( i );
    }


    public List<Integer> getSortedList() {
        ArrayList<Integer> ret = new ArrayList<Integer>( this.list );
        Collections.sort( ret );
        return ret;
    }

    public int highest() {
        final List<Integer> list = getSortedList();
        if(list.size() > 0) {
            return list.get( list.size() - 1 );
        }
        throw new IllegalStateException( "Cannot get highest element from empty list");
    }

    public @Override String toString() {
        String ret = null;
        List<Integer> orderedList = new ArrayList<Integer>( list );
        Collections.sort(orderedList);
        for( int i : orderedList ) {
            if( null == ret ) {
                ret = Integer.toString( i );
            } else {
                ret += "," + i;
            }
        }
        return this.getClass().getSimpleName() + "<" + ret + ">";
    }

    private void add(int i) {
        list.add(i);
    }

}
