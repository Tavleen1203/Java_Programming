package ll_ques;

public class LL_Palindrome {
	@SuppressWarnings("null")
	public static boolean isLLPalindrome(Node<Integer> head) {
		if(head==null && head.next==null) {
			return true;
		}
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		Node<Integer> secondHalf = Reverse_LL.reverse(slow.next);
		Node<Integer> firstHalf = head;
		
		while(secondHalf!=null) {
			if(!firstHalf.data.equals(secondHalf.data)) {
				return false;
			}
			firstHalf=firstHalf.next;
			secondHalf=secondHalf.next;
        }
		return true;
	}
}
