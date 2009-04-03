package com.thoughtworks.cschuyle.friendlycoins.recognizers;

public class ResultError extends ResultNotFriendly {

    public ResultError( Exception e ) {
        super( e.getMessage() );
    }

}
