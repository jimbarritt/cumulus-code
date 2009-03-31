package com.thoughtworks.cschuyle.friendlycoins;

import java.util.Collection;

public interface SolutionFactory {
    Solution createSolution( Collection<CoinSet> coinSets );
}
