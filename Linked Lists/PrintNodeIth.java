package ll_1;

public class PrintNodeIth {
	public static void printIth(Node<Integer> head, int i) {
		int index = 0;
		Node<Integer> curr = head;
		while(curr!=null && index<i) {
			curr=curr.next;
			index++;
		}
		if(curr!=null) {
			System.out.println(curr.data);
		}
	}
}
