package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Print the elements of an array in the decreasing frequency.
 * 
 * @author Surajeet Sen
 */
public class SortElementsByFrequency {
	public static void main(String[] args) {
		int[] nums = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		SortElementsByFrequency sebf = new SortElementsByFrequency();
		System.out.println(Arrays.toString(sebf.sortByFrequency(nums)));
	}
	
	public int[] sortByFrequency(int[] nums) {
		//As frequency of elements cannot be larger than the array size.
		List<Integer>[] bucket = new List[nums.length + 1];
		
		//For storing the mapping of elements to frequency.
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		for(int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		}
		
		for(int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			
			if(bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		int position = 0;
		
		for(int i = bucket.length-1; i >= 0; i--) {
			if(bucket[i] != null) {
				for(int item : bucket[i]) {
					int frequency = i;
					while(frequency != 0) {
						nums[position++] = item;
						--frequency;
					}
				}
			}
		}
		return nums;
	}
}
