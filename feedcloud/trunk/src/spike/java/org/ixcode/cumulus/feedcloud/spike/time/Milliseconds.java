package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;

public class Milliseconds {

    private long milliseconds;

    public Milliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Milliseconds elapsedFrom(Milliseconds startTimeMilliSeconds) {
        return new Milliseconds(milliseconds - startTimeMilliSeconds.longValue());
    }
    
    public long longValue() {
        return milliseconds;
    }
    
    public Seconds toSeconds() {
        return new Seconds(milliseconds / 1000);
    }

    public String toString() {
        return milliseconds + " ms";
    }

    public boolean equals(Object other)  {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hasCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
