package ll_ques;

public class FindNodeRecursive {
	public static int findNode(Node<Integer> head, int target) {
		if(head==null) {
			return -1;
		}
		if(head.data.equals(target)) {
			return 0;
		}
		int smallAns = findNode(head.next, target);
		
		if(smallAns==-1) {
			return -1;
		}
		return smallAns+1;
	}
}
