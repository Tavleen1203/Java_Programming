package queues_ques;
import java.util.*;

public class ReverseFirstKNums {
	public static Queue<Integer> reverseK(Queue<Integer> q, int k) {
		if(q.isEmpty() || k> q.size()) {
			return q;
		}
		
		if(k<=0) {
			return q;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<k;i++) {
			s.push(q.poll());
		}
		
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
		
		for(int i=0; i< q.size()-k;i++) {
			q.add(q.poll());
		}
		
		return q;
	}
}
