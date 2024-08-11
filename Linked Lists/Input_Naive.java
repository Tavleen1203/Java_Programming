package ll_1;

import java.util.Scanner;

public class Input_Naive {
	public static Node<Integer> takeInput(){
		Node<Integer> head = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while(data!=-1) {
			Node<Integer> newNode =  new Node<Integer>(data);
			if(head==null) {
				head=newNode;
			}else {
				Node<Integer> temp = head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next = newNode;
			}
			data=s.nextInt();
			
		}
		s.close();
		return head;
	}
}
