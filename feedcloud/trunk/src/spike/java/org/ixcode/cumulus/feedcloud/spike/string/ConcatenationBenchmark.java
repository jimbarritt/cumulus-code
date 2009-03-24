package org.ixcode.cumulus.feedcloud.spike.string;

public class ConcatenationBenchmark {

    public static void main(String[] args) {
        ConcatenationBenchmark concatenationBenchmark = new ConcatenationBenchmark();

        concatenationBenchmark.reportPerformanceOfStringConcatenation();
        System.out.println("\n\n\n");
        concatenationBenchmark.reportPerformanceOfValueObjectStringConcatenation();
    }

    private void reportPerformanceOfValueObjectStringConcatenation() {
        final int[] numberOfRunsParameters = {10, 100, 200, 300, 400, 500};

        TimingReport timingReport = new TimingReport();

        ConcatenationInValueObjectBenchmark benchmark = new ConcatenationInValueObjectBenchmark(timingReport);

        for (int numberOfRuns:numberOfRunsParameters) {
            benchmark.run(numberOfRuns);
        }
        
        timingReport.printReport();

    }

    public void reportPerformanceOfStringConcatenation() {
        final int[] concatenationSizes = {1, 2, 3, 4, 5};
        final int numberOfRuns = 100;

        TimingReport timingReport = new TimingReport();

        ConcatenationInAMethodBenchmark benchmark = new ConcatenationInAMethodBenchmark(timingReport);
        for (int numberOfConcatenations : concatenationSizes) {
            benchmark.runIteration("THIS IS A VERY LONG TEST;", numberOfConcatenations, numberOfRuns);
            System.out.println("Completed Iteration with : " + numberOfConcatenations + " concatenations");
        }

        timingReport.printReport();

    }

}
