package l1j.server.server.random;

/**
 * <code>RandomGenerator</code>は、乱数を生成することができる乱数ジェネレータです。
 * 全てのメソッドはスレッドセーフとして実装されています。
 * 但し、複数のスレッドから多量の乱数を同時に生成した場合のパフォーマンスは乱数ジェネレータの実装に依存します。
 */
public interface RandomGenerator {
	/**
	 * 乱数ジェネレータを使って、 <code>int</code>型の擬似乱数を返します。
	 * 
	 * @return 乱数ジェネレータに基づく、<code>int</code> 型の次の擬似乱数値
	 */
	public int nextInt();

	/**
	 * 乱数ジェネレータのシーケンスを使って、0 から指定された値の範囲 (0 は含むが、その指定された値は含まない) の
	 * <code>int</code> 型の擬似乱数を返します。
	 * 
	 * @throws IllegalArgumentException
	 *             n が正でない場合
	 * @return 乱数ジェネレータに基づく、<code>0</code> (これを 含む) から <code>n</code> (これを含まない)
	 *         の範囲の <code>int</code> 型の次の擬似乱数値
	 * */
	public int nextInt(int n);
}
