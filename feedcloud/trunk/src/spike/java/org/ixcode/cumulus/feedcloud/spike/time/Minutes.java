package org.ixcode.cumulus.feedcloud.spike.time;

public class Minutes extends UnitOfTime<Minutes> {

    public Minutes(long minutes) {
        super(minutes, "%d min");
    }

    protected Minutes newInstance(long longValue) {
        return new Minutes(longValue);
    }
}
