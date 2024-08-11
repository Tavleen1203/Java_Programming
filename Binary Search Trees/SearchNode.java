package bst_1;

public class SearchNode {
	public static boolean searchNode(BinaryTreeNode<Integer> root, int s) {
		if(root==null) {
			return false;
		}
		if(root.data==s) {
			return true;
		}
		
		else if(s<root.data) {
			return searchNode(root.left, s);
		
		}else {
			return searchNode(root.right, s);
		}
	}
}

