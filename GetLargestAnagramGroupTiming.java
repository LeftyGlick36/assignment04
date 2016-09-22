package assignment04;

import java.util.Random;

/**
 * Timing methods for getLargestAnagramGroup timing class.
 * 2 timing methods, 1 using our implementation of insertion sort and the other timing method using java's sort method.
 * 
 * @author Andy Dao, uID: u0692334
 * @author Moses Manning, uId: u0724216
 */
public class GetLargestAnagramGroupTiming {
    private static final int ITER_COUNT = 10;

    public static void main(String[] args) {
	timeGetLargestAnagramGroup();
//	timeGetLargestAnagramGroupJavaSort();
    }

    
    private static void timeGetLargestAnagramGroup() {
	long startTime, midTime, endTime;
	
	// Set sizes of N
	for(int n = 100; n <= 2000; n+=100) {
	    String[] wordArray = stringArrayGenerator(n);

	    // Stabilize thread 
	    startTime = System.nanoTime();
	    while (System.nanoTime() - startTime < 1_000_000_000); // Stabilizes for 1 second

	    // Time the areAnagram method
	    startTime = System.nanoTime();
	    for (int i = 0; i < ITER_COUNT; i++)
	    {
		AnagramUtil.getLargestAnagramGroup(wordArray);
	    }
	    // Time empty loops for midTime and endTime that will computed in the averageTime
	    midTime = System.nanoTime();

	    for(int i = 0; i < ITER_COUNT; i++){
	    }
	    
	    endTime = System.nanoTime();

	    // Compute averageTime first with midTime - startTime, then the endTime - midTime, divide by the iteration count
	    double averageTime = ((midTime - startTime) - (endTime - midTime)) / ITER_COUNT;
	    System.out.println(n + "\t" + averageTime);
	}
    }
    
    private static void timeGetLargestAnagramGroupJavaSort() {
	long startTime, midTime, endTime;

	// Set sizes of N
	for(int n = 100; n <= 2000; n+= 100) {
	    String[] wordArray = stringArrayGenerator(n);

	    // Stabilize thread 
	    startTime = System.nanoTime();
	    while (System.nanoTime() - startTime < 1_000_000_000); // Stabilizes for 1 second

	    // Time the areAnagram method
	    startTime = System.nanoTime();
	    for (int i = 0; i < ITER_COUNT; i++)
	    {
		AnagramUtil.getLargestAnagramGroupJavaSort(wordArray);
	    }
	    // Time empty loops for midTime and endTime that will computed in the averageTime
	    midTime = System.nanoTime();
	    for(int i = 0; i < ITER_COUNT; i++);
	    endTime = System.nanoTime();

	    // Compute averageTime first with midTime - startTime, then the endTime - midTime, divide by the iteration count
	    double averageTime = ((midTime - startTime) - (endTime - midTime)) / ITER_COUNT;
	    System.out.println(n + "\t" + averageTime);
	}
    }


    /**
     * Creates a string array for the size of N (numOfWords), using the random string generator 
     * @param numOfWords - Number of words in the array (size of array)
     * @return - the string array of N set sizes
     */
    private static String[] stringArrayGenerator(int numOfWords) {
	String[] stringArray = new String[numOfWords];
	
	// Number of words to generate
	for (int i = 0; i < stringArray.length; i++)
	{
	  stringArray[i] = randomStringGenerator(25);
	}
	return stringArray;
    }
    
    /**
     * Creates a random string from 0 to 15 of length.
     * @param length - from 0 to 25 of the letters available to use
     * @return - new random string
     */
    private static String randomStringGenerator(int length)
    {
	String stringGen = "";
	Random randomNumber = new Random();
	int randNum;
	char character;
	// Create a string for a length of 0 to 15
	for (int i = 5; i < 15; i++)
	{
	    // Create a character and append it to the string
	    randNum = (randomNumber.nextInt(length));
	    character = (char) randNum;
	    stringGen += character;
	}

	return stringGen;
    }

}
