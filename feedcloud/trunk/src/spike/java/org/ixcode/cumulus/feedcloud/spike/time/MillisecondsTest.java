package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;

public class MillisecondsTest {

    @Test
    public void providesAppropriateStringRepresentation() {
        Milliseconds milliseconds = new Milliseconds(34);
        assertEquals("34 ms", milliseconds.toString());
    }

}
