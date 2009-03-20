package com.thoughtworks.cschuyle;

import java.util.Collection;

public interface SolutionFactory {
    Solution createSolution( Collection<CoinSet> coinSets );
}
