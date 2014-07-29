package l1j.server.server.random;

public class RandomGeneratorFactory {
	private static RandomGenerator _rnd = null;

	public static RandomGenerator getSharedRandom() {
		if (_rnd == null) {
			_rnd = newRandom();
		}
		return _rnd;
	}

	public static RandomGenerator newRandom() {
		return new StandardRandom();
	}

}
