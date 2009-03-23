package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;

public class Minutes implements TimeUnit {
    private long minutes;

    public Minutes(long minutes) {
        this.minutes = minutes;
    }

    public String toString() {
        return minutes + " min";
    }

    public long convert(TimeConverter timeConverter) {
        return timeConverter.convertFrom(minutes);
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
