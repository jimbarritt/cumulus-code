package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import static junit.framework.Assert.assertEquals;
import org.junit.*;

public class MinutesTest {

    @Test
    public void providesLongValue() {
        Minutes minutes = new Minutes(666);

        assertEquals("longValue", 666L, minutes.longValue());
    }

    @Test
    public void providesAppropriateStringRepresentation() {
        Minutes minutes = new Minutes(34);
        assertEquals("toString", "34 min", minutes.toString());
    }

    @Test
    public void canBeComparedForEquality() {
        Minutes minutes = new Minutes(34);
        Minutes minutesEqual = new Minutes(34);
        Minutes minutesNotEqual = new Minutes(666);

        assertEquals("equal", minutes, minutesEqual);
        assertFalse("not-equal", minutes.equals(minutesNotEqual));

        assertEquals("equal.hashcode", minutes.hashCode(), minutesEqual.hashCode());
        assertFalse("not-equal.hashcode", minutes.hashCode() == minutesNotEqual.hashCode());
    }    



}
