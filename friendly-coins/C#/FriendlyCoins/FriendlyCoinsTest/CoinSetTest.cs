using System.Collections.Generic;
using System.Linq;
using NUnit.Framework;

namespace FriendlyCoins
{
    [TestFixture]
    public class CoinSetTest
    {
        [Test]
        public void A()
        {
            var dictionary = new Dictionary<int, string>() { { 1, "a" }, { 2, "b" } };
            var intList = new List<int> { 1, 2 }; 
            var stringList = new List<string> { "a", "b" }; 
            Assert.IsTrue(dictionary.Keys.SequenceEqual(intList));
            Assert.IsTrue(dictionary.Values.SequenceEqual(stringList));
        }
        [Test]
        public void AddASingleCoin()
        {
            var set = new CoinSet();
            Assert.AreEqual( 0, set.Sum );
            set.AddCoin( 1 );
            Assert.AreEqual( 1, set.Sum );
        }

        [Test] public void Equality()
        {
            var set = new CoinSet();
            var set2 = new CoinSet();
          //  Assert.AreEqual(set, set2);
            set.AddCoin(1);
            Assert.AreNotEqual(set, set2);
            set2.AddCoin(1);
            Assert.AreEqual(set, set2);
        }
    }
}
