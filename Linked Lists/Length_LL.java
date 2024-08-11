package ll_1;

public class Length_LL {
	public static int lengthLL(Node<Integer> head) {
		if(head==null) {
			return 0;
		}
		int count=1;
		Node<Integer> temp = head;
		while(temp.next!=null) {
			temp=temp.next;
			count++;
		}
		return count;
	}
}
