package org.ixcode.cumulus.feedcloud.spike.string;

import org.ixcode.cumulus.feedcloud.spike.time.*;
import org.ixcode.cumulus.feedcloud.spike.timer.*;

public class StringConcatenationBenchmark {
    private final int[] concatenationSizes = {1, 2, 3, 4, 5};
    private final int numberOfRuns = 100;

    private TimingReport timingReport;

    public static void main(String[] args) {
        new StringConcatenationBenchmark().reportPerformanceOfStringConcatenation();
    }

    public void reportPerformanceOfStringConcatenation() {

        timingReport = new TimingReport();

        for (int numberOfConcatenations : concatenationSizes) {
            runIteration("THIS IS A VERY LONG TEST;", numberOfConcatenations, numberOfRuns);
            System.out.println("Completed Iteration with : " + numberOfConcatenations + " concatenations");
        }
        
        timingReport.printReport();

    }

    private void runIteration(String testString, int numberOfConcatenations, int numberOfRuns) {
        garbageCollect();

        Milliseconds stringBuilderMs = runWithStringBuilder(testString, numberOfConcatenations, numberOfRuns);

        garbageCollect();

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

    private void garbageCollect() {
        System.runFinalization();
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                case 1 :
                    strategy = new ConcatenationOne(element);
                case 2 :
                    strategy = new ConcatenationTwo(element);
                case 3 :
                    strategy = new ConcatenationThree(element);
                case 4 :
                    strategy = new ConcatenationFour(element);
                case 5 :
                    strategy = new ConcatenationFive(element);
                default:
                    strategy = new ConcatenationDefault(element,  numberOfConcatenations);
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
