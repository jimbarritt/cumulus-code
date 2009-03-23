package org.ixcode.cumulus.feedcloud.spike.time;

public class Seconds extends UnitOfTime {

    public Seconds(long seconds) {
        super(seconds);
    }

    public String toString() {
        return getLongValue() + " s";
    }    

}
