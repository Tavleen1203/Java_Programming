package stack_ques;

import java.util.Stack;

public class StockSpan {
	public static int[] stockSpan(int[] price) {
		Stack<Integer> stack = new Stack<Integer>();
		int n = price.length;
		int[] spans = new int[n];
		
		stack.push(0);
		spans[0]=1;
		
		for(int i =1; i<n; i++) {
			while(!stack.isEmpty() && price[stack.peek()]<price[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				spans[i]=i+1;
			}else{
				spans[i]=i-stack.peek();
			}
			stack.push(i);
		}
		return spans;
	}
}
