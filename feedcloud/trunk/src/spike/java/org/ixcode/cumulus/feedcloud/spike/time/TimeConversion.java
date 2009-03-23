package org.ixcode.cumulus.feedcloud.spike.time;

import org.ixcode.cumulus.feedcloud.spike.time.calculation.*;

public class TimeConversion {

    private TimeConversion() {

    }

    public static Seconds toSeconds(Minutes minutes) {
        return new Seconds(minutes.convert(multiplyBy(60)));
    }

    private static TimeCalculation divideBy(long factor) {
        return new DivideBy(factor);                        
    }

    private static TimeCalculation multiplyBy(long factor) {
        return new MultiplyBy(factor);
    }
}
