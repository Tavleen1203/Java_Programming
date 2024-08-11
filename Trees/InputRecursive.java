package trees_1;

import java.util.Scanner;

public class InputRecursive {
	
	public static TreeNode<Integer> takeInput() {
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter node data");
		n = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter the number of children of "+n);
		int childNum = s.nextInt();
		for(int i =0; i<childNum;i++) {
			TreeNode<Integer> child = takeInput();
			root.children.add(child);
		}
		s.close();
		return root;
	}
	
	public static void printTree(TreeNode<Integer> root) {
		String s = root.data + ": ";
		for(int i=0;i<root.children.size();i++) {
			s= s+ root.children.get(i).data + " ";
		}
		
		System.out.println(s);
		
		for(int i=0;i<root.children.size();i++) {
			printTree(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> res = takeInput();
		printTree(res);
		
	}
}
