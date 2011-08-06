package l1j.server.server.model;

public class L1MessageId {
	/**
	 * \f1%0は使用できません。
	 */
	public static final int CANNOT_BE_USED = 74;
	/**
	 * \f1%0を食べました。
	 */
	public static final int YOU_ATE = 76;

	/**
	 * \f1%0はゲームをしていません。
	 */
	public static final int NOT_PLAYING_NOW = 73;

	/**
	 * \f1気分が良くなりました。
	 */
	public static final int YOU_FEEL_BETTER = 77;

	/**
	 * \f1何も起きませんでした。
	 */
	public static final int NOTHING_HAPPENED = 79;

	/**
	 * レベル%0未満のキャラクターはチャットができません。
	 */
	public static final int CANNOT_USE_GLOBAL_CHAT = 195;

	/**
	 * \f1血盟倉庫を使用するには血盟に加入していなくてはなりません。
	 */
	public static final int NO_PLEDGE_WAREHOUSE = 208;

	/**
	 * \f1ここを記憶することができません。
	 */
	public static final int CANNOT_BOOKMARK_LOCATION = 214;

	/**
	 * \f1MPが不足していて魔法を使うことができません。
	 */
	public static final int NOT_ENOUGH_MP = 278;

	/**
	 * レベルが低くてその魔法を覚えることができません。
	 */
	public static final int MAGIC_LEVEL_TOO_LOW = 312;

	/**
	 * %0を手に入れました。
	 */
	public static final int OBTAINED = 403;

	/**
	 * あなたの武器に祝福が宿ります。
	 */
	public static final int YOUR_WEAPON_IS_FILLED_WITH_BLESSING = 693;

	/**
	 * 料理が失敗しました。
	 */
	public static final int YOU_FAILED_COOKING = 1101;

	/**
	 * 料理の材料が足りません。
	 */
	static final int NOT_ENOUGH_INGREDIENTS = 1102;

	/**
	 * アイテムが重すぎて、料理できません。
	 */
	public static final int ITEMS_TOO_HEAVY_TO_COOK = 1103;

	/**
	 * 料理には焚き火が必要です。
	 */
	public static final int NEEDS_FIRE_TO_COOK = 1160;
}
