package ll_ques;

public class RemoveDups_LL {
	public static Node<Integer> remove(Node<Integer> head){
		if(head==null) {
			return null;
		}
		Node<Integer> curr = head;
		while(curr.next!=null && curr!=null) {
			if(curr.data.equals(curr.next.data)) {
				curr.next = curr.next.next;
			}
			else {
				curr=curr.next;
			}
		}
		return head;
	}
}
