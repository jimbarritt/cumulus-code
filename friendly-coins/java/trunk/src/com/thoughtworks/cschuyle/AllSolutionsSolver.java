package com.thoughtworks.cschuyle;

import java.util.*;

class AllSolutionsSolver {

    static class Solution {

        private int total = 0;

        public Solution( Collection<CoinSet> coinSets ) {
            this.coinSets = coinSets;
            for( CoinSet coinSet: coinSets ) {
                if( 0 == total ) {
                    total = coinSet.sum();
                } else {
                    if( coinSet.sum() != total ) {
                        throw new IllegalStateException( "All coinSets must have the same sum" );
                    }
                }
            }
        }

        public int getTotal() {
            return total;
        }

        Collection<CoinSet> coinSets;

        Collection<CoinSet> getCoinSets() {
            return coinSets;
        }

        public CoinSet getFewestCoinsSolution() {
            CoinSet leastSolution = null;

            // TODO There must be an algorithm for this
            for( CoinSet coinSet: coinSets) {
                if( null == leastSolution || coinSet.getNumCoins() < leastSolution.getNumCoins() ) {
                    leastSolution = coinSet;
                }
            }
            return leastSolution;
        }

        public String toString() {
            String ret = this.getClass().getSimpleName() + "<";
            boolean first = true;
            for( CoinSet coinSet: coinSets ) {
                if( ! first ) {
                    ret += ",";
                } else {
                    first = false;
                }
                ret += coinSet.toString();
            }
            return ret + ">";
        }

    }

    private DenominationSet denominations;

    public AllSolutionsSolver( DenominationSet denominations ) {
        this.denominations = denominations;
    }

    public CoinSet getFewestCoinsSolution( int total ) {
        Solution solution = getMemoizedSolution( total );
        CoinSet leastSolution = null;
        for( CoinSet coinSet : solution.coinSets ) {
            if( null == leastSolution || coinSet.getNumCoins() < leastSolution.getNumCoins() ) {
                leastSolution = coinSet;
            }
        }
        return leastSolution;
    }

    public Solution solve( int total ) {
        /*
        solve(x):
            if x is a solution
                return
            for all den
                if x == den
                    den is a solution
                else if solve x-den
                    partial solution + den is a solution


        more than one solution for a given x arises out o the for loop
        */
        if( isMemoized( total ) ) {
            return getMemoizedSolution( total );
        }
        Collection<CoinSet> coinSets = new ArrayList<CoinSet>();
        for( int denomination: denominations.getSortedList() ) {
            if( denomination == total ) {
                CoinSet coinSet = new CoinSet( denomination );
                coinSets.add( coinSet );
            } else if( denomination < total ) {
                solve( total - denomination );
                if( isMemoized( total - denomination )) {
                    Solution partialSolution = getMemoizedSolution( total - denomination );
                    for( CoinSet coinSet: partialSolution.getCoinSets() ) {
                        coinSets.add(CoinSet.createAugmentedCoinSet( coinSet, denomination ));
                    }
                }
            }
        }
        if( coinSets.size() > 0 ) {
            final Solution solution = new Solution( coinSets );
            memoizeSolution( solution );
            return solution;
        }
        throw new NoSolutionException( denominations, total );
    }

    public Solution getMemoizedSolution( int total ) {
        Solution ret = chart.get( total );
        if( null == ret ) {
            throw new IllegalArgumentException( "Request for non-memoized solution for total = " + total );
        }
        return ret;
    }

    boolean isMemoized( int total ) {
        return chart.containsKey( total );
    }

    void memoizeSolution( Solution solution ) {
        chart.put( solution.getTotal(), solution );
    }

    Map<Integer, Solution> chart = new HashMap<Integer, Solution>();

}
