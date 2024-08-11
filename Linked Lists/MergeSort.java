package ll_2;

public class MergeSort {
	public static Node<Integer> mergeSort(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> mid = MidPoint_LL.midpoint(head);
		Node<Integer> secondhalf = mid.next;
		mid.next=null;
		
		Node<Integer> left = mergeSort(head);
		Node<Integer> right = mergeSort(secondhalf);
		
		return MergeSortedLL.merge(left,right);
	}
}
