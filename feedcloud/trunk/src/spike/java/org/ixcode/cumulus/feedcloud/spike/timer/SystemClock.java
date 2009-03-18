package org.ixcode.cumulus.feedcloud.spike.timer;

/**
 * Wrapper for the system clock. Always use this class and always inject it and
 * you will be able to use the lovelly SystemClockStub which is a test class
 * which allows you to start and stop time.
 *
 * Notice that we do NOTHING in the method except delegate to the system clock.
 *
 * This is what Uncle bob refers to in clean code as wrapping libraries, also what DDD refers to
 * as Anti-Corruption layer.
 *
 * It allows us control over our boundaries. Because we don't want to have to test this class
 * It would be pretty hard we just keep the functionality minimal and Single Responsibility.
 */
public class SystemClock {

    public long getCurrentTimeMilliseconds() {
        return System.currentTimeMillis();
    }
    
}
