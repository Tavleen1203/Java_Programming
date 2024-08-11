package bst_1;

public class SortedArrayToBST {
	public static BinaryTreeNode<Integer> makeBST(int[] arr, int n){
		if(arr==null || n==0) {
			return null;
		}
		
		return bstHelper(arr,0,n-1);
	}

	private static BinaryTreeNode<Integer> bstHelper(int[] arr, int start, int end) {
		if(start>end) {
			return null;
		}
		
		int mid = (start+end)/2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(mid);
		
		root.left = bstHelper(arr, start, mid-1);
		root.right = bstHelper(arr, mid+1, end);
		
		return root;
	}

}
