package math;

/**
 * This class calculates the number of trailing zeroes the factorial of a number
 * contains.
 * 
 * @author Surajeet Sen
 */
public class FactorialTrailingZeroes {

	public int getTrailingZeroes(int n) {
		int count = 0;

		for (long i = 5; n / i >= 1; i = i * 5) {
			count += n / i;
		}
		
		return count;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		System.out.println(ftz.getTrailingZeroes(10));
	}
}
