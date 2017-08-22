package math;

/**
 * Determine whether an integer is a palindrome. Solve without using extra
 * space.
 * 
 * @author Surajeet Sen
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		int num = 121;
		System.out.println(new PalindromeNumber().isPalindrome(num));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x < 10) {
			return true;
		}

		if (x % 10 == 0) {
			return false;
		}

		if (x == reverse(x)) {
			return true;
		}

		return false;
	}

	private int reverse(int x) {
		int rev = 0;
		while (x > 0) {
			int r = x % 10;
			rev = rev * 10 + r;
			x = x / 10;
		}
		return rev;
	}
}
