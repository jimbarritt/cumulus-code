package org.ixcode.cumulus.feedcloud.spike.timer;

import org.ixcode.cumulus.feedcloud.spike.time.*;

public class StopWatch {

    private SystemClock clock;
    private Timings timings = new Timings();

    public static StopWatch newInstance() {
        return new StopWatch(new SystemClock());
    }

    StopWatch(SystemClock clock) {
        this.clock = clock;
    }

    public void start() {
        timings.startedAt(new Milliseconds(clock.getCurrentTimeMilliseconds()));
    }

    public void stop() {
        timings.stoppedAt(new Milliseconds(clock.getCurrentTimeMilliseconds()));
    }
    
    public Milliseconds getElapsedTime() {
        return timings.getElapsedTime();
    }
}
