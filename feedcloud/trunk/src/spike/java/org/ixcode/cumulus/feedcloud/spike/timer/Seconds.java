package org.ixcode.cumulus.feedcloud.spike.timer;

import org.apache.commons.lang.builder.*;

public class Seconds {

    private long seconds;

    public Seconds(long seconds) {
        this.seconds = seconds;
    }

    public long longValue() {
        return seconds;
    }

    public String toString() {
        return seconds + " s";
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hasCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
