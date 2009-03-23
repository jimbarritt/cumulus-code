package org.ixcode.cumulus.feedcloud.spike.time;

import org.junit.*;
import org.ixcode.cumulus.feedcloud.spike.time.convert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class UnitOfTimeTest {

    @Test
    public void canConvert() {
        TimeConverter timeConverter = mock(TimeConverter.class);

        ExampleUnitOfTime exampleUnitOfTime = new ExampleUnitOfTime(666L);

        when(timeConverter.convertFrom(666L)).thenReturn(234L);
        long result = exampleUnitOfTime.convert(timeConverter);

        assertEquals(234L, result);
    }


    @Test
    public void calculatesElapsedTime() {
        ExampleUnitOfTime start = new ExampleUnitOfTime(10L);
        ExampleUnitOfTime stop = new ExampleUnitOfTime(20L);

        ExampleUnitOfTime elapsed = stop.elapsedFrom(start);

        assertEquals(new ExampleUnitOfTime(10L), elapsed);
    }

    @Test
    public void providesAppropriateStringRepresentation() {
        ExampleUnitOfTime exampleUnitOfTime = new ExampleUnitOfTime(34);
        assertEquals("34 example", exampleUnitOfTime.toString());
    }

    @Test
    public void canBeComparedForEquality() {
        ExampleUnitOfTime exampleUnitOfTime = new ExampleUnitOfTime(34);
        ExampleUnitOfTime exampleUnitOfTimeEqual = new ExampleUnitOfTime(34);
        ExampleUnitOfTime exampleUnitOfTimeNotEqual = new ExampleUnitOfTime(666);

        assertEquals(exampleUnitOfTime, exampleUnitOfTimeEqual);
        assertFalse(exampleUnitOfTime.equals(exampleUnitOfTimeNotEqual));

        assertEquals(exampleUnitOfTime.hashCode(), exampleUnitOfTime.hashCode());
        assertFalse(exampleUnitOfTime.hashCode() == exampleUnitOfTimeNotEqual.hashCode());
    }


    private static class ExampleUnitOfTime extends UnitOfTime<ExampleUnitOfTime> {
        public ExampleUnitOfTime(long exampleUnitOfTime) {
            super(exampleUnitOfTime, "%d example");
        }

        protected ExampleUnitOfTime newInstance(long longValue) {
            return new ExampleUnitOfTime(longValue);
        }
    }
}
