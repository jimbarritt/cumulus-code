package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.model.primitives.Money;
import com.thoughtworks.cschuyle.WrappedInteger;

import java.util.Map;
import java.util.HashMap;

public class SolutionChart {

    private Map<WrappedInteger, Solution> chart = new HashMap<WrappedInteger, Solution>();

    public boolean containsTotal( Money total ) {
        return chart.containsKey( total );
    }

    public Solution put( Money solutionTotal, Solution solution ) {
        if( solution.size() <= 0 || containsTotal( solutionTotal ) ) {
            return null;
        }
        chart.put( solutionTotal, solution );
        return solution;
    }

    public Solution get( Money total ) {
        return chart.get( total );
    }
}
