package bst_1;

public class PrintInRange {
	public static void printElements(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root==null) {
			return;
		}
		
		if(root.data>=k1 && root.data<=k2 ) {
			printElements(root.left, k1, k2);
			System.out.print(root.data+" ");
			printElements(root.right, k1, k2);
		}
		else if(root.data>k2) {
			printElements(root.left, k1, k2);
		}
		else if(root.data<k1) {
			printElements(root.right, k1, k2);
		}		
	}
}
