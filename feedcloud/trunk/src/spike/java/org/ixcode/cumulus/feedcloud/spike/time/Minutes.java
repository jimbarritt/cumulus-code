package org.ixcode.cumulus.feedcloud.spike.time;

public class Minutes extends UnitOfTime {

    public Minutes(long minutes) {
        super(minutes);
    }

    public String toString() {
        return getLongValue() + " min";
    }

}
