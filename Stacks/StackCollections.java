package stack;

import java.util.Stack;

public class StackCollections {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(8);
		s.peek();
		s.add(3, 11);
	}
}
