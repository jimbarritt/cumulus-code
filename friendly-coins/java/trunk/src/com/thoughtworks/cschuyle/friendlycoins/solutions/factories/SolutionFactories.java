package com.thoughtworks.cschuyle.friendlycoins.solutions.factories;

import com.thoughtworks.cschuyle.friendlycoins.model.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.solutions.Solution;
import com.thoughtworks.cschuyle.friendlycoins.solutions.OptimizedSolution;
import com.thoughtworks.cschuyle.friendlycoins.solutions.CompleteSolution;

public class SolutionFactories {

    private SolutionFactories() {}

    public static final SolutionFactory OPTIMIZED_SOLUTION_FACTORY = new SolutionFactory() {

        public Solution createSolution( CoinSetCollection coinSets ) {
            return new OptimizedSolution( coinSets );
        }
    };

    public final static SolutionFactory COMPLETE_SOLUTION_FACTORY = new SolutionFactory() {

        public Solution createSolution( CoinSetCollection coinSets ) {
            return new CompleteSolution( coinSets );
        }
    };

}
