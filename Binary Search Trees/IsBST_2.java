package bst_1;

class Triplet{
	Boolean isBST;
	int max;
	int min;
	
	public Triplet() {
		isBST = false;
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
	}
}
public class IsBST_2 {
	public static Triplet isBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			Triplet ans = new Triplet();
			ans.isBST=true;
			return ans;
		}
		Triplet leftAns = isBST(root.left);
		Triplet rightAns = isBST(root.right);
		
		int minAll = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int maxAll = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		
		boolean bst = (root.data>leftAns.max) && (root.data<=rightAns.min) && leftAns.isBST && rightAns.isBST;
		
		Triplet ans = new Triplet();
		ans.isBST=bst;
		ans.max = maxAll;
		ans.min = minAll;
		return ans;
			
	}
}
