package ll_ques;

public class AppendLastNtoFirst {
	public static Node<Integer> appendToLast(Node<Integer> head, int k){
		if(head==null || k<0) {
			return head;
		}
		int len = 0;
		Node<Integer> temp = head;
		while(temp!=null) {
			temp=temp.next;
			len++;
		}
		
		if(k>len) {
			return head;
		}
		
		temp=head;
		for(int i=0; i<len-k-1;i++) {
			temp=temp.next;
		}
		Node<Integer> newHead = temp.next;
		temp.next=null;
		temp=newHead;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
		return newHead;
	}
}
