package ll_1;

public class Increment_LL {
	public static Node<Integer> increment(Node<Integer> head){
		Node<Integer> curr = head;
		while(curr!=null) {
			curr.data++;
			curr=curr.next;
		}
		return head;
	}
}
