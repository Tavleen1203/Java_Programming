package pq_2;

import java.util.Comparator;
import java.util.PriorityQueue;

class MaxPQComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1<o2) {
			return 1;
		}else if(o1>o2) {
			return -1;
		}
		return 0;
	}
	
}
public class MaxHeap {
	public static void main(String[] args) {
		MaxPQComparator maxPQ =  new MaxPQComparator();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(maxPQ);
		int arr[] = {3,4,6,5,2,3,1,0,3,6,9};
		
		for(int num : arr) {
			pq.add(num);
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() +" ");
		}
	}
}
