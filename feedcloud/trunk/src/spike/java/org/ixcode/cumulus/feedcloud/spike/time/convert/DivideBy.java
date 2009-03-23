package org.ixcode.cumulus.feedcloud.spike.time.convert;

public class DivideBy implements TimeConverter {
    private long factor;

    public DivideBy(long factor) {
        this.factor = factor;
    }

    public long convertFrom(long source) {
        return source / factor;
    }
}
