package ll_ques;

public class Reverse_LL {
	public static Node<Integer> reverse(Node<Integer> head){
		
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> next = null;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
}
