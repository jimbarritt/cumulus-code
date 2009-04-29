using System;
using System.Collections.Generic;
using System.Linq;

namespace FriendlyCoins
{
    public class CoinSet
    {
        class CoinCount
        {
            public int Denomination { get; internal set; }
            public int Count { get; internal set; }
            public override string ToString()
            {
                return String.Format("{0} {1}'s", Count, Denomination);
            }
            public override bool Equals(object obj)
            {
                if (obj == null) return false;
                if (this.GetType() != obj.GetType()) return false;
                var obj1 = (CoinCount)obj;
                return Count == obj1.Count && Denomination == obj1.Denomination;
            }
            public override int GetHashCode()
            {
                return (Denomination * 31 + Count)%31;
            }
        }

        class CoinCountCollection
        {
            private readonly Dictionary<int, CoinCount> denominations = new Dictionary<int, CoinCount>();

            public void AddCoin(int denomination)
            {
                if (!denominations.ContainsKey(denomination))
                {
                    denominations[denomination] = new CoinCount {Denomination = denomination, Count = 1};
                }
                else
                {
                    denominations[denomination].Count++;
                }
            }

            public override int GetHashCode()
            {
                return denominations.Aggregate(0, (acc, item) => item.GetHashCode() * 31) % 31;
            }
            public override string ToString()
            {
                return string.Join(",", denominations.Values.Select(a => a.ToString()).ToArray());
            }
            public override bool Equals(object obj)
            {
                if (obj == null) return false;
                if (this.GetType() != obj.GetType()) return false;
                var obj1 = (CoinCountCollection)obj;
                return denominations.Values.OrderBy( item => item.Denomination).
                    SequenceEqual(obj1.denominations.Values.OrderBy(item => item.Denomination));
            }
        }

        private readonly CoinCountCollection denominations = new CoinCountCollection();

        public int Sum { get; set; }

        public void AddCoin( int denomination )
        {
            Sum += denomination;
            denominations.AddCoin(denomination);
        }
        public override bool Equals(object obj)
        {
            if (obj == null) return false;
            if (this.GetType() != obj.GetType()) return false;
            var obj1 = (CoinSet) obj;
            return (this.denominations.Equals(obj1.denominations));
        }

        public override int GetHashCode()
        {
            return denominations.GetHashCode();
        }

        public override string ToString()
        {
            return denominations.ToString();
        }
    }
}