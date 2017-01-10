package string;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, 
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * @author Surajeet Sen
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic("paper", "title"));
	}

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] indexArr = new int[512];

		for (int i = 0; i < s.length(); i++) {
			if (indexArr[s.charAt(i)] != indexArr[t.charAt(i) + 256]) {
				return false;
			}
			indexArr[s.charAt(i)] = i + 1;
			indexArr[t.charAt(i) + 256] = i + 1;
		}

		return true;
	}
}
