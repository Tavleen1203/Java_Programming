package ll_2;

public class DeleteRecursive {
	public static Node<Integer> deleteR(Node<Integer> head, int pos){
		if(head==null) {
			return head;
		}
		if(pos==0) {
			return head.next;
		}
		head.next = deleteR(head.next,pos-1);
		return head;
	}
}
