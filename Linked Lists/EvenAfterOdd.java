package ll_ques;

public class EvenAfterOdd {
	public static Node<Integer> evenAfterOdd(Node<Integer> head){
		
		Node<Integer> oddH=null, oddT=null, evenH=null, evenT=null;
		
		while(head!=null) {
			if(head.data%2==0) {
				if(evenH==null) {
					evenH=head;
					evenT=head;
				}else {
					evenT.next=head;
					evenT=evenT.next;
				}
			}else {
				if(oddH==null) {
					oddH=head;
					oddT=head;
				}else {
					oddT.next=head;
					oddT=oddT.next;
				}
			}
			head=head.next;
		}
		
		if(oddH==null) {
			return evenH;
		}else {
			oddT.next=evenH;
		}
		
		if(evenH!=null) {
			evenT.next=null;
		}
		return oddH;
	}
}
