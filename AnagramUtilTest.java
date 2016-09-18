package assignment04;

import static org.junit.Assert.fail;

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
		fail();
	}

	@Test
	public void testInsertionSort() {
		AnagramComparator insertionSortCompare = new AnagramComparator();
		String[] list = {"Ace", "Bad", "Doggy","Even", "Froggy" };
		String[] numberedList = {"5","4","3","2","1"};
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
		fail("Not yet implemented");
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
