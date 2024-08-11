package pq_2;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class KLargestElements {
	public static ArrayList<Integer> kLargestNums(int[]  arr, int k){
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for(int i=0;i<k;i++) {
			heap.add(arr[i]);
		}
		for(int i=k;i<arr.length;i++) {
			if(arr[i]<heap.peek()) {
				continue;
			}
			int temp = heap.remove();
			heap.add(arr[i]);
			arr[i]=temp;
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(!heap.isEmpty()) {
			ans.add(heap.remove());
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {4,6,7,2,3,1,8,3,9,9};
		ArrayList<Integer> ans = kLargestNums(arr, 4);
		for(int num : ans) {
			System.out.print(num+" ");
		}
	}
}
