package stack;

import java.util.Stack;

public class BalancedParenthesis {
	public static boolean isBracketBalanced(String input) {
		
		Stack<Character> s = new Stack<Character>();
		for(char c : input.toCharArray()) {
			if(c=='(') {
				s.push(c);
			}else if (c==')') {
				if(s.isEmpty()) {
					return false;
				}
				s.pop();
			}
		}
		return s.isEmpty();
	}

	public static void main(String[] args) {
		String str = "(a + b)+((c+d)+e)+f)";
	    System.out.println(isBracketBalanced(str));	
	}

}
