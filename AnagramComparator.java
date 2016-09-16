package assignment04;

public abstract class AnagramComparator implements Comparable<String> {

	/**
	 * Determine if we use Comparator or Comparable If Comparator is null, use
	 * Comparable If Comparator is not null, use our compare
	 * 
	 * @param comparator
	 * 
	 * @param left
	 *            - leftWord to compare to the right word
	 * @param right
	 *            - right side to compare to the left
	 * @return - negative number if left is not equal to right, and a positive
	 *         number if left is equal to the right.
	 */
	public int compareTo(String left, String right) {

		if (AnagramUtil.areAnagrams(left, right)) {
			return 1;
		} else {
			return -1;
		}

	}

}
