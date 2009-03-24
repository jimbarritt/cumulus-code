package org.ixcode.cumulus.feedcloud.spike.string;

import org.ixcode.cumulus.feedcloud.spike.time.*;
import org.ixcode.cumulus.feedcloud.spike.timer.*;

public class ConcatenationInAMethodBenchmark {
    private final TimingReport timingReport;
    private final GarbageCollection garbageCollection = new GarbageCollection();

    public ConcatenationInAMethodBenchmark(TimingReport timingReport) {
        this.timingReport = timingReport;
    }


    public void runIteration(String testString, int numberOfConcatenations, int numberOfRuns) {
        garbageCollection.collect();

        Milliseconds stringBuilderMs = runWithStringBuilder(testString, numberOfConcatenations, numberOfRuns);

        garbageCollection.collect();

        Milliseconds concatenationMs = runWithConcatenation(testString, numberOfConcatenations, numberOfRuns);

        TimingResult timingResult = new TimingResult(numberOfConcatenations, numberOfRuns, stringBuilderMs, concatenationMs);
        timingReport.addTimingResult(timingResult);
    }

    private Milliseconds runWithConcatenation(String testString, int numberOfConcatenations, int numberOfRuns) {
        TaskTimer timerConcatentation = new TaskTimer(
                new ConcatenationHarness(testString, numberOfConcatenations),
                StopWatch.newInstance());
        Milliseconds concatenationMs = timerConcatentation.time(numberOfRuns);
        return concatenationMs;
    }

    private Milliseconds runWithStringBuilder(String testString, int numberOfConcatenations, int numberOfRuns) {
        TaskTimer timerStringBuilder = new TaskTimer(
                new StringBuilderHarness(testString, numberOfConcatenations),
                StopWatch.newInstance());

        Milliseconds stringBuilderMs = timerStringBuilder.time(numberOfRuns);
        return stringBuilderMs;
    }

    private static abstract class TestHarness implements Runnable {
        protected final int numberOfConcatenations;
        protected final String element;

        protected String output = "";

        public TestHarness(String element, int numberOfConcatenations) {
            this.element = element;
            this.numberOfConcatenations = numberOfConcatenations;
        }

    }

    private static class StringBuilderHarness extends TestHarness {
        public StringBuilderHarness(String element, int numberOfConcatenations) {
            super(element, numberOfConcatenations);
        }

        public void run() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numberOfConcatenations; ++i) {
                sb.append(element);
            }
            output = sb.toString();
        }
    }

    private static class ConcatenationHarness extends TestHarness {
        private Runnable strategy;

        public ConcatenationHarness(String element, int numberOfConcatenations) {
            super(element, numberOfConcatenations);
            switch (numberOfConcatenations) {
                case 1:
                    strategy = new ConcatenationHarness.ConcatenationOne(element);
                case 2:
                    strategy = new ConcatenationHarness.ConcatenationTwo(element);
                case 3:
                    strategy = new ConcatenationHarness.ConcatenationThree(element);
                case 4:
                    strategy = new ConcatenationHarness.ConcatenationFour(element);
                case 5:
                    strategy = new ConcatenationHarness.ConcatenationFive(element);
                default:
                    strategy = new ConcatenationHarness.ConcatenationDefault(element, numberOfConcatenations);
            }
        }

        public void run() {
            strategy.run();
        }

        private static class ConcatenationDefault extends TestHarness {
            public ConcatenationDefault(String element, int numberOfConcatenations) {
                super(element, numberOfConcatenations);
            }

            public void run() {
                for (int i = 0; i < numberOfConcatenations; ++i) {
                    output += element;
                }
            }
        }

        private static class ConcatenationOne extends TestHarness {
            public ConcatenationOne(String element) {
                super(element, 1);
            }

            public void run() {
                output = element + element;
            }
        }

        private static class ConcatenationTwo extends TestHarness {
            public ConcatenationTwo(String element) {
                super(element, 2);
            }

            public void run() {
                output = element + element + element;
            }
        }

        private static class ConcatenationThree extends TestHarness {
            public ConcatenationThree(String element) {
                super(element, 3);
            }

            public void run() {
                output = element + element;
            }
        }


        private static class ConcatenationFour extends TestHarness {
            public ConcatenationFour(String element) {
                super(element, 4);
            }

            public void run() {
                output = element + element;
            }
        }

        private static class ConcatenationFive extends TestHarness {
            public ConcatenationFive(String element) {
                super(element, 5);
            }

            public void run() {
                output = element + element;
            }
        }


    }

}
