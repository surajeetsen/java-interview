package array;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * https://leetcode.com/problems/find-peak-element/description/
 * 
 * @author Surajeet Sen
 */
public class PeakElement {
	
	public static void main(String[] args) {
		int [] nums = {1, 2, 3, 1};
		System.out.println(new PeakElement().findPeakElement(nums));
	}
	
	public int findPeakElement(int[] nums) {
        return findPeakRec(nums, 0, nums.length-1);
    }
    
    private int findPeakRec(int[] arr, int low, int high) {
        if(low == high) {
            return low;
        }
        
        if(high - low == 1) {
            return (arr[high] > arr[low]) ? high : low;
        }
        
        int mid = low + (high-low)/2;
        
        if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
            return mid;
        }
        
        if(arr[mid] < arr[mid+1]) {
            return findPeakRec(arr, mid+1, high);
        } else {
            return findPeakRec(arr, low, mid-1);
        }
        
    }
}
