package org.ixcode.cumulus.feedcloud.spike.time;

import static junit.framework.Assert.*;
import org.junit.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MillisecondsTest {

    @Test
    public void canConvert() {
        TimeConverter timeConverter = mock(TimeConverter.class);

        Milliseconds milliseconds = new Milliseconds(666L);

        when(timeConverter.convertFrom(666L)).thenReturn(234L);
        long result = milliseconds.convert(timeConverter);

        assertEquals(234L, result);
    }


    @Test
    public void calculatesElapsedTime() {
        Milliseconds start = new Milliseconds(10L);
        Milliseconds stop = new Milliseconds(20L);

        Milliseconds elapsed = stop.elapsedFrom(start);

        assertEquals(new Milliseconds(10L), elapsed);
    }

    @Test
    public void providesAppropriateStringRepresentation() {
        Milliseconds milliseconds = new Milliseconds(34);
        assertEquals("34 ms", milliseconds.toString());
    }

    @Test
    public void canBeComparedForEquality() {
        Milliseconds milliseconds = new Milliseconds(34);
        Milliseconds millisecondsEqual = new Milliseconds(34);
        Milliseconds millisecondsNotEqual = new Milliseconds(666);

        assertEquals(milliseconds, millisecondsEqual);
        assertFalse(milliseconds.equals(millisecondsNotEqual));

        assertEquals(milliseconds.hashCode(), milliseconds.hashCode());
        assertFalse(milliseconds.hashCode() == millisecondsNotEqual.hashCode());
    }


}
