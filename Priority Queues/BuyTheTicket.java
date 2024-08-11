
package pq_assignment;
import java.util.*;

class maxComp implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		}else {
			return 1;
		}
	}
}

public class BuyTheTicket {
	public static int buyTime(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		maxComp comp = new maxComp();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
		
		for(int i : arr) {
			q.add(i);
			pq.add(i);
		}
		
		int time = 0;
		while(!pq.isEmpty()) {
			if(q.peek().equals(pq.peek())) {
				if(k==0) {
					return time+1;
				}else {
					time++;
					q.poll();
					pq.poll();
					k--;
				}
			}else {
				q.add(q.peek());
				q.poll();
				if(k==0) {
					k=q.size()-1;
				}else {
					k--;
				}
			}
		}
		return time;
	}

	public static void main(String[] args) {
		int[] arr = {3,9,4};
		System.out.println(buyTime(arr, 2));
	}
}
