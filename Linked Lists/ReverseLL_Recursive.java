package ll_2;

public class ReverseLL_Recursive {
	
	public static Node<Integer> reverseR(Node<Integer> head){
		if(head==null|| head.next==null) {
			return head;
		}
		Node<Integer> finalHead = reverseR(head.next);
		Node<Integer> temp = finalHead;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
		head.next=null;
		return finalHead;	
	}
	
	public static Node<Integer> reverseR2(Node<Integer> head){
		if(head==null|| head.next==null) {
			return head;
		}
		Node<Integer> revTail= head.next;
		Node<Integer> finalHead = reverseR(head.next);
		revTail.next=head;
		head.next=null;
		
		return finalHead;	
	}
}
