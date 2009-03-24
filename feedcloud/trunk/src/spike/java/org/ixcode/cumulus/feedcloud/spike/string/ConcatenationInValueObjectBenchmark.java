package org.ixcode.cumulus.feedcloud.spike.string;

import org.ixcode.cumulus.feedcloud.spike.time.*;
import org.ixcode.cumulus.feedcloud.spike.timer.*;

public class ConcatenationInValueObjectBenchmark {
    private final TimingReport timingReport;
    private final GarbageCollection garbageCollection = new GarbageCollection();


    public ConcatenationInValueObjectBenchmark(TimingReport timingReport) {
        this.timingReport = timingReport;
    }

    public void run(int numberOfRuns) {
        ValueObject valueObject = new ValueObject(666L);

        garbageCollection.collect();

        Milliseconds stringBuilderTime = runForStringBuilder(numberOfRuns, valueObject);

        garbageCollection.collect();

        Milliseconds concatenationTime = runForConcatenation(numberOfRuns, valueObject);
        
        timingReport.addTimingResult(new TimingResult(1, numberOfRuns, stringBuilderTime, concatenationTime));

    }

    private Milliseconds runForStringBuilder(int numberOfRuns, ValueObject valueObject) {
        TaskTimer timerConcatentation = new TaskTimer(
                new StringBuilderHarness(valueObject, numberOfRuns),
                StopWatch.newInstance());

        return timerConcatentation.time(numberOfRuns);
    }

    private Milliseconds runForConcatenation(int numberOfRuns, ValueObject valueObject) {
        TaskTimer timerConcatentation = new TaskTimer(
                new ConcatenationHarness(valueObject, numberOfRuns),
                StopWatch.newInstance());
        
        return timerConcatentation.time(numberOfRuns);
    }

    private static abstract class TestHarness implements Runnable {
        protected final ValueObject valueObject;
        protected final int numberOfRuns;

        public TestHarness(ValueObject valueObject, int numberOfRuns) {
            this.valueObject = valueObject;
            this.numberOfRuns = numberOfRuns;
        }

        public void run() {
            for (int i=0;i<numberOfRuns;++i) {
                executeTest();
            }
        }

        public abstract void executeTest();
    }

    private static class ConcatenationHarness extends TestHarness {
        public ConcatenationHarness(ValueObject valueObject, int numberOfRuns) {
            super(valueObject, numberOfRuns);
        }

        public void executeTest() {
            valueObject.toStringWithconcatenation();
        }
    }

    public static class StringBuilderHarness extends TestHarness {
        public StringBuilderHarness(ValueObject valueObject, int numberOfRuns) {
            super(valueObject, numberOfRuns);
        }

        public void executeTest() {
            valueObject.toStringWithStringBuilder();
        }
    }
}
