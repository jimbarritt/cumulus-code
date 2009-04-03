package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSetCollection;

public interface SolutionFactory {

    Solution createSolution( CoinSetCollection coinSets );

}
