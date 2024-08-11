package bt_ques;

import bt_2.BinaryTreeNode;

public class DuplicateLeft {
	public static BinaryTreeNode<Integer> createLeftDuplicateTree(BinaryTreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		
		BinaryTreeNode<Integer> leftDup = new BinaryTreeNode<Integer>(root.data);
		
		leftDup.left = root.left;
		root.left = leftDup;
		
		createLeftDuplicateTree(root.right);
		createLeftDuplicateTree(leftDup.left);
		
		return root;
	}
}
