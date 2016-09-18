package assignment04;

import static org.junit.Assert.*;

import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void testAreAnagrams() {
		assertTrue(AnagramUtil.areAnagrams("actress", "casters"));
	}
	
	@Test
	public void testAreAnagramsIgnoreCaps() {
		assertTrue(AnagramUtil.areAnagrams("aLLerGy", "lArgELY"));
	}
	
	@Test
	public void testAreNotAnagrams() {
		assertFalse(AnagramUtil.areAnagrams("salesman", "lameness")); // This is false because salesman has an extra "a" (total of 2) unlike lameness with 1 "a'
	}

	@Test
	public void testGetLargestAnagramGroupStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLargestAnagramGroupString() {
		fail("Not yet implemented");
	}

}
