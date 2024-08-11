package ll_ques;

public class DeleteEveryNNode {
	public static Node<Integer> deleteEveryNafterM(Node<Integer> head, int m, int n){
		if(m==0 || head==null) {
			return null;
		}
		if(n==0) {
			return head;
		}
		
		Node<Integer> temp1 = head;
		Node<Integer> temp2= null;
		
		while(temp1!=null) {
			int keep=0;
			int leave=0;
			
			while(temp1!=null && keep<m) {
				if(temp2==null) {
					temp2=temp1;
				}else {
					temp2.next=temp1;
					temp2=temp1;
				}
				temp1=temp1.next;
				keep++;
			}
			while(temp1!=null && leave<n) {
				temp1=temp1.next;
				leave++;
			}
		}
		
		if(temp2!=null) {
			temp2.next=null;
		}
		return head;
	}
}
