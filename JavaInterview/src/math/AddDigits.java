package math;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * https://leetcode.com/problems/add-digits/
 * 
 * @author Surajeet Sen
 *
 */
public class AddDigits {
	
	public int addDigits(int num) {
        if(num == 0) {
            return 0;
        }
        
        int s = num % 9;
        
        return (s>0)? s : 9;
    }
	
	public static void main(String[] args) {
		AddDigits ad = new AddDigits();
		System.out.println(ad.addDigits(38));
	}
	
}