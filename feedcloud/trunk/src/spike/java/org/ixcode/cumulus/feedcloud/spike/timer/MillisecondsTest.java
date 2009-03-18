package org.ixcode.cumulus.feedcloud.spike.timer;

import static org.junit.Assert.*;
import org.junit.*;

public class MillisecondsTest {

    @Test
    public void convertsToSeconds() {
        Milliseconds milliseconds = new Milliseconds(1000);

        Seconds seconds = milliseconds.toSeconds();

        assertEquals("toSeconds", new Seconds(1), seconds);
    }

    @Test
    public void calculatesElapsedTime() {
        Milliseconds start = new Milliseconds(10L);
        Milliseconds stop = new Milliseconds(20L);

        Milliseconds elapsed = stop.elapsedFrom(start);
        
        assertEquals("elapsed", new Milliseconds(10L), elapsed);
    }
}
