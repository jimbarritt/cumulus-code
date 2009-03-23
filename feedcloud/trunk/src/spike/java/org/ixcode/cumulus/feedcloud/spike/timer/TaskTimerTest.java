package org.ixcode.cumulus.feedcloud.spike.timer;

import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.ixcode.cumulus.feedcloud.spike.time.*;
import static junit.framework.Assert.assertEquals;

public class TaskTimerTest {

    @Test
    public void timesATask() {
        ExampleTask exampleTask = new ExampleTask();
        StopWatch stopWatch = mock(StopWatch.class);
        TaskTimer timer = new TaskTimer(exampleTask, stopWatch);

        when(stopWatch.getElapsedTime()).thenReturn(new Milliseconds(66L));
        Milliseconds elapsedTime = timer.time(6);

        assertEquals(new Milliseconds(66L), elapsedTime);
        assertEquals(6, exampleTask.getNumberOfTimesRun());

    }


    private static class ExampleTask implements Runnable {
        private int numberOfTimesRun;

        public void run() {
            numberOfTimesRun++;
        }

        public int getNumberOfTimesRun() {
            return numberOfTimesRun;
        }
    }
    
}
