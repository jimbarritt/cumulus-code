package org.ixcode.cumulus.feedcloud.spike.time;

import org.ixcode.cumulus.feedcloud.spike.time.convert.*;
import org.apache.commons.lang.builder.*;

public abstract class UnitOfTime {
    private long longValue;

    protected UnitOfTime(long longValue) {
        this.longValue = longValue;
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
}
