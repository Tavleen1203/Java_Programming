package bt_ques;

import bt_2.BinaryTreeNode;

public class PrintAtKfromTarget {
	public static int nodesAtK(BinaryTreeNode<Integer> root, int target, int k) {
		if(root==null) {
			return -1;
		}
		
		if(root.data == target) {
			printAtK(root,k);
			return 0;
		}
		
		int ld = nodesAtK(root.left, target, k);
		if(ld!=-1) {
			if(ld+1==k) {
				System.out.print(root.data);
			}else {
				printAtK(root.right, k-ld+2);
			}
			return 1+ld;
		}
		
		int rd = nodesAtK(root.right, target, k);
		if(rd!=-1) {
			if(rd+1==k) {
				System.out.print(root.data);
			}else {
				printAtK(root.left, k-rd+2);
			}
			return 1+rd;
		}
		
		return -1;
	}

	private static void printAtK(BinaryTreeNode<Integer> root, int k) {
		 if(root==null) {
			 return;
		 }
		 
		 if(k==0) {
			 System.out.println(root.data);
			 return;
		 }
		 printAtK(root.left, k-1);
		 printAtK(root.right, k-1);
	}
}
