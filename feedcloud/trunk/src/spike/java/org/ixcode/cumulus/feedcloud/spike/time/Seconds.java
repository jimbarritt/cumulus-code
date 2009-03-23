package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;

public class Seconds {

    private long seconds;

    public Seconds(long seconds) {
        this.seconds = seconds;
    }

    public long longValue() {
        return seconds;
    }

    public Minutes toMinutes() {
        return new Minutes(seconds / 60);
    }
    public String toString() {
        return seconds + " s";
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
