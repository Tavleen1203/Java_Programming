package stack;

public class StackArray {
	private int[] data;
	private int top;
	
	public StackArray() {
		data= new int[10];
		top=-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() throws StackEmptyException{
		if(size()==0) {
			throw new StackEmptyException(); 
		}
		return data[top];
	}
	
	public void push(int item) {
		if(size()==data.length) {
			doubleCapacicty();
		}
		else {
			top++;
			data[top] = item;
		}
	}
	
	private void doubleCapacicty() {
		int[] temp = data;
		data = new int[2*temp.length];
		for(int i =0; i<=top;i++) {
			data[i]=temp[i];
		}
	}

	public int pop() throws StackEmptyException {
		if(size()==0) {
			throw new StackEmptyException();
		}
		int temp = data[top];
		top--;
		return temp;
	}
}
