package sorting;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int [] arr = {10, 45, 3, 2, 1, 9, 21, 17};
		
		new HeapSort().doHeapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void doHeapSort(int[] arr) {
		heapify(arr, arr.length);
		
		for(int i = 0; i < arr.length - 1; i++) {
			//swap the first with the last
			int temp = arr[0];
			arr[0] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
			
			heapify(arr, arr.length - i - 1);
		}
	}
	
	public void heapify(int[] arr, int n) {
		for(int i = n/2 - 1; i >= 0; i--) {
			maxHeap(i, n, arr);
		}
	}
	
	public void maxHeap(int i, int n, int[] arr) {
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			maxHeap(largest, n, arr);
		}
	}
}
