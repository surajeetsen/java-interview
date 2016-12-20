package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility program to validate Roman number and convert the number to Integer
 * 
 * @author Surajeet
 */
class RomanUtil {

	/**
	 * The romanMap contains mapping of RomanNumbers to Values
	 */
	private static final Map<Character, Integer> romanMap = new HashMap<>();

	/**
	 * The nonRepeatingAlphabets contains alphabets that cannot be repeated
	 */
	private static final Map<Character, Integer> nonRepeatingAlphabetsMap = new HashMap<>();

	static {
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		nonRepeatingAlphabetsMap.put('D', 0);
		nonRepeatingAlphabetsMap.put('L', 0);
		nonRepeatingAlphabetsMap.put('V', 0);
	}

	/**
	 * Converts Roman Number to Integer
	 * 
	 * @param roman
	 * @return The integer value of the Roman number
	 */
	public static int convertToInteger(String romanNumber) {
		romanNumber = romanNumber.toUpperCase();
		
		if(isDLVRepeated(romanNumber) && !isValidRepeatation(romanNumber)) {
			return 0;
		}

		return getDecimal(romanNumber);
	}

	/**
	 * Utility method to convert Roman Number to Integer
	 * 
	 * @param romanNumber
	 *            The Roman number
	 * @return The int value of the Roman number
	 */
	public static int getDecimal(String romanNumber) {
		int decimal = 0;
		int prevNumber = 0;

		for (int x = romanNumber.length() - 1; x >= 0; x--) {
			char c = romanNumber.charAt(x);
			int currentDecimal = romanMap.get(c);

			switch (c) {
			case 'I':
				decimal = processDecimal(currentDecimal, prevNumber, decimal);
				break;

			case 'V':
				decimal += currentDecimal;
				break;

			case 'X':
				decimal = processDecimal(currentDecimal, prevNumber, decimal);
				break;

			case 'L':
				decimal += currentDecimal;
				break;

			case 'C':
				decimal = processDecimal(currentDecimal, prevNumber, decimal);
				break;

			case 'D':
				decimal += currentDecimal;
				break;

			case 'M':
				decimal = processDecimal(currentDecimal, prevNumber, decimal);
				break;
			}
			prevNumber = currentDecimal;
		}
		return decimal;
	}

	/**
	 * "I" can be subtracted from "V" and "X" only. "X" can be subtracted from
	 * "L" and "C" only. "C" can be subtracted from "D" and "M" only.
	 * 
	 * @param currentDecimal The int value of the current Roman Alphabet
	 * @param prevDecimal The int value of the Previous Roman Albhabet
	 * @param decimal The decimal value
	 * @return
	 */
	private static int processDecimal(int currentDecimal, int prevDecimal, int decimal) {
		if (currentDecimal < prevDecimal && prevDecimal <= currentDecimal * 10) {
			return (decimal - currentDecimal);
		} else {
			return (decimal + currentDecimal);
		}
	}

	/**
	 * Utility method to enforce the constraint "D", "L", and "V" can never be
	 * repeated.
	 * 
	 * @param roman The Roman number
	 * @return true if the Roman number is in-valid, else false
	 */
	private static boolean isDLVRepeated(String roman) {
		char[] result = roman.toCharArray();

		for (int i = 0; i < result.length; i++) {
			if (nonRepeatingAlphabetsMap.containsKey(result[i])) {
				int val = nonRepeatingAlphabetsMap.get(result[i]);
				if (val >= 1) {
					return true;
				}
				nonRepeatingAlphabetsMap.put(result[i], val + 1);
			}
		}

		return false;
	}

	/**
	 * The symbols "I", "X", "C", and "M" can be repeated three times in
	 * succession, but no more. (They may appear four times if the third and
	 * fourth are separated by a smaller value, such as XXXIX.)
	 * 
	 * @param roman The Roman number
	 * @return true if the Roman number is valid, else false
	 */
	private static boolean isValidRepeatation(String roman) {
		char[] result = roman.toCharArray();
		
		if (result.length > 3) {
			for (int i = 0; i < result.length - 3; i++) {
				if ((result[i] == result[i + 1]) && (result[i + 1] == result[i + 2])) {
					if (result[i] == result[i + 3]) {
						return false;
					}
					if (result.length > i + 5) {
						if (result[i + 4] == result[i]) {
							if (romanMap.get(result[i + 3]) > romanMap.get(result[i + 4])) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}