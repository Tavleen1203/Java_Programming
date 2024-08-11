package stack;

public class StackArrayUse {

	public static void main(String[] args) throws StackEmptyException {
		StackArray stack = new  StackArray();
		stack.push(5);
		stack.push(10);
		stack.push(15);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
	}

}
