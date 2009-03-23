package org.ixcode.cumulus.feedcloud.spike.string;

import java.util.*;

public class TimingReport {

    private final List<TimingResult> timingResults = new ArrayList<TimingResult>();

    public void addTimingResult(TimingResult timingResult) {
        timingResults.add(timingResult);
    }

    public void printReport() {
        printHeader();
        for (TimingResult result : timingResults) {
            printTimingResult(result);
        }
        printFooter();
    }

    private void printTimingResult(TimingResult timingResult) {
        System.out.println(timingResult);
    }

    private void printHeader() {
        printLineSeperator();
        printHeaderNames();
        printLineSeperator();
    }

    private void printFooter() {
        printLineSeperator();
    }

    private void printHeaderNames() {
        System.out.println(TimingResult.getHeaderString());
    }

    private void printLineSeperator() {
        System.out.println(TimingResult.getSeperatorString());
    }

}
