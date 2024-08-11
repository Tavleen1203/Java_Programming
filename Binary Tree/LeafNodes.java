package bt_1;

public class LeafNodes {
	public static int countLeaf(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		return countLeaf(root.left) + countLeaf(root.right);
	}
	
}
