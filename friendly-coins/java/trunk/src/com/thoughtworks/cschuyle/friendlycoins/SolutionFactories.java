package com.thoughtworks.cschuyle.friendlycoins;

import java.util.Collection;

public class SolutionFactories {

    private SolutionFactories() {}

    public static final SolutionFactory OPTIMIZED_SOLUTION_FACTORY = new SolutionFactory() {

        public Solution createSolution( Collection<CoinSet> coinSets ) {
            return new OptimizedSolution( coinSets );
        }
    };

    public final static SolutionFactory COMPLETE_SOLUTION_FACTORY = new SolutionFactory() {

        public Solution createSolution( Collection<CoinSet> coinSets ) {
            return new CompleteSolution( coinSets );
        }
    };

}
