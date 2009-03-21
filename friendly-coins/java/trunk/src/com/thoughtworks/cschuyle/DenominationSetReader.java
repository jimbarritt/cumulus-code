package com.thoughtworks.cschuyle;

import java.util.StringTokenizer;
import java.util.Collection;
import java.util.ArrayList;

public class DenominationSetReader {

    public static DenominationSet read( String inputLine ) {
        return readLine(inputLine);
    }

    static DenominationSet readLine(String inputLine) {
        StringTokenizer stok = new StringTokenizer(inputLine);
        Collection<Integer> vals = new ArrayList<Integer>();
        while(stok.hasMoreTokens()) {
            readSingleValue(stok, vals);
        }
        return new DenominationSet( vals.toArray( new Integer[vals.size()] ));
    }

    private static void readSingleValue(StringTokenizer stok, Collection<Integer> vals) {
        final int i = readInt(stok);
        if(vals.contains(i)) {
            throw new IllegalArgumentException("Attempt to add a duplicate denomination, " + i + " cents");
        }
        vals.add(i);
    }

    static int readInt(StringTokenizer stok) {
        return Integer.parseInt(stok.nextToken());
    }
}
