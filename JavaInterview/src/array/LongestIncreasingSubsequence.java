package array;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * 
 * @author Surajeet Sen
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lis.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null) {
			return 0;
		}

		int n = nums.length;
		if (n <= 1) {
			return n;
		}

		int[] dp = new int[n];
		int max = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);

					if (dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}

		return max + 1;
	}

}
