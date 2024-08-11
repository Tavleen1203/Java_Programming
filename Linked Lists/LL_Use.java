package ll_1;

public class LL_Use {
	
	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(10);
		Node<Integer> n2 = new Node<Integer>(20);
		Node<Integer> n3 = new Node<Integer>(30);
		
		n1.next = n2;
		n2.next=n3;
	}
}
