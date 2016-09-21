package assignment04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import assignment03.Charter;

/**
 * @author Andy Dao, uID: u0692334
 * @author Moses Manning, uId: u0724216
 */

public class AnagramUtilTiming {

	/**
	 * @author Andy Dao, uID: u0692334
	 * @author Moses Manning, uId: u0724216
	 */

	private static Random rand;
	private static final int ITER_COUNT = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//areAnagramsTiming();
		getLargestAnagramGroupTiming();
	}

	public static void areAnagramsTiming() {
		// Set up the random number generator for the randomString function
		// Random rand = new Random();
		long startTime = System.nanoTime();

		while (System.nanoTime() - startTime < 1_000_000_000)
			;
		try (FileWriter fw = new FileWriter(new File("areAnagrams_experiment.tsv"))) {
			for (int exp = 10; exp <= 20; exp++) { // This is used as the
													// exponent to calculate the
													// size of the set.
				int size = (int) Math.pow(2, exp); // or ..

				// Do the experiment multiple times, and average out the results
				long totalTime = 0;

				for (int iter = 0; iter < ITER_COUNT; iter++) {

					// SET UP!
					ArrayList<String> words = new ArrayList<>();

					for (int i = 0; i < size; i++) {
						words.add(randomString(5));
					}

					String[] anagramWords = new String[words.size()]; // This
																		// gets
																		// me a
																		// random
																		// int
																		// between
																		// 0 and
																		// size;
					anagramWords = (String[]) words.toArray(anagramWords);
					// TIME IT!
					long start = System.nanoTime();
					for (int i = 0; i < words.size() - 1; i++) {
						AnagramUtil.areAnagrams(anagramWords[i], anagramWords[i + 1]);
					}
					long stop = System.nanoTime();
					totalTime += stop - start;
				}
				double averageTime = totalTime / (double) ITER_COUNT;
				fw.write(size + "\t" + averageTime + "\n"); // write to file.

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Charter charter = new Charter();
		charter.createChart("areAnagrams_experiment.tsv", "chart.png");
		// Reads a text file with a single word per line, returns them as an
		// array of Strings
	}

	public static void getLargestAnagramGroupTiming() {
		// Set up the random number generator for the randomString function
		// Random rand = new Random();
		long startTime = System.nanoTime();

		while (System.nanoTime() - startTime < 1_000_000_000)
			;
		try (FileWriter fw = new FileWriter(new File("areAnagrams_experiment.tsv"))) {
			for (int exp = 10; exp <= 20; exp++) { // This is used as the
													// exponent to calculate the
													// size of the set.
				int size = (int) Math.pow(2, exp); // or ..

				// Do the experiment multiple times, and average out the results
				long totalTime = 0;

				for (int iter = 0; iter < ITER_COUNT; iter++) {

					// SET UP!
					String[] words = readFile("wordEn.txt");

					

					//String[] anagramWords = new String[words.size()]; // This
																		// gets
																		// me a
																		// random
																		// int
																		// between
																		// 0 and
																		// size;
					//anagramWords = (String[]) words.toArray(anagramWords);
					// TIME IT!
					long start = System.nanoTime();
					for (int i = 0; i < words.length - 1; i++) {
						AnagramUtil.getLargestAnagramGroup(words);
					}
					long stop = System.nanoTime();
					totalTime += stop - start;
				}
				double averageTime = totalTime / (double) ITER_COUNT;
				fw.write(size + "\t" + averageTime + "\n"); // write to file.

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Charter charter = new Charter();
		charter.createChart("areAnagrams_experiment.tsv", "chart.png");
		// Reads a text file with a single word per line, returns them as an
		// array of Strings
	}

	// Create a random string [a-z] of specified length
	public static String randomString(int length) {
		Random rand = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			// ASCII values a-z,A-Z are contiguous (52 characters)
			char randomChar = (char) ('a' + (rand.nextInt(26)));// This will
																// throw a null
																// pointer! Find
																// the bug and
																// squash it!
			stringBuilder.append(randomChar);
		}
		return stringBuilder.toString();
	}

	// Reads words from a file (assumed to contain one word per line)
	// Returns the words as an array of strings.
	public static String[] readFile(String filename) {
		ArrayList<String> results = new ArrayList<String>();
		try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
			while (input.ready()) {
				results.add(input.readLine());
				results.add(randomString(1000));
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results.toArray(new String[results.size()]);
	}
}
