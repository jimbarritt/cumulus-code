package org.ixcode.cumulus.feedcloud.spike.string;

public class GarbageCollection {

    public void collect() {
        System.runFinalization();
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
