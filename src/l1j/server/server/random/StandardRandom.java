package l1j.server.server.random;

import java.util.Random;

/**
 * StandardRandom クラスのインスタンスは、<code>java.util.Random</code>
 * クラスを利用して一連の擬似乱数を生成します。クラスでは 48 ビットのシードを使い、このシードは線形合同法で変更されます。詳細は Donald Knuth
 * 著『The Art of Computer Programming, Volume 3』の 3.2.1 を参照してください。
 * 
 * @see java.util.Random
 */
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
