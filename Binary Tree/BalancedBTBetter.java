package bt_2;

public class BalancedBTBetter {
	
	int height;
	boolean isBalanced;
	
	
	public static BalancedBTBetter isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			int ht = 0;
			boolean isBal = true;
			
			BalancedBTBetter ans = new BalancedBTBetter();
			ans.height=ht;
			ans.isBalanced=isBal;
			return ans;
		}
		
		BalancedBTBetter left = isBalancedBetter(root.left);
		BalancedBTBetter right = isBalancedBetter(root.right);
		boolean isBal = true;
		int ht = 1 + Math.max(left.height, right.height);
		
		if(Math.abs(left.height-right.height)>1) {
			isBal = false;
		}
		if(!left.isBalanced || !right.isBalanced) {
			isBal = false;
		}
		
		BalancedBTBetter ans = new BalancedBTBetter();
		ans.height = ht;
		ans.isBalanced = isBal;
		return ans;
		
	}

}
