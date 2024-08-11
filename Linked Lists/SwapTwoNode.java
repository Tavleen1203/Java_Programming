package ll_ques;

public class SwapTwoNode {
	public static Node<Integer> swap(Node<Integer> head, int i, int j){
		if(i==j) {
			return head;
		}
		Node<Integer> c1=null, p1=null, c2=null, p2=null;
		Node<Integer> curr = head, prev = null;
		int pos=0;
		while(curr!=null) {
			if(pos==i) {
				p1=prev;
				c1=curr;
			}else if(pos==j) {
				p2=prev;
				c2=curr;
			}
			prev=curr;
			curr=curr.next;
			pos++;
		}
		
		if(p1!=null) {
			p1.next=c2;
		}else {
			head=c2;
		}
		if(p2!=null) {
			p2.next=c1;
		}else {
			head=c1;
		}
		
		Node<Integer> currFirst = c2.next;
		c2.next=c1.next;
		c1.next=currFirst;
		
		return head;
	}
}
