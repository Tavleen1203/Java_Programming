package bt_ques;

import java.util.*;
import bt_2.BinaryTreeNode;

public class LevelOrderTraversal {
	public static void levelOrder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int levelSize = q.size();
			
			for(int i =0; i<levelSize; i++) {
				BinaryTreeNode<Integer> curr = q.poll();
				System.out.print(curr.data + " ");
				
				if(curr.left!=null) {
					q.add(curr.left);
				}
				
				if(curr.right!=null) {
					q.add(curr.right);
				}
			}
			System.out.println();
		}
	}
}
