package com.thoughtworks.cschuyle.friendlycoins.solutions.factories;

import com.thoughtworks.cschuyle.friendlycoins.collections.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.solutions.Solution;

public interface SolutionFactory {

    Solution createSolution( CoinSetCollection coinSets );

}
