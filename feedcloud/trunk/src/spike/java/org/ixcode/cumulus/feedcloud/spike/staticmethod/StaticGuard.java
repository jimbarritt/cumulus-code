package org.ixcode.cumulus.feedcloud.spike.staticmethod;

public class StaticGuard {

    public void doSomething(String someArg) {
        if (isEmpty(someArg)) {
            System.out.println("Argument is empty!");
            return;
        }
        
        if (someArg.startsWith("a")) {
            System.out.println("Argument starts with a!");
            return;
        }

        System.out.println("Argument does NOT start with a");
    }

    private static boolean isEmpty(String someArg) {
        return someArg == null || someArg.length() == 0;
    }

}
