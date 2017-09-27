package array;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * https://leetcode.com/problems/majority-element/description/
 * 
 * @author Surajeet Sen
 */
public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(new int[]{1,1,2,3,2,3,3,3,3,4,5}));
	}
	
	public int majorityElement(int[] nums) {
		int count = 0;
		int major = nums[0];

		for (int i : nums) {
			if (count == 0) {
				count++;
				major = i;
			} else if (major == i) {
				count++;
			} else {
				count--;
			}
		}

		return major;
	}
}
