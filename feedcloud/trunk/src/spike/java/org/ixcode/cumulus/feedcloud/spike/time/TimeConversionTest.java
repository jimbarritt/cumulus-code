package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;

public class TimeConversionTest {

    @Test
    public void convertsMinutesToSeconds() {
        Seconds seconds = TimeConversion.toSeconds(new Minutes(60));

        assertEquals(new Seconds(3600), seconds);
    }

}
