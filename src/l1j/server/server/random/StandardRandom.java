package l1j.server.server.random;

import java.util.Random;

class StandardRandom implements RandomGenerator {
	private Random _rnd = new Random();

	@Override
	public int nextInt() {
		return _rnd.nextInt();
	}

	@Override
	public int nextInt(int n) {
		return _rnd.nextInt(n);
	}
}
