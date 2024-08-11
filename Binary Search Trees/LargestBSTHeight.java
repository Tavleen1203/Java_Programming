package bst_ques;

import bst_2.BinaryTreeNode;

class Ans{
	int max;
	int min;
	int height;
	boolean isBST;
}
public class LargestBSTHeight {
	
	public static int largestHeightBST(BinaryTreeNode<Integer> root) {
		return largestBSTHelper(root).height;
	}
	private static Ans largestBSTHelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			Ans a = new Ans();
			a.max = Integer.MIN_VALUE;
			a.min = Integer.MAX_VALUE;
			a.height = 0;
			a.isBST = true;
			return a;
		}
		Ans left = largestBSTHelper(root.left);
		Ans right = largestBSTHelper(root.right);	
		if(!(right.isBST && right.min>root.data)){
			right.isBST = false;
		}
		if(!(left.isBST && left.max<root.data)){
			left.isBST = false;
		}
		Ans a = new Ans();
		if(!left.isBST ||  !right.isBST || root.data<left.max || root.data>right.min) {
			if(left.height>right.height) {
				left.isBST = false;
				return left;
			}else {
				right.isBST = false;
				return right;
			}
		}
		a.isBST = true;
		a.min = Math.min(left.min,Math.min(right.min,root.data));
		a.max = Math.max(left.max,Math.max(right.max,root.data));
        a.height  = Math.max(left.height, right.height)+1;
        return a;
	}
}
