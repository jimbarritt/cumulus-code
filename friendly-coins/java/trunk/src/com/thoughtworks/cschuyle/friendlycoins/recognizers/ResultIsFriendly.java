package com.thoughtworks.cschuyle.friendlycoins.recognizers;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;

public class ResultIsFriendly extends FriendlinessResult {

    public ResultIsFriendly( Money checkedUpTo ) {
        super("Verified friendly up to " + checkedUpTo );
    }

    public boolean isFriendly() {
        return true;
    }
}
