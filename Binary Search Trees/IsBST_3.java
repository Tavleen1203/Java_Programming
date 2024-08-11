package bst_1;

public class IsBST_3 {
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private static boolean isBSTHelper(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
		if(root==null) {
			return true;
		}
		if(root.data<minValue || root.data>=maxValue) {
			return false;
		}
		boolean isLeft = isBSTHelper(root.left, minValue, root.data-1);
		boolean isRight = isBSTHelper(root.right, root.data, maxValue);
		
		return isLeft && isRight;
		
	}
}
