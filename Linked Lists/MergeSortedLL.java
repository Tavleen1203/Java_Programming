package ll_2;

public class MergeSortedLL {
	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		
		if (head1 == null) return head2;
        if (head2 == null) return head1;
        
		Node<Integer> t1=head1, t2=head2;
		Node<Integer> head=null, tail=null;
		
		if(t1.data<=t2.data) {
			head=t1;
			tail=t1;
		}else {
			head=t2;
			tail=t2;
		}
		while(t1!=null && t2!=null) {
			if(t1.data<=t2.data) {
				tail.next=t1;
				tail=t1;
				t1=t1.next;
			}else {
				tail.next=t2;
				tail=t2;
				t2=t2.next;
			}
		}
		
		if(t1 != null) {
            tail.next = t1;
        }else{
            tail.next = t2;
        }
		return head;
	}
}
