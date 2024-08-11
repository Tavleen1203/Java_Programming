package bt_2;

public class Mirror_BT {
	public static BinaryTreeNode<Integer> makeMirrorTree(BinaryTreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right=temp;
		
		makeMirrorTree(root.left);
		makeMirrorTree(root.right);
		
		return root;
	}
}
