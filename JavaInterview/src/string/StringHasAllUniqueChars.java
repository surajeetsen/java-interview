package string;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * (Ref: Cracking the coding interview) 
 * 
 * @author Surajeet Sen
 */
public class StringHasAllUniqueChars {
	
	// If the string is composed of ASCII characters
	public boolean areAllUniqueChars1(String str) {
		if (str.length() > 256) {
			return false;
		}

		boolean[] charSet = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			if (charSet[str.charAt(i)]) {
				return false;
			}
			charSet[str.charAt(i)] = true;
		}
		return true;
	}

	// If the string only contains characters a-z (only lower case)
	public boolean areAllUniqueChars2(String str) {
		int checker = 0;

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';

			if ((checker & (1 << val)) > 0) {
				return false;
			}

			checker |= (1 << val);
		}
		return true;
	}
}