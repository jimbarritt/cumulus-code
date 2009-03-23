package org.ixcode.cumulus.feedcloud.spike.timer;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import org.ixcode.cumulus.feedcloud.spike.time.*;

public class TimingsTest {

    @Test
    public void knowsElapsedTimePeriod() {
        Timings timings = new Timings();

        Milliseconds startTime = mock(Milliseconds.class);
        Milliseconds stopTime = mock(Milliseconds.class);

        timings.startedAt(startTime);
        timings.stoppedAt(stopTime);

        when(stopTime.elapsedFrom(startTime)).thenReturn(new Milliseconds(666L));

        Milliseconds elapsedTime = timings.getElapsedTime();

        assertEquals("elapsedTime", new Milliseconds(666L), elapsedTime);
    }
}
