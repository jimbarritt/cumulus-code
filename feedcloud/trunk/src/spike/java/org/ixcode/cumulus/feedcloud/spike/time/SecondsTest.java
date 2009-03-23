package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;

public class SecondsTest {

    @Test
    public void canConvertToString() {
        Seconds seconds = new Seconds(34);
        assertEquals("34 s", seconds.toString());
    }

}
