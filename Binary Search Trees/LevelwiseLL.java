package bst_ques;
import java.util.*;

import bst_2.BinaryTreeNode;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LevelwiseLL {
	public static ArrayList<Node<Integer>> constructLL(BinaryTreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		
		int currLevel = 1;
		int next = 0;
		
		Node<Integer> currHead = null;
		Node<Integer> currTail = null;
		ArrayList<Node<Integer>> ans = new ArrayList<Node<Integer>>();
		
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> curr;
			curr = q.remove();
			Node<Integer> newNode = new Node<Integer>(curr.data);
			if(currHead==null) {
				currHead = newNode;
				currTail = newNode;
			}
			else {
				currTail.next = newNode;
				currTail= newNode;
			}
			
			if(curr.left!=null) {
				q.add(curr.left);
				next++;
			}
			if(curr.right!=null) {
				q.add(curr.right);
				next++;
			}
			currLevel--;
			if(currLevel==0) {
				ans.add(currHead);
				currHead=null;
				currTail=null;
				currLevel = next;
				next=0;
			}
		}
		return ans;
	}
}

