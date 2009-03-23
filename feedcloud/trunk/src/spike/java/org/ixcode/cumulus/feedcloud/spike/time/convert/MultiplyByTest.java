package org.ixcode.cumulus.feedcloud.spike.time.convert;

import org.junit.*;
import static junit.framework.Assert.assertEquals;

public class MultiplyByTest {

    @Test
    public void multipliesValue() {
        MultiplyBy multiplyBy = new MultiplyBy(10L);

        long result = multiplyBy.convertFrom(10L);

        assertEquals(100, result);
    }
}
