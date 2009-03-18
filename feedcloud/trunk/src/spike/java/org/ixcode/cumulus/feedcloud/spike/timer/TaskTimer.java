package org.ixcode.cumulus.feedcloud.spike.timer;

class TaskTimer {

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
