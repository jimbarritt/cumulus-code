package org.ixcode.cumulus.feedcloud.spike.time.convert;

import org.junit.*;
import static junit.framework.Assert.assertEquals;

public class DivideByTest {

    @Test
    public void dividesByAFactor() {
        DivideBy divideBy = new DivideBy(10);

        long result = divideBy.convertFrom(1000);

        assertEquals(100, result);
    }
}
