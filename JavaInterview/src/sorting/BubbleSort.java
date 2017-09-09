package sorting;

import java.util.Arrays;

/**
 * Bubble sort is a simple sorting algorithm that repeatedly steps through the
 * list to be sorted, compares each pair of adjacent items and swaps them if
 * they are in the wrong order. The pass through the list is repeated until no
 * swaps are needed, which indicates that the list is sorted.
 * 
 * @author Surajeet Sen
 */
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] arr = {10, 45, 3, 2, 1, 9, 21, 17};
		bs.doBubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void doBubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
