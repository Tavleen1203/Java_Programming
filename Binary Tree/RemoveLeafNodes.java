package bt_2;

public class RemoveLeafNodes {
	public static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			root = null;
		}
		root.left = remove(root.left);
		root.right = remove(root.right);
		
		return root;
	}
}
	
