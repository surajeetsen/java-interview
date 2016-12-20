package leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author Surajeet Sen
 */
public class TrappingRainWater2D {
	public int trap(int[] height) {
		if (height == null || height.length <= 2) {
			return 0;
		}
		int n = height.length;
		int[] maxHeightRight = new int[n];

		maxHeightRight[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxHeightRight[i] = Math.max(height[i], maxHeightRight[i + 1]);
		}

		int maxWaterTrapped = 0;
		int maxLeftHeight = height[0];
		for (int i = 1; i < n - 1; i++) {
			if (height[i] > maxLeftHeight || height[i] > maxHeightRight[i]) {
				if (height[i] > maxLeftHeight) {
					maxLeftHeight = height[i];
				}
				continue;
			}
			maxWaterTrapped += Math.min(maxLeftHeight, maxHeightRight[i]) - height[i];
		}

		return maxWaterTrapped;
	}
	
	public static void main(String[] args) {
		TrappingRainWater2D trw = new TrappingRainWater2D();
		int[] elevationArr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trw.trap(elevationArr));
	}
}
