package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;

public class SecondsTest {

    @Test
    public void providesLongValue() {
        Seconds seconds = new Seconds(666);

        assertEquals("longValue", 666L, seconds.longValue());
    }

    @Test
    public void canConvertToString() {
        Seconds seconds = new Seconds(34);
        assertEquals("toString", "34 s", seconds.toString());
    }

    @Test
    public void canBeComparedForEquality() {
        Seconds seconds = new Seconds(34);
        Seconds secondsEqual = new Seconds(34);
        Seconds secondsNotEqual = new Seconds(666);

        assertEquals("equal", seconds, secondsEqual);
        assertFalse("not-equal", seconds.equals(secondsNotEqual));

        assertEquals("equal.hashcode", seconds.hashCode(), secondsEqual.hashCode());
        assertFalse("not-equal.hashcode", seconds.hashCode() == secondsNotEqual.hashCode());
    }


}
