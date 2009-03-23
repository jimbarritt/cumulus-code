package org.ixcode.cumulus.feedcloud.spike.time.calculation;

public class DivideBy implements TimeCalculation {
    private long factor;

    public DivideBy(long factor) {
        this.factor = factor;
    }

    public long calculateFrom(long source) {
        return source / factor;
    }
}
