package org.ixcode.cumulus.feedcloud.spike.staticmethod;

public class LinePrintingApplication {

    private NumberOfLinesPrinter numberOfLinesPrinter = new NumberOfLinesPrinter();
    private int numberOfLines;

    public LinePrintingApplication(String[] args) {
        System.out.println("Welcome to the LinePrinting Application.");        
        numberOfLines = new IntegerParser().parseInt(args[0]);
    }

    public void go() {
         printToPrinter(numberOfLinesPrinter, numberOfLines);
    }


    /**
     * In this case, makes sense for this method to be static as it doesnt have a side effect (doesnt interact with object state§.
     */
    private static void printToPrinter(NumberOfLinesPrinter numberOfLinesPrinter, int numberOfLines) {
        numberOfLinesPrinter.print(numberOfLines);
    }



}
