package pq_2;

import java.util.PriorityQueue;

public class KSortedArray {
	// Method to sort a k-sorted array
    public static void sortKSortedArray(int[] arr, int k) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // Add the first k+1 elements to the heap
        // This ensures that the smallest element within the range is always at the root
        for (int i = 0; i <= k && i < arr.length; i++) {
            heap.add(arr[i]);
        }

        // Initialize an index to place the sorted elements
        int minIndex = 0;

        // Process the remaining elements in the array
        for (int i = k + 1; i < arr.length; i++) {
            // Extract the smallest element from the heap and place it in the correct position
            arr[minIndex++] = heap.poll();
            // Add the current element to the heap
            heap.add(arr[i]);
        }

        // Extract the remaining elements from the heap and place them in the array
        while (!heap.isEmpty()) {
            arr[minIndex++] = heap.poll();
        }
    }


	public static void main(String[] args) {
		int[] arr = {2,1,3,5,4};
		sortKSortedArray(arr, 2);
		for(int num : arr) {
			System.out.print(num+" ");
		}
	}
}
