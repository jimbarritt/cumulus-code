package org.ixcode.cumulus.feedcloud.spike.staticmethod;

import org.junit.*;

public class StaticGuardTest {

    @Test
    public void knowsIfItStartsWithA() {

        StaticGuard guard = new StaticGuard();

        guard.doSomething("an argument");

        guard.doSomething("Not an argument");

        guard.doSomething(null);

    }

}
