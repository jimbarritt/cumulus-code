using System.Collections.Generic;
using System.Linq;

namespace FriendlyCoins
{
    public class HighestFirstSolver
    {
        private readonly IEnumerable<int> denominations;

        public HighestFirstSolver(params int[] denominations)
        {
            this.denominations = denominations.ToArray<int>().OrderBy(i => -i);
        }

        public CoinSet solve(int total)
        {
            var coinSet = new CoinSet();
            while (coinSet.Sum < total)
            {
                accumulateHighest(coinSet, total);
            }
            return coinSet;
        }

        private void accumulateHighest(CoinSet set, int total)
        {
            foreach(int denomination in denominations)
            {
                int available = total - set.Sum;
                if (denomination <= available)
                {
                    set.AddCoin(denomination);
                }
            }
        }
    }
}
