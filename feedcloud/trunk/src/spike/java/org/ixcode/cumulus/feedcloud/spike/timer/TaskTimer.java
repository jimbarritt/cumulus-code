package org.ixcode.cumulus.feedcloud.spike.timer;

import org.ixcode.cumulus.feedcloud.spike.time.*;

public class TaskTimer {

    private final Runnable task;
    private final StopWatch stopWatch;

    public TaskTimer(Runnable task, StopWatch stopWatch) {
        this.task = task;
        this.stopWatch = stopWatch;
    }

    public Milliseconds time(int numberOfExecutions) {
        stopWatch.start();

        for (int i=0;i<numberOfExecutions;++i) {
            task.run();
        }

        stopWatch.stop();
        return stopWatch.getElapsedTime();
    }
}
