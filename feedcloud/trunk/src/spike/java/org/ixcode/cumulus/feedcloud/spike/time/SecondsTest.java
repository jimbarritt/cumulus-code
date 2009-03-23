package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecondsTest {


    @Test
    public void canConvert() {
        TimeConverter timeConverter = mock(TimeConverter.class);

        Seconds seconds = new Seconds(666L);

        when(timeConverter.convertFrom(666L)).thenReturn(234L);
        long result = seconds.convert(timeConverter);

        assertEquals(234L, result);
    }

    @Test
    public void canConvertToString() {
        Seconds seconds = new Seconds(34);
        assertEquals("34 s", seconds.toString());
    }

    @Test
    public void canBeComparedForEquality() {
        Seconds seconds = new Seconds(34);
        Seconds secondsEqual = new Seconds(34);
        Seconds secondsNotEqual = new Seconds(666);

        assertEquals(seconds, secondsEqual);
        assertFalse(seconds.equals(secondsNotEqual));

        assertEquals(seconds.hashCode(), secondsEqual.hashCode());
        assertFalse(seconds.hashCode() == secondsNotEqual.hashCode());
    }


}