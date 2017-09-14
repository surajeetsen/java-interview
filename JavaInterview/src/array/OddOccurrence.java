package array;

/**
 * In an array having positive integers, except for one number which occurs odd
 * number of times, all other numbers occur even number of times. Find the
 * number.
 * 
 * @author Surajeet Sen
 */
public class OddOccurrence {
	
	public int getNumberOccuringOddNumberOfTimes(int[] nums) {
		if(nums == null || nums.length == 0 || nums.length % 2 == 0) {
			return -1;
		} else if(nums.length == 1) {
			return nums[0];
		}
		
		int num = 0;
		
		for(int i : nums) {
			num = num ^ i;
		}
		
		return num;
	}
}
