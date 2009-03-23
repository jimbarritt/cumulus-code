package org.ixcode.cumulus.feedcloud.spike.time;

public class Seconds extends UnitOfTime<Seconds> {

    public Seconds(long seconds) {
        super(seconds, "%d s");
    }

    protected Seconds newInstance(long longValue) {
        return new Seconds(longValue);
    }
}
