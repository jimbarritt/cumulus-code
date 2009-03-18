package org.ixcode.cumulus.feedcloud.spike.staticmethod;

public class NumberOfLinesPrinter {

    public static void printNumberOfLines(int numberOfLines) {
        new NumberOfLinesPrinter().print(numberOfLines);
    }

    public NumberOfLinesPrinter() {
    }

    public void print(int numberOfLines) {
        for (int i = 0; i< numberOfLines; ++i) {
            System.out.println("Line : " + i);
        }
    }
}
