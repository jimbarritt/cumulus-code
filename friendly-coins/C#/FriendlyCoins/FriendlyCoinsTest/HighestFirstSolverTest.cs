using NUnit.Framework;

namespace FriendlyCoins
{
    [TestFixture]
    public class HighestFirstSolverTest
    {
        [Test]
        public void Trivial()
        {
            var solver = new HighestFirstSolver( 1 );
            var solution = solver.solve( 1 );
            var expected = new CoinSet();
            expected.AddCoin(1);
            Assert.AreEqual( expected, solution );
        }

        [Test]
        public void Simple()
        {
            var solver = new HighestFirstSolver( 1 );
            var solution = solver.solve( 2 );
            var expected = new CoinSet();
            expected.AddCoin(1);
            expected.AddCoin(1);
            Assert.AreEqual(expected, solution);
        }

        [Test]
        public void NotSoSimple()
        {
            var solver = new HighestFirstSolver(1,2);
            var solution = solver.solve(5);
            var expected = new CoinSet();
            expected.AddCoin(2);
            expected.AddCoin(2);
            expected.AddCoin(1);
            Assert.AreEqual(expected, solution);
        }
    
    }
}
