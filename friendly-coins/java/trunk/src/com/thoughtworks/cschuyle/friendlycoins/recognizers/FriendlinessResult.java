package com.thoughtworks.cschuyle.friendlycoins.recognizers;

public abstract class FriendlinessResult {

    protected String message = "";

    public FriendlinessResult( String theMessage ) {
        message = theMessage;
    }

    public String getMessage() {
        return message;
    }

    public abstract boolean isFriendly();
}
