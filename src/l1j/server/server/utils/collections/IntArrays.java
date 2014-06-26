package l1j.server.server.utils.collections;

import java.util.Arrays;

/**
 * Utility methods for arrays.
 * 
 * If we're going to stick with the L1 habit of using raw ints for speed and
 * memory reasons, we can at least have some nicer wrappers.
 */
public class IntArrays {
	/**
	 * Imitation of List.contains() for int arrays.
	 */
	public static final boolean contains(int[] array, int target) {
		for (int i = 0; i < array.length; i++)
			if (target == array[i])
				return true;
		return false;
	}

	/**
	 * Sugar method for checking if a sorted array contains the given value.
	 */
	public static final boolean sContains(int[] array, int target) {
		return Arrays.binarySearch(array, target) >= 0;
	}
}
