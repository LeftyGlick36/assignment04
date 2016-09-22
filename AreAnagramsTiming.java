package assignment04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Timing class for areAnagrams.
 * 
 * @author Andy Dao, uID: u0692334
 * @author Moses Manning, uId: u0724216
 */
public class AreAnagramsTiming {
    private static final int ITER_COUNT = 100;


    public static void main(String[] args) {
	timeAreAnagrams();
    }


    /**
     * Timing shindig for areAnagrams()
     */
    private static void timeAreAnagrams() {
	try(FileWriter fw = new FileWriter(new File("areAnagrams.tsv"))) { //open up a file writer so we can write to file.
	    // Set sizes of N
	    for(int n = 1000; n <= 20000; n*=2) {
		long startTime, midTime, endTime;
		
		// Create random strings of the length of N
		String firstString = randomStringGenerator(n); 
		String secondString = randomStringGenerator(n);

		// Stabilize thread 
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1_000_000_000);// Stabilizes for 1 second

		// Time the areAnagram method
		startTime = System.nanoTime();
		for (int i = 0; i < ITER_COUNT; i++)
		{
		    AnagramUtil.areAnagrams(firstString, secondString);
		}
		// Time empty loops for midTime and endTime that will computed in the averageTime
		midTime = System.nanoTime();
		for(int i = 0; i < ITER_COUNT; i++){
		}

		endTime = System.nanoTime();
		// Compute averageTime first with midTime - startTime, then the endTime - midTime, divide by the iteration count
		double averageTime = ((midTime - startTime) - (endTime - midTime)) / ITER_COUNT;
		System.out.println(n + "\t" + averageTime);
		fw.write(n + "\t" + averageTime);
	}
    } catch (IOException e) {
	e.printStackTrace();
    }

}

/**
 * Creates a random string from 0 to the length specified
 * @param length - length of string
 * @return - random created string with a specified length.
 */
private static String randomStringGenerator(int length)
{
    String stringGen = "";
    Random randomNumber = new Random();
    int randNum;
    char character;

    // Create the new string for the length of the given length
    for (int i = 0; i < length; i++)
    {
	randNum = (randomNumber.nextInt(25));
	character = (char) randNum;
	stringGen += character;
    }
    return stringGen;
}
}
