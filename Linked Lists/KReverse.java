package ll_ques;

public class KReverse {
	public static Node<Integer> kReverse(Node<Integer> head, int k){
		if(k==0 || k==1) {
			return head;
		}
		
		Node<Integer> curr = head;
		Node<Integer> prev = null, next = null;
		
		int count=0;
		
		while(count<k && curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		
		if(next!=null) {
			head.next = kReverse(next, k);
		}
		return prev;
	}
}
