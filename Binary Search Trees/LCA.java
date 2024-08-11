package bst_ques;

import bst_2.BinaryTreeNode;

public class LCA {
	public static int lca(BinaryTreeNode<Integer> root, int a , int b) {
		if(root==null) {
			return 0;
		}
		if(a<root.data && b <root.data) {
			return lca(root.left, a, b);
		}
		else if(a>root.data && b>root.data) {
			return lca(root.right, a, b);
		}
		else {
			return root.data;
		}
	}
}

