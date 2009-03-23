package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;

public class MinutesTest {

    @Test
    public void providesAppropriateStringRepresentation() {
        Minutes minutes = new Minutes(34);
        assertEquals("34 min", minutes.toString());
    }
 
}
