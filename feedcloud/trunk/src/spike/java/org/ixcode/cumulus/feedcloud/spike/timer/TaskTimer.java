package org.ixcode.cumulus.feedcloud.spike.timer;

import org.ixcode.cumulus.feedcloud.spike.time.*;

public class TaskTimer {

    Runnable task;

    public TaskTimer(Runnable task) {
        this.task = task;
    }

    public Milliseconds time(int numberOfExecutions) {
        StopWatch stopWatch = StopWatch.newInstance();
        stopWatch.start();

        for (int i=0;i<numberOfExecutions;++i) {
            task.run();
        }

        stopWatch.stop();
        return stopWatch.getElapsedTime();
    }
}
