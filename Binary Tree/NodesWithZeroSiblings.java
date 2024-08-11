package bt_1;

public class NodesWithZeroSiblings {
	public static void printWithNoSiblings(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		
		if(root.left==null && root.right!=null) {
			System.out.print(root.right.data +" ");
		}
		if(root.left!=null && root.right==null) {
			System.out.print(root.left.data +" ");
		}
		
		printWithNoSiblings(root.left);
		printWithNoSiblings(root.right);
	}
}
