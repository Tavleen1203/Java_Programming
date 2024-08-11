package ll_1;

public class Delete_LL {
	 public static Node<Integer> delete(Node<Integer> head, int pos) {
	        // If the list is empty or pos is negative, return the original head
	        if (head == null || pos < 0) {
	            return head;
	        }

	        // If the position is 0 and there is a next node, delete the head node
	        if (pos == 0) {
	            head = head.next;
	            return head;
	        }

	        Node<Integer> curr = head;
	        int i = 0;

	        // Traverse the list to find the node just before the one to be deleted
	        while (curr != null && i < pos - 1) {
	            curr = curr.next;
	            i++;
	        }

	        // If curr is null or curr.next is null, the position is out of bounds
	        if (curr == null || curr.next == null) {
	            return head;
	        }

	        // Skip the node at the given position
	        curr.next = curr.next.next;
	        
	        // Return the modified head of the linked list
	        return head;
	    }
}
