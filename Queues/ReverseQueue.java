package queues_ques;

import java.util.Queue;

public class ReverseQueue {
	public static void reverse(Queue<Integer> q) {
		if(q.size()<=1) {
			return;
		}
		int front = q.poll();
		reverse(q);
		q.add(front);
	}
}
