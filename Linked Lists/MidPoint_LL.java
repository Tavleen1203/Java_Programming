package ll_2;

public class MidPoint_LL {
	public static Node<Integer> midpoint(Node<Integer> head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> fast = head;
		Node<Integer> slow = head;

		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
}
