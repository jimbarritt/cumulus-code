package com.thoughtworks.cschuyle.friendlycoins.solutions.factories;

import com.thoughtworks.cschuyle.friendlycoins.model.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.solutions.Solution;

public interface SolutionFactory {

    Solution createSolution( CoinSetCollection coinSets );

}
