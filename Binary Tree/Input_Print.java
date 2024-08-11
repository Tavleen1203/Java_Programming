package bt_1;

import java.util.Scanner;

public class Input_Print {
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		int rootData;
		//System.out.print("Enter data");
		rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		String ans = root.data + " ";
		
		if(root.left!=null) {
			ans+= "L"+root.left.data+" ";
		}
		if(root.right!=null) {
			ans+= "R"+root.right.data+" ";
		}
		System.out.println(ans);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		printTree(root);
	}
}
