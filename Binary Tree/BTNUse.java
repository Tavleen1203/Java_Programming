package bt_1;

public class BTNUse {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(30);
		
		root.left = node1;
		root.right = node2;

	}

}
