package stack_ques;

import java.util.Stack;

public class RedundantParenthesis {
	public static boolean checkRedundant(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(char c: s.toCharArray()) {
			if(c=='(') {
				stack.push(c);
			}else if(c==')') {
				boolean hasOperators = false;
				
				while(!stack.isEmpty() && stack.peek()!='(') {
					char top = stack.pop();
					if(top=='+' || top=='-' || top=='*' || top=='/') {
						hasOperators = true;
					}
				}
				
				stack.pop();
				
				if(!hasOperators) {
					return true;
				}		
			}else{
				stack.push(c);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str = "(a+b)";
		System.out.println(checkRedundant(str));
	}
}
