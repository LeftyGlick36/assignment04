package assignment04;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit test for AnagramUtil.
 * 
 * @author Andy Dao, uID: u0692334
 * @author Moses Manning, uId: u0724216
 */
public class AnagramUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSort() {
		assertEquals("abd", AnagramUtil.sort("dab"));
		assertEquals("abcr", AnagramUtil.sort("crab"));
		assertEquals("emoss", AnagramUtil.sort("moses"));
		assertEquals("Adny", AnagramUtil.sort("Andy"));
		assertEquals("eggr", AnagramUtil.sort("greg"));
		assertEquals("adm", AnagramUtil.sort("dam"));
		assertEquals("agiiinrV", AnagramUtil.sort("Virginia"));
		assertEquals("aABCDdEFGHIJKLMNnOPQRSTUVWXYZ", AnagramUtil.sort("ZYXWVUTSRQPONMLKJIHGFEDCBandA"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", AnagramUtil.sort("ZYXWVUTSRQPONMLKJIHGFEDCBA"));

	}

	@Test
	public void testAreAnagrams() {
		assertTrue(AnagramUtil.areAnagrams("actress", "casters"));
	}

	@Test
	public void testAreAnagramsIgnoreCaps() {
		assertTrue(AnagramUtil.areAnagrams("aLLerGy", "lArgELY"));
	}

	@Test
	public void testAreNotAnagrams() {
		// This returns false because salesman has an extra "a" (total of 2)
		// unlike lameness with 1 "a'
		assertFalse(AnagramUtil.areAnagrams("salesman", "lameness"));
	}

	@Ignore
	@Test
	public void testInsertionSort() {
		AnagramComparator insertionSortCompare = new AnagramComparator();
		String[] list = { "Ace", "bad", "Foggry", "Even", "Froggy", "dab" };
		String[] numberedList = { "5", "5", "1", "44", "353", "2", "153", "74", "1", "22", "74" };
		AnagramUtil.insertionSort(numberedList, insertionSortCompare);
		AnagramUtil.insertionSort(list, insertionSortCompare);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

		for (int i = 0; i < numberedList.length; i++) {
			System.out.println(numberedList[i]);
		}

	}

	@Test
	public void getLargestAnagramGroupString_NoPairs() {
		String[] list = { "Salesman" }; // An array with only 1 word has no
										// group of anagrams
		String[] resultArray = AnagramUtil.getLargestAnagramGroup(list); // So
		assertTrue(resultArray.length == 0);
	}

	@Test
	public void getLargestAnagramGroupString() {
		String[] list = { "cat", "Tac", "acT", "Dan", "and", "blink" };
		String[] expectedList = { "cat", "Tac", "acT" };
		assertArrayEquals(expectedList, AnagramUtil.getLargestAnagramGroup(list));
	}

	@Test
	public void getLargestAnagramGroupString2() {
		String[] list = { "Ace", "bad", "Foggry", "reacts", "Even", "Froggy", "recast", "dab" };
		String[] expectedList = { "reacts", "recast" }; // This might be wrong
														// and probably should
														// be reacts and recast
		// Waiting for discussion response to see what should be the correct
		// expected list
		//System.out.println(Arrays.toString(AnagramUtil.getLargestAnagramGroup(list)));
		assertArrayEquals(expectedList, AnagramUtil.getLargestAnagramGroup(list));
	}

	@Test
	public void getLargestAnagramGroupString_File()  {
		String[] list = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		String[] expectedList = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
		assertArrayEquals(expectedList, list);
	}
}
