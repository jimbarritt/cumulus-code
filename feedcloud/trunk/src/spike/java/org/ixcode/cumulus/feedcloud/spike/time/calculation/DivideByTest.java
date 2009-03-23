package org.ixcode.cumulus.feedcloud.spike.time.calculation;

import org.junit.*;
import static junit.framework.Assert.assertEquals;

public class DivideByTest {

    @Test
    public void dividesByAFactor() {
        DivideBy divideBy = new DivideBy(10);

        long result = divideBy.calculateFrom(1000);

        assertEquals(100, result);
    }
}
