package queues;

public class ArrayQueue {
	private int[] data;
	private int size;
	private int front;
	private int rear;
	
	public ArrayQueue() {
		data = new int[10];
		size = 0;
		front = -1;
		rear =-1;
	}
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size==0;
	}
	
	int front() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	void enqueue(int item) {
		if(size==0) {
			front=0;
		}
		rear++;
		if(rear==data.length) {
			rear=0;
		}
		size++;
		data[rear]=item;
	}
	
	int dequeue() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		int temp = data[front];
		front=(front+1)%data.length;
		size--;
		if(size==0) {
			front=-1;
			rear=-1;
		}
		
		return temp;
	}
	
}
