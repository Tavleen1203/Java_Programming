package pq_2;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Comparator implements java.util.Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		}else {
			return 1;
		}
	}
	
}
public class KSmallestElements {
	public static ArrayList<Integer> kSmallestNums(int[] arr, int k){
		Comparator maxComp = new Comparator();
		PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(maxComp);
		
		for(int i =0 ; i<k ; i++) {
			max_heap.add(arr[i]);
		}
		
		for(int i=k;i<arr.length; i++) {
			if(arr[i]>max_heap.peek()) {
				continue;
			}
			int temp = max_heap.remove();
			max_heap.add(arr[i]);
			arr[i] = temp;
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(!max_heap.isEmpty()) {
			ans.add(max_heap.remove());
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {9,8,3,4,7,0,1};
		ArrayList<Integer> ans = kSmallestNums(arr, 5);
		for(int num : ans) {
			System.out.print(num+" ");
		}
	}
}
