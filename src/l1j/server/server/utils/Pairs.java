package l1j.server.server.utils;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
	public static<U, V> List<Pair<U, V>> zip(List<U> firsts, List<V> seconds) {
		int size = firsts.size();
		List<Pair<U, V>> zipped = new ArrayList<Pair<U, V>>(size);
		for (int i = 0; i < size; i++)
			zipped.add(new Pair<U, V>(firsts.get(i), seconds.get(i)));
		return zipped;
	}
}
