package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;
import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MinutesTest {

    @Test
    public void canConvert() {
        TimeConverter timeConverter = mock(TimeConverter.class);

        Minutes minutes = new Minutes(666L);

        when(timeConverter.convertFrom(666L)).thenReturn(234L);
        long result = minutes.convert(timeConverter);

        assertEquals(234L, result);
    }

    @Test
    public void providesAppropriateStringRepresentation() {
        Minutes minutes = new Minutes(34);
        assertEquals("34 min", minutes.toString());
    }

    @Test
    public void canBeComparedForEquality() {
        Minutes minutes = new Minutes(34);
        Minutes minutesEqual = new Minutes(34);
        Minutes minutesNotEqual = new Minutes(666);

        assertEquals(minutes, minutesEqual);
        assertFalse(minutes.equals(minutesNotEqual));

        assertEquals(minutes.hashCode(), minutesEqual.hashCode());
        assertFalse(minutes.hashCode() == minutesNotEqual.hashCode());
    }    

}
