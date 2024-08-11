package ll_1;

public class InsertNode {
	public static Node<Integer> insert(Node<Integer> head, int pos, int data){
		Node<Integer> newNode = new Node<Integer>(data);
		if(pos==0) {
			newNode.next=head;
			head=newNode;
			return head;
		}
		int i = 0 ;
		Node<Integer> temp = head;
		while(i<pos-1) {
			temp=temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next=newNode;
		
		return head;
	}
}
