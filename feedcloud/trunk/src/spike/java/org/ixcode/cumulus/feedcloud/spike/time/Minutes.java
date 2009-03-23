package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;

public class Minutes {
    private long minutes;

    public Minutes(long minutes) {
        this.minutes = minutes;
    }


    public String toString() {
        return minutes + " min";
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public long longValue() {
        return minutes;        
    }
}
