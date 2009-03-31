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
        Collection<Denomination> destinationSet = new ArrayList<Denomination>();
        while( stok.hasMoreTokens() ) {
            readSingleValue( stok, destinationSet );
        }
        final Denomination[] target = new Denomination[ destinationSet.size() ];
        return new DenominationSet( destinationSet.toArray( target ));
    }

    private static void readSingleValue( StringTokenizer stok, Collection<Denomination> destinationSet ) {
        final int value = readInt( stok );
        final Denomination denomination = Denomination.getInstance( value );
        if( destinationSet.contains( denomination ) ) {
            throw new IllegalArgumentException( "Attempt to add a duplicate value, " + value + " cents" );
        }
        destinationSet.add( denomination );
    }

    static int readInt( StringTokenizer stok ) {
        final String nextToken = stok.nextToken();
        return Integer.parseInt( nextToken );
    }
}
