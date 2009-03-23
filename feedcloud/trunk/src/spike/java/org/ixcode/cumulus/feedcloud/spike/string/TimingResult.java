package org.ixcode.cumulus.feedcloud.spike.string;

import org.ixcode.cumulus.feedcloud.spike.time.*;

class TimingResult {

    private static final String CON_HEAD = "Concatenations";
    private static final String NR_HEAD = "Number of runs";
    private static final String SB_HEAD = "StringBuilder(ms)";
    private static final String SB_AVG = "Avg StringBuilder(ms)";
    private static final String CT_HEAD = "Concatenation(ms)";
    private static final String CT_AVG = "Avg Concatenation(ms)";



    private static final String OUTPUT_FORMAT = "|%" + (CON_HEAD.length() - 1) + "d " +
                                                "|%" + (NR_HEAD.length()) + "d" +
                                                "|%" + (SB_HEAD.length()) + "d" +
                                                "|%" + (CT_HEAD.length()) + "d" +
                                                "|%" + (SB_AVG.length()) + ".4f" +
                                                "|%" + (CT_AVG.length()) + ".4f|";

    private static final String HEADER_STRING = "|" + CON_HEAD + "|" + NR_HEAD +"|" + SB_HEAD + "|" + CT_HEAD + "|" + SB_AVG + "|" + CT_AVG + "|";
    private static final String SEPERATOR_STRING = "|--------------|--------------|-----------------|-----------------|---------------------|---------------------|";

    private final Milliseconds stringBuilderTime;
    private final int numberOfConcatenations;
    private final int numberOfRuns;
    private final Milliseconds concatenationTime;


    public TimingResult(int numberOfConcatenations, int numberOfRuns, Milliseconds stringBuilderTime, Milliseconds concatenationTime) {
        this.numberOfConcatenations = numberOfConcatenations;
        this.numberOfRuns = numberOfRuns;
        this.concatenationTime = concatenationTime;
        this.stringBuilderTime = stringBuilderTime;
    }

    public String toString() {
        double averageStringBuilderTime = ((double)stringBuilderTime.longValue()) / ((double)(numberOfRuns));
        double averageConcatenationTime = ((double)concatenationTime.longValue()) / ((double)(numberOfRuns));
        return String.format(OUTPUT_FORMAT,
                numberOfConcatenations, numberOfRuns,
                stringBuilderTime.longValue(), concatenationTime.longValue(),
                averageStringBuilderTime, averageConcatenationTime);
    }

    public static String getHeaderString() {
        return HEADER_STRING;
    }

    public static String getSeperatorString() {
        return SEPERATOR_STRING;
    }
}
