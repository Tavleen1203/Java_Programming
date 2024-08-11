package pq_assignment;

import java.util.PriorityQueue;

public class KthLargestElement {
	public static int kthNum(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int i=0;i<k;i++) {
			heap.add(arr[i]);
		}
		for(int i=k;i<arr.length;i++) {
			if(arr[i]>heap.peek()) {
				int temp = heap.remove();
				heap.add(arr[i]);
				arr[i]=temp;
			}else {
				continue;
			}
		}
		return heap.peek();
	}
	

	public static void main(String[] args) {
		int[] arr = {2,7,10,9,5,4,8};
		System.out.println(kthNum(arr, 3));
	}
}
