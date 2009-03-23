package org.ixcode.cumulus.feedcloud.spike.time.calculation;

public class MultiplyBy implements TimeCalculation {
    private long factor;

    public MultiplyBy(long factor) {
        this.factor = factor;
    }

    public long calculateFrom(long source) {
        return source * factor;
    }
}
