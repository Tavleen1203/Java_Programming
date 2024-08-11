package stack_ques;

import java.util.Stack;

public class MinBracketReversals {
	public static int countMinReversals(String input) {
		int len = input.length();
		if(len==0) {
			return 0;
		}
		
		if(len%2!=0) {
			return -1;
		}
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<len; i++) {
			char c = input.charAt(i);
			if(c=='{') {
				stack.push(c);
			}else if(c=='}' && !stack.isEmpty() && stack.peek()=='{') {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		
		int count = 0;
		while(!stack.isEmpty()) {
			char c1 = stack.pop();
			char c2 = stack.pop();
			
			if(c1!=c2) {
				count+=2;
			}else {
				count+=1;
			}
		}
		return count;
	
	}
}
