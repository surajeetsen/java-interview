package string;

/**
 * Determine if a string is an anagram of another string.
 * 
 * @author Surajeet Sen
 */
public class CheckAnagram {
	public boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int[] noOfChars = new int[256];
		
		for(int i = 0; i < s1.length(); i++) {
			noOfChars[(int) s1.charAt(i)]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			if(--noOfChars[(int) s2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}
}
