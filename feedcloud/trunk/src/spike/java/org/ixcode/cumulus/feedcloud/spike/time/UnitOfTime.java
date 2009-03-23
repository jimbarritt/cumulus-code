package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;
import org.ixcode.cumulus.feedcloud.spike.time.calculation.*;

abstract class UnitOfTime<T extends UnitOfTime> {
    private long longValue;
    private String toStringFormat;

    protected UnitOfTime(long longValue, String toStringFormat) {
        this.longValue = longValue;
        this.toStringFormat = toStringFormat;
    }

    protected long getLongValue() {
        return longValue;
    }

    public long convert(TimeCalculation timeCalculation) {
        return timeCalculation.calculateFrom(longValue);
    }

    public T elapsedFrom(T startTime) {
        return newInstance(longValue - startTime.longValue);
    }

    protected abstract T newInstance(long longValue);


    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String toString() {
        return String.format(toStringFormat, longValue);
    }
}
