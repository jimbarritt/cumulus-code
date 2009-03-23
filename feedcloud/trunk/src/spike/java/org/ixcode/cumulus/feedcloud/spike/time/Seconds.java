package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;

public class Seconds implements UnitOfTime {

    private long seconds;

    public Seconds(long seconds) {
        this.seconds = seconds;
    }

    public String toString() {
        return seconds + " s";
    }

    public long convert(TimeConverter timeConverter) {
        return timeConverter.convertFrom(seconds);
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


}
