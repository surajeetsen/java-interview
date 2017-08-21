package bitManipulation;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * 
 * @author Surajeet Sen
 */
public class SumOfTwoIntegers {
	public static void main(String[] args) {
		System.out.println(new SumOfTwoIntegers().getSum(99, 9));
	}

	public int getSum(int a, int b) {
		int sum = a ^ b;
		int carry = (a & b) << 1;

		while (carry != 0) {
			return getSum(sum, carry);
		}

		return sum;
	}
}