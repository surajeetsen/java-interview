package math;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author Surajeet Sen
 */
public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(123));
	}
	
	public int reverse(int x) {
        long result = 0;
        
        do {
            result = result * 10 + x % 10;
        } while((x/=10) != 0);
        
        return (Math.abs(result) > Integer.MAX_VALUE) ? 0 : (int) result;
    }
}
