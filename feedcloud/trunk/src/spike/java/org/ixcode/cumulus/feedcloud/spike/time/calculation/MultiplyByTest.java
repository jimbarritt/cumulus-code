package org.ixcode.cumulus.feedcloud.spike.time.calculation;

import org.junit.*;
import static junit.framework.Assert.assertEquals;

public class MultiplyByTest {

    @Test
    public void multipliesValue() {
        MultiplyBy multiplyBy = new MultiplyBy(10L);

        long result = multiplyBy.calculateFrom(10L);

        assertEquals(100, result);
    }
}
