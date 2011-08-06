package l1j.server.server.random;

public class RandomGeneratorFactory {
	private static RandomGenerator _rnd = null;

	/**
	 * サーバー共用の乱数ジェネレータを返します。少量の乱数生成であればこちらを推奨します。
	 * このメソッド及びメソッドが返す乱数ジェネレータはスレッドセーフであることが保障されており、外部同期の必要はありません。
	 * 但し、複数のスレッドから多量の乱数を同時に生成した場合のパフォーマンスは乱数ジェネレータの実装に依存します。
	 * 
	 * @return サーバー共用の乱数ジェネレータ
	 */
	public static RandomGenerator getSharedRandom() {
		if (_rnd == null) {
			_rnd = newRandom();
		}
		return _rnd;
	}

	/**
	 * 新しい乱数ジェネレータを返します。 このメソッド及びメソッドが返す乱数ジェネレータはスレッドセーフです。
	 * 
	 * @return 新しい乱数ジェネレータ
	 */
	public static RandomGenerator newRandom() {
		return new StandardRandom();
	}

}
