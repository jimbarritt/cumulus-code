package com.thoughtworks.cschuyle;

import java.util.StringTokenizer;
import java.util.Collection;
import java.util.ArrayList;

public class DenominationSetReader {

    private DenominationSetReader() {}

    public static DenominationSet read( String inputLine ) {
        return readLine( inputLine );
    }

    static DenominationSet readLine( String inputLine ) {
        StringTokenizer stok = new StringTokenizer( inputLine );
        Collection<Denomination> vals = new ArrayList<Denomination>();
        while(stok.hasMoreTokens()) {
            readSingleValue( stok, vals );
        }
        final Denomination[] target = new Denomination[ vals.size() ];
        return new DenominationSet( vals.toArray( target ));
    }

    private static void readSingleValue( StringTokenizer stok, Collection<Denomination> vals ) {
        final int i = readInt( stok );
        final Denomination d = Denomination.getInstance( i );
        if( vals.contains( d ) ) {
            throw new IllegalArgumentException( "Attempt to add a duplicate value, " + i + " cents" );
        }
        vals.add( d );
    }

    static int readInt( StringTokenizer stok ) {
        final String nextToken = stok.nextToken();
        return Integer.parseInt( nextToken );
    }
}
