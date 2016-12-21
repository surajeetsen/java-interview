package string;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * @author Surajeet Sen
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		StringBuilder s_rev = new StringBuilder(s).reverse();
		StringBuilder srev_s = new StringBuilder().append(s).append("#").append(s_rev);
		int val = s_rev.length() - computeKMPTable(srev_s.toString())[srev_s.length() - 1];
		return s_rev.substring(0, val) + s;
	}

	public int[] computeKMPTable(String pattern) {
		int[] pat = new int[pattern.length()];
		int i = 1;
		int j = 0;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pat[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = pat[j - 1];
				} else {
					pat[i] = 0;
					i++;
				}
			}
		}
		return pat;
	}

	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome("abcd"));
	}
}
