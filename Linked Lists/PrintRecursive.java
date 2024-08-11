package ll_2;

public class PrintRecursive {
	public static void printR(Node<Integer> head) {
		if(head==null) {
			return;
		}
		System.out.print(head.data+" ");
		printR(head.next);
	}
}
