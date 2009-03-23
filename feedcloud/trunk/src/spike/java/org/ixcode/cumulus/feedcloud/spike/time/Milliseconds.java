package org.ixcode.cumulus.feedcloud.spike.time;

public class Milliseconds extends UnitOfTime {

    public Milliseconds(long milliseconds) {
        super(milliseconds, "%d ms");
    }

    public Milliseconds elapsedFrom(Milliseconds startTime) {
        return new Milliseconds(getLongValue() - startTime.getLongValue());
    }

}
