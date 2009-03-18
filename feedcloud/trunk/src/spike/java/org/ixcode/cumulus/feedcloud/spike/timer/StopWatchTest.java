package org.ixcode.cumulus.feedcloud.spike.timer;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class StopWatchTest {

    @Test
    public void calculatesElapsedTime() {
        SystemClock systemClock = mock(SystemClock.class);

        StopWatch stopWatch = new StopWatch(systemClock);

        when(systemClock.getCurrentTimeMilliseconds()).thenReturn(20L);
        stopWatch.start();

        when(systemClock.getCurrentTimeMilliseconds()).thenReturn(62L);
        stopWatch.stop();

        assertEquals("elapsedTime", new Milliseconds(42), stopWatch.getElapsedTime());
    }
}
