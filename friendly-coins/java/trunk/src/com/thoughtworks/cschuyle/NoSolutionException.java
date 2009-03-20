package com.thoughtworks.cschuyle;

public class NoSolutionException extends RuntimeException {

    public NoSolutionException( String msg ) {
        super( msg );
    }

    public NoSolutionException(DenominationSet denominations, int total) {
        super( "There is no solution given the denominations " + denominations + " to give " + total + " cents change." );
    }
}
