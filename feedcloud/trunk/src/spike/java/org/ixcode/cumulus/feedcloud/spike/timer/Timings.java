package org.ixcode.cumulus.feedcloud.spike.timer;

class Timings {

    private Milliseconds startTime;
    private Milliseconds stopTime;

    public void startedAt(Milliseconds startTime) {
        this.startTime = startTime;
    }

    public void stoppedAt(Milliseconds stopTime)  {
        this.stopTime = stopTime;
    }

    public Milliseconds getElapsedTime() {
        return stopTime.elapsedFrom(startTime);
    }
}
