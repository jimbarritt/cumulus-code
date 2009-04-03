package com.thoughtworks.cschuyle.friendlycoins.solutions.factories;

import com.thoughtworks.cschuyle.friendlycoins.model.CoinSetCollection;
import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;
import com.thoughtworks.cschuyle.friendlycoins.solutions.SolutionChart;
import com.thoughtworks.cschuyle.friendlycoins.solutions.Solution;

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

    public void createNewSolution( SolutionChart chart, Money total, CoinSetCollection coinSets ) {
        if( coinSets.size() > 0 ) {
            Solution solution = getSolutionFactory().createSolution( coinSets );
            chart.put( total, solution );
        }
    }
}
