package bt_ques;

import java.util.LinkedList;

import bt_2.BinaryTreeNode;

public class PathToSumK {
	public static void printPaths(BinaryTreeNode<Integer> root, int k) {
		helper(root,k,new LinkedList<Integer>());
	}

	private static void helper(BinaryTreeNode<Integer> root, int k, LinkedList<Integer> path) {
		if(root==null) {
			return;
		}
		
		path.add(root.data);
		
		if(root.left==null && root.right==null && k-root.data==0) {
			for(int val:path) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
		helper(root.left, k- root.data, path);
		helper(root.right, k- root.data, path);
		
		path.removeLast();
		
	}
}
