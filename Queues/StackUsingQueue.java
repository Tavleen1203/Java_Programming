package queues;
import java.util.*;

public class StackUsingQueue {
	private Queue<Integer> q;
	
	public StackUsingQueue() {
		q=new LinkedList<Integer>();
	}
	
	int size() {
		return q.size();
	}
	
	boolean isEmpty() {
		return q.isEmpty();
	}
	
	void push(int a) {
		int size = q.size();
		q.add(a);
		
		for(int i=0; i<size; i++) {
			q.add(q.poll());
		}
	}
	
	int top() {
		if(isEmpty()) {
			return -1;
		}
		return q.peek();
	}
	
}
