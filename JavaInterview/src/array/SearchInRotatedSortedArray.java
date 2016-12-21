package array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target
 * value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author Surajeet Sen
 */
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length < 1) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			// If the first half is sorted
			if (nums[start] <= nums[mid]) {
				// If the target lies in the first half
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // if the second half is sorted
				// If the number lies in the second half
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		SearchInRotatedSortedArray srsa = new SearchInRotatedSortedArray();
		System.out.println(srsa.search(nums, 7));
	}

}
