package array;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * @author Surajeet Sen
 */
public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;

		if (n <= 1) {
			return nums;
		}

		int[] result = new int[n];

		// From left to right;
		result[0] = 1;
		int temp = 1;
		for (int i = 1; i < n; i++) {
			temp = temp * nums[i - 1];
			result[i] = temp;
		}

		// From right to left
		temp = 1;
		for (int i = n - 2; i >= 0; i--) {
			temp = temp * nums[i + 1];
			result[i] = result[i] * temp;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		ProductOfArrayExceptSelf paes = new ProductOfArrayExceptSelf();
		System.out.println(Arrays.toString(paes.productExceptSelf(nums)));
	}

}
