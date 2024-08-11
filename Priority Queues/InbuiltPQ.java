package pq_2;

import java.util.PriorityQueue;

public class InbuiltPQ {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[] arr = {9,1,0,4,7,3};
		for(int num : arr) {
			pq.add(num);
		}
		
		System.out.println(pq.peek());// NO EXCEPTION
		System.out.println(pq.element());
		
		while(!pq.isEmpty()) {
			System.out.print(pq.remove()+" ");
		}
	}

}
