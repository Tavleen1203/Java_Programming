package bst_ques;

import bst_2.BinaryTreeNode;

public class ReplaceNodesWithGreaterSum {
	public static void replaceWithLarger(BinaryTreeNode<Integer> root) {
		int sum=0;
		replace(root,sum);
	}
	
	public static int replace(BinaryTreeNode<Integer> root, int sum ) {
		if(root==null) {
			return sum;
		}
		sum = replace(root.right, sum);
		sum+=root.data;
		root.data = sum;
		sum = replace(root.left, sum);
		return sum;
	}	
}
