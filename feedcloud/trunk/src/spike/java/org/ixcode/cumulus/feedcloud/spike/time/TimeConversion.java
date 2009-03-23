package org.ixcode.cumulus.feedcloud.spike.time;

import org.ixcode.cumulus.feedcloud.spike.time.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;

public class TimeConversion {

    private TimeConversion() {

    }

    public static Seconds toSeconds(Minutes minutes) {
        return new Seconds(minutes.convert(multiplyBy(60)));
    }

    private static TimeConverter divideBy(long factor) {
        return new DivideBy(factor);                        
    }

    private static TimeConverter multiplyBy(long factor) {
        return new MultiplyBy(factor);
    }
}
