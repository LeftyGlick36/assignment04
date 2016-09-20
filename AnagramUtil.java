package assignment04;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * We have been asked to construct a program that determines if two words are
 * anagrams and finds the largest group of anagrams in a list of words.
 * 
 * Two words are anagrams if they contain the same letters in the same
 * frequency. For example, alert and later are anagrams.
 * 
 * Now that we know how to implement an insertion sort, we are eager to use
 * sorting to solve these two problems:
 * 
 * To check if two words are anagrams, simply sort the characters in each word.
 * If the sorted versions are the same, the words are anagrams of each other.
 * 
 * To find the largest group of anagrams in a list of words, sort the list with
 * a Comparator that compares the sorted character representations of the words.
 * 
 * After the sort, any group of words that are anagrams of each other will be
 * adjacent in the list.
 * 
 * @author Andy Dao, uID: u0692334
 * @author Moses Manning, uId: u0724216
 *
 */
public class AnagramUtil {

	/**
	 * This method returns the sorted version of the input string. The sorting
	 * must be accomplished using an insertion sort.
	 * 
	 * @param word
	 * @return
	 */
	public static String sort(String word) {
		// Place our string into an arrayList of Char's
		ArrayList<String> stringArray = new ArrayList<String>();
		// Grab each individual char at each position and add to our stringArray
		for (int i = 0; i < word.length(); i++) {
			stringArray.add(word.substring(i, i + 1));
		}

		// Use an insertionSort on our list of arrays
		for (int p = 1; p < stringArray.size(); p++) {
			// The initial state the first element, considering by itself, is
			// sorted.
			String temp = stringArray.get(p);
			int j = p;
			//
			for (; j > 0 && temp.compareToIgnoreCase(stringArray.get(j - 1)) < 0; j--) {
				stringArray.set(j, stringArray.get(j - 1));
			}
			stringArray.set(j, temp);
		}

		// Return all concatenated letters from stringArray back into a sorted
		// string
		String sortedString = "";
		for (int i = 0; i < stringArray.size(); i++) {
			sortedString = sortedString + stringArray.get(i);
		}
		return sortedString;
	}

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * @param list
	 * @param compartator
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> compartator) {
		for (int p = 1; p < list.length; p++) {
			// the initial state the first element, considering by itself, is
			// sorted.
			T temporary = list[p];
			int j = p;
			// when the second loop is entered we are guaranteed that the
			// elements in array positions 0 through
			// p–1 have already been sorted and that we need to extend this to
			// positions 0 to p
			for (; j > 0 && compartator.compare(temporary, list[j - 1]) < 0; j--)
				list[j] = list[j - 1];
			list[j] = temporary;
		}
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
		// First check to see if they're the same length
		if (left.length() != right.length()) {
			// if not, then we know automatically they're not Anagrams.
			return false;
		}

		// Using the sort method, pass in the left string and right string
		if (sort(left.toLowerCase()).equals(sort(right.toLowerCase()))) {
			// Return true if after sorted and they equal each other, they're
			// Anagrams
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method returns the largest group of anagrams in the input array of
	 * words, in no particular order. It returns an empty array if there are no
	 * anagrams in the input array.
	 * 
	 * @return String[]
	 */

	public static String[] getLargestAnagramGroup(String[] largestAnagrams) {

		// sort all possible anagrams in our string
		AnagramComparator cmp = new AnagramComparator();
		insertionSort(largestAnagrams, cmp);
		ArrayList largestGroup = new ArrayList<>();

		for (int i = 0; i < largestAnagrams.length; i++) {
			ArrayList currentLargestAnagramGroup = new ArrayList<>();

			currentLargestAnagramGroup.add(largestAnagrams[i]);

			for (int j = i + 1; j < largestAnagrams.length; j++) {

				if (areAnagrams(largestAnagrams[i], largestAnagrams[j])) {

					currentLargestAnagramGroup.add(largestAnagrams[j]);

					if (currentLargestAnagramGroup.size() > largestGroup.size()) {
						largestGroup = currentLargestAnagramGroup;

					}

				}

			}

		}
		String[] result = new String[largestGroup.size()];
		result = (String[]) largestGroup.toArray(result);

		return result;

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
