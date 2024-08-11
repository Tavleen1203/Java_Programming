package ll_ques;

public class BubbleSort {
	public static Node<Integer> bubble(Node<Integer> head){
		int n = len(head);
		for(int i=0; i<n-1;i++) {
			Node<Integer> prev=null, curr=head;
			for(int j=0; j<n-i-1;j++) {
				if(curr.data<=curr.next.data) {
					prev=curr;
					curr=curr.next;
				}else {
					if(prev==null) {
						Node<Integer> next = curr.next;
						head=head.next;
						curr.next=next.next;;
						next.next=curr;
						prev=curr;
					}else {
						Node<Integer> next = curr.next;
						prev.next=next;
						curr.next=next.next;;
						next.next=curr;
						prev=next;
					}
				}
			}	
		}
		return head;
	}

	private static int len(Node<Integer> head) {
		int count=0;
		while(head!=null) {
			head=head.next;
			count++;
		}
		return count;
	}
}
