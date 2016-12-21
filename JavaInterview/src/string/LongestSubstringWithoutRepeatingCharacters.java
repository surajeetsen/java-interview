package string;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author Surajeet Sen
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int getLengthOfLongestSubstring(String s) {
		int n = s.length();
		if (n <= 1) {
			return n;
		}

		int[] indexArr = new int[256];

		for (int i = 0; i < 256; i++) {
			indexArr[i] = -1;
		}

		int max = 1;
		int currentMax = 0;
		int start = 0;

		for (int i = 0; i < n; i++) {
			int c = s.charAt(i);

			if (indexArr[c] < start) {
				++currentMax;
				indexArr[c] = i;
			} else {
				if (indexArr[c] < start) {
					++currentMax;
				} else {
					start = indexArr[c] + 1;
					currentMax = i - indexArr[c];
					indexArr[c] = i;
				}
			}

			if (currentMax > max) {
				max = currentMax;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lswrs = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lswrs.getLengthOfLongestSubstring("abcabcbb"));
	}

}
