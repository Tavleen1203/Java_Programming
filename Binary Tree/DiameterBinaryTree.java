package bt_2;

public class DiameterBinaryTree {
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int op1 = height(root.left) + height(root.right);
		int op2 = diameter(root.left);
		int op3 = diameter(root.right);
		
		return Math.max(op1,Math.max(op2, op3)); 
	}

	private static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left),height(root.right));
	}
}
