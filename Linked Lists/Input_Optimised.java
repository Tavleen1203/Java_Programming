package ll_1;

import java.util.Scanner;

public class Input_Optimised {
	public static Node<Integer> takeInput(){
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while(data!=-1) {
			Node<Integer> newNode =  new Node<Integer>(data);
			if(head==null) {
				head=newNode;
				tail=newNode;
			}else {
				tail.next = newNode;
				tail=tail.next;
			}
			data=s.nextInt();
		}
		s.close();
		return head;
	}
}
