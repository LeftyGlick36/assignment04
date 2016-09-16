package assignment04;

import java.util.Comparator;

public class AnagramUtil {

	/**
	 * This method returns the sorted version of the input string. The sorting
	 * must be accomplished using an insertion sort.
	 * 
	 * @param word
	 * @return
	 */
	public static String sort(String word) {

		return word;
	}

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * @param list
	 * @param cmp
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> cmp) {

	}

	/**
	 * This method returns true if the two input strings are anagrams of each
	 * other, otherwise returns false.
	 * 
	 * @param left
	 * @param right
	 * @return boolean
	 */
	public static boolean areAnagrams(String left, String right) {
		return false;
	}

	/**
	 * This method returns the largest group of anagrams in the input array of
	 * words, in no particular order. It returns an empty array if there are no
	 * anagrams in the input array.
	 * 
	 * @return String[]
	 */
	public static String[] getLargestAnagramGroup(String[] largestAnagrams) {
		return largestAnagrams;

	}

	/**
	 * Behaves the same as the previous method, but reads the list of words from
	 * the input filename. It is assumed that the file contains one word per
	 * line. If the file does not exist or is empty, the method returns an empty
	 * array because there are no anagrams.
	 * 
	 * @param filename
	 * @return String
	 */
	public static String[] getLargestAnagramGroup(String filename) {
		return null;

	}

}
