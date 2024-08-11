package bst_2;

import java.util.ArrayList;

public class RootToNodePath {
	public static ArrayList<Integer> printPathToNode(BinaryTreeNode<Integer> root, int x){
		if(root==null) {
			return null;
		}
		
		if(root.data==x) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(root.data);
			return ans;
		}
		
		ArrayList<Integer> leftAns = printPathToNode(root.left, x);
		if(leftAns!=null) {
			leftAns.add(root.data);
			return leftAns;
		}
		
		ArrayList<Integer> rightAns = printPathToNode(root.right, x);
		if(rightAns!=null) {
			rightAns.add(root.data);
			return rightAns;
		}
		
		return null;
		
	}
}

