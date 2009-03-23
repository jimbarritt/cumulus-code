package org.ixcode.cumulus.feedcloud.spike.time;

import org.apache.commons.lang.builder.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;

public class Milliseconds implements UnitOfTime {

    private long milliseconds;

    public Milliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public long convert(TimeConverter timeConverter) {
        return timeConverter.convertFrom(milliseconds);
    }

    public Milliseconds elapsedFrom(Milliseconds startTimeMilliSeconds) {
        return new Milliseconds(milliseconds - startTimeMilliSeconds.milliseconds);
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
