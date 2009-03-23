package org.ixcode.cumulus.feedcloud.spike.time;

public class Milliseconds extends UnitOfTime<Milliseconds> {

    public Milliseconds(long milliseconds) {
        super(milliseconds, "%d ms");
    }

    protected Milliseconds newInstance(long longValue) {
        return new Milliseconds(longValue);
    }
}
