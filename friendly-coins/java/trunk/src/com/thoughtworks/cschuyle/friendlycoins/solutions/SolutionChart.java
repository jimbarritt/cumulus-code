package com.thoughtworks.cschuyle.friendlycoins.solutions;

import com.thoughtworks.cschuyle.friendlycoins.primitives.Money;

import java.util.Map;
import java.util.HashMap;

public class SolutionChart {

    private Map<Integer, Solution> chart = new HashMap<Integer, Solution>();

    public boolean containsTotal( Money total ) {
        return chart.containsKey( total.intValue() );
    }

    public Solution put( Money solutionTotal, Solution solution ) {
        if( solution.size() <= 0 || containsTotal( solutionTotal ) ) {
            return null;
        }
        final int solutionTotalInt = solutionTotal.intValue();
        chart.put( solutionTotalInt, solution );
        return solution;
    }

    public Solution get( Money total ) {
        return chart.get( total.intValue() );
    }
}
