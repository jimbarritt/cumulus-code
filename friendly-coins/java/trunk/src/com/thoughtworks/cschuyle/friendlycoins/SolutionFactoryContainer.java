package com.thoughtworks.cschuyle.friendlycoins;

import com.thoughtworks.cschuyle.friendlycoins.SolutionFactory;
import com.thoughtworks.cschuyle.friendlycoins.SolutionFactories;

public class SolutionFactoryContainer {

    private SolutionFactory solutionFactory;

    public void setSolutionFactory( SolutionFactory solutionFactory ) {
        this.solutionFactory = solutionFactory;
    }

    public SolutionFactory getSolutionFactory() {
        if( null != solutionFactory ) {
            return solutionFactory;
        }
        return SolutionFactories.OPTIMIZED_SOLUTION_FACTORY;
    }

    public Solution createSolution( CoinSetCollection coinSets) {
        return getSolutionFactory().createSolution( coinSets );
    }
}
