package stack;

public class StackLL<T> {
	private Node<T> head;
	private int size;
	
	public StackLL() {
		head=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public T top() throws StackEmptyException {
		if(size==0) {
			throw new StackEmptyException();
		}else {
			return head.data;
		}
	}
	
	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = head;
		head=newNode;
		size++;
	}
	
	public T pop() throws StackEmptyException {
		if(size==0) {
			throw new StackEmptyException();
		}else {
			Node<T> temp = head;
			head=head.next;
			size--;
			return temp.data;
		}
	}
}
