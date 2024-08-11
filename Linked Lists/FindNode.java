package ll_ques;

public class FindNode {
	public static int find(Node<Integer> head, int target ) {

		int index =0;
		Node<Integer> curr = head;
		
		while(curr!=null) {
			if(curr.data==target) {
				return index;
			}
		    curr = curr.next;
		    index++;
		}
		return -1;
	}
}
