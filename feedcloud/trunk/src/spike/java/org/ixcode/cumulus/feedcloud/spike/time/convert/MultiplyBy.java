package org.ixcode.cumulus.feedcloud.spike.time.convert;

public class MultiplyBy implements TimeConverter {
    private long factor;

    public MultiplyBy(long factor) {
        this.factor = factor;
    }

    public long convertFrom(long source) {
        return source * factor;
    }
}
