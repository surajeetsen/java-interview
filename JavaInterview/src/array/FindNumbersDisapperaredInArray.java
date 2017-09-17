package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 
 * @author Surajeet Sen
 */
public class FindNumbersDisapperaredInArray {

	public static void main(String[] args) {
		FindNumbersDisapperaredInArray fnd = new FindNumbersDisapperaredInArray();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

		fnd.findDisappearedNumbers(nums).stream().forEach(System.out::println);
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int index = Math.abs(nums[i]) - 1;

			if (nums[index] > 0) {
				nums[index] = -nums[index];
			}
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}

		return list;
	}
}
