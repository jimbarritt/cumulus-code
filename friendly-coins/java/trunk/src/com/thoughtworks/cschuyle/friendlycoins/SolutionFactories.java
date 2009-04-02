package com.thoughtworks.cschuyle.friendlycoins;

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
