package l1j.server.server.model.shop;

public class L1ShopSellOrder {
	private final L1AssessedItem _item;
	private final int _count;

	public L1ShopSellOrder(L1AssessedItem item, int count) {
		_item = item;
		_count = count;
	}

	public L1AssessedItem getItem() {
		return _item;
	}

	public int getCount() {
		return _count;
	}

}