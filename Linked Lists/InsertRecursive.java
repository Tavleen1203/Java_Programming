package ll_2;

public class InsertRecursive {
	public static Node<Integer> insert(Node<Integer> head, int pos,int x){
		if(head==null) {
			return head;
		}
		
		if(pos==0) {
			Node<Integer> newNode = new Node<Integer>(x);
			newNode.next=head;
			return newNode;
		}
		
		head.next=insert(head.next, pos-1, x);
		return head;
	}
}
