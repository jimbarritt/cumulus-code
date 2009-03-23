package org.ixcode.cumulus.feedcloud.spike.time;

import org.ixcode.cumulus.feedcloud.spike.time.convert.*;
import org.apache.commons.lang.builder.*;

abstract class UnitOfTime {
    private long longValue;
    private String toStringFormat;

    protected UnitOfTime(long longValue, String toStringFormat) {
        this.longValue = longValue;
        this.toStringFormat = toStringFormat;
    }

    protected long getLongValue() {
        return longValue;
    }
  
    public long convert(TimeConverter timeConverter) {
        return timeConverter.convertFrom(longValue);
    }

    public boolean equals(Object other)  {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String toString() {
        return String.format(toStringFormat, longValue);
    }
}
