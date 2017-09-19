package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array. Each element in the array represents your maximum jump length at that
 * position. Determine if you are able to reach the last index.
 * 
 * For example: 
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author Surajeet Sen
 */
public class JumpGame {

	public static void main(String[] args) {
		JumpGame jp = new JumpGame();
		System.out.println(jp.canJump(new int[]{2,3,1,1,4}));
		System.out.println(jp.canJump(new int[]{3,2,1,0,4}));
	}

	public boolean canJump(int[] nums) {
		int n = nums.length;
		if (n == 0 || (nums[0] == 0 && n > 1)) {
			return false;
		} else if (n == 1) {
			return true;
		}

		int maxReached = 0;
		for (int i = 0; i < n - 1; i++) {
			if (i > maxReached) {
				return false;
			}

			if (maxReached < (i + nums[i])) {
				maxReached = i + nums[i];
			}

			if (maxReached >= (n - 1)) {
				return true;
			}
		}
		return false;
	}
}
