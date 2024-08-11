package bt_1;

public class ReplaceWithDepth {
	public static BinaryTreeNode<Integer> replace(BinaryTreeNode<Integer> root){
		return replaceHelper(root,0);
	}

	private static BinaryTreeNode<Integer> replaceHelper(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return null;
		}
		root.data = k;
		
		replaceHelper(root.left, k+1);
		replaceHelper(root.right, k+1);
		
		return root;
	}
}
