package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The MerchantsGuideSolver programs has utility methods for
 * solving the Merchant's Guide to Galaxy Problem.
 * 
 * @author Surajeet
 */
public class MerchantsGuideSolver {

	/**
	 * The intergalacticRate has the mapping of intergalactic items and their respective prices.
	 */
	private static final Map<String, String> intergalacticRate = new HashMap<>();

	/**
	 * The metalList is the list of Metals
	 */
	private static final List<String> metalList = new ArrayList<>();

	/**
	 * The metalRate has the mapping of metals and their respective prices.
	 */
	private static final Map<String, Float> metalRate = new HashMap<>();

	/**
	 * The output is the output to the questions asked.
	 */
	private static StringBuilder output = new StringBuilder();

	/**
	 * The list if Questions to be answered
	 */
	private static final List<String> questions = new ArrayList<>();
	
	/**
	 * String to be returned when a wrong question is asked
	 */
	private static final String NOT_A_CORRECT_QUESTION = "I have no idea what you are talking about";

	/**
	 * Processes the input file line by line.
	 * 
	 * @param fileName The name of the file
	 * @return The output string containing the answers to the questions asked
	 */
	public static String processInputFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				processLine(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Not a valid file name.");
		} catch (IOException e) {
			System.err.println("Unable to read file.");
		}

		updateMetalRateMap(metalList);
		processQuestions(questions);

		return output.toString();
	}

	/**
	 * Utility method to process each line of the input file.
	 * 
	 * @param line Each line of the input file.
	 */
	private static void processLine(String line) {
		String[] arr = line.split("\\s+");

		if (line.endsWith("?")) { //If the input line is a question
			questions.add(line);
		} else if (arr.length == 3 && arr[1].equalsIgnoreCase("is")) { //If the input line contains price of an intergalactic item
			intergalacticRate.put(arr[0], arr[arr.length - 1]);
		} else if (line.toLowerCase().endsWith("credits")) { //If the input line contains details about a metal transaction
			metalList.add(line);
		}
	}
	
	/**
	 * Calculates the price of each input metals
	 * and update the Metal to Rate mapping
	 * 
	 * @param list The list of metals
	 */
	private static void updateMetalRateMap(List<String> list) {
		for (String str : list) {
			String[] arr = str.split("\\s+");
			StringBuilder sb = new StringBuilder();
			int endIndex = arr.length - 4;
			String metal = arr[endIndex];

			for (int i = 0; i < endIndex; i++) {
				sb.append(intergalacticRate.get(arr[i]));
			}

			int romanToInt = RomanUtil.convertToInteger(sb.toString());
			float rate = Float.parseFloat(arr[arr.length - 2]) / romanToInt;

			metalRate.put(metal, rate);
		}
	}
	
	/**
	 * Utility method to process the list of questions.
	 * It appends the answers to the output string.
	 * 
	 * @param list The list of questions asked.
	 */
	private static void processQuestions(List<String> list) {
			for (String str : list) {
			String[] arr = str.split("\\s+");
			boolean isMetalTxn = false;
			boolean notAVaildInp = false;
			int startIndex = 0;
			int endIndex = 0;
			StringBuilder sb = new StringBuilder();

			if (str.trim().toLowerCase().startsWith("how much is")) { //If it's an intergalactic transaction question
				startIndex = 3;
				endIndex = arr.length - 2;
			} else if (str.trim().toLowerCase().startsWith("how many credits is")) { //Else if it's a metal transaction
				if (!metalRate.containsKey(arr[arr.length - 2])) { // If the metal is not there in the metal map.
					appendNotACorrectQuestion();
					continue;
				}
				
				startIndex = 4;
				endIndex = arr.length - 3;
				isMetalTxn = true;
			} else {  //Else it's not a valid question
				appendNotACorrectQuestion();
				continue;
			}

			for (int i = startIndex; i <= endIndex; i++) {
				if (!intergalacticRate.containsKey(arr[i])) { //If the item is not there in the map of intergalactic items.
					appendNotACorrectQuestion();
					notAVaildInp = true;
					break;
				}
				sb.append(intergalacticRate.get(arr[i]));
			}
			
			if(notAVaildInp) {
				continue;
			}

			for (int i = startIndex; i <= endIndex; i++) {
				output.append(arr[i] + " ");
			}

			int value = RomanUtil.convertToInteger(sb.toString());
			if (isMetalTxn) {
				output.append(arr[endIndex+1] + " ");
				value = Math.round(value * metalRate.get(arr[arr.length - 2]));
				output.append("is ").append(value).append(" Credits");
			} else {
				output.append("is ").append(value);
			}
			
			output.append(System.lineSeparator());
		}
	}
	
	/**
	 * Utility method called when a wrong question is asked.
	 * This method appends a NOT_A_CORRECT_QUESTION string to 
	 * the output
	 */
	private static void appendNotACorrectQuestion() {
		output.append(NOT_A_CORRECT_QUESTION);
		output.append(System.lineSeparator());
	}

}