package org.ixcode.cumulus.feedcloud.spike.time;

public class Milliseconds extends UnitOfTime {

    public Milliseconds(long milliseconds) {
        super(milliseconds);
    }

    public Milliseconds elapsedFrom(Milliseconds startTime) {
        return new Milliseconds(getLongValue() - startTime.getLongValue());
    }

    public String toString() {
        return getLongValue() + " ms";
    }


}
