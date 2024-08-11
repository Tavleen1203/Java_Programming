package queues;

public class QueueLL {
	private Node<Integer> front;
	private Node<Integer> rear;
	private int size;
	
	public QueueLL() {
		front=null;
		rear=null;
		size=0;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size==0;
	}
	
	int front(){
		return front.data; 
	}
	void enqueue(int item) {
		Node<Integer> newNode = new Node<Integer>(item);
		if(rear==null) {
			front=newNode;
			rear=newNode;
		}
		size++;
	}
	
	int dequeue() {
		if(size==0) {
			return -1;
		}
		int temp = front.data;
		front=front.next;
		size--;
		if(front==null) {
			rear=null;
		}
		return temp;
	}
}
