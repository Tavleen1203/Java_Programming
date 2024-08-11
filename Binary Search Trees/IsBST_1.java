package bst_1;

public class IsBST_1 {
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return true; //TRIVIALLY TRUE CASE
		}
		
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		
		if(root.data<=leftMax) {
			return false;
		}
		
		if(root.data>rightMin) {
			return false;
		}
		
		return isBST(root.left) && isBST(root.right);
	}

	private static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	
	}

	private static int maximum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	
	}
}
