package pq_assignment;
import java.util.*;

public class RunningMedian {
	private PriorityQueue<Integer> left;
	private PriorityQueue<Integer> right;
	
	public RunningMedian() {
		left = new PriorityQueue<Integer>(Collections.reverseOrder());
		right = new PriorityQueue<Integer>();
	}
	
	public void addNum(int num) {
		if(left.isEmpty() || num <left.peek()) {
			left.add(num);
		}else {
			right.add(num);
		}
		
		if(left.size()-right.size()>1) {
			right.add(left.poll());
		} else if ( left.size()<right.size()) {
			left.add(right.poll());
		}
	}
	
	public int findMedian() {
		if(left.size()==right.size()) {
			return (left.peek()+right.peek())/2;
		}else {
			return left.peek();
		}
	}

}
