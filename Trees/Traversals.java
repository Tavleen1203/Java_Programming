package trees_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Traversals {
	
	public static void preOrder(TreeNode<Integer> root) {
		
		System.out.print(root.data + " ");
		for(int i =0;i<root.children.size();i++) {
			preOrder(root.children.get(i));
		}
	}
	
	
	public static void postOrder(TreeNode<Integer> root) {
		for(TreeNode<Integer> child : root.children) {
			postOrder(child);
		}
		System.out.print(root.data + " ");
		System.out.println();
	}
	
	public static TreeNode<Integer> takeInputLevelwise(Scanner s){
		//Scanner s = new Scanner(System.in);
		//System.out.println("Enter the root: ");
		int rootData = s.nextInt();
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> front = q.poll();
			//System.out.println("Enter number of children of "+front.data);
			int numChildren  = s.nextInt();
			for(int i =0; i<numChildren;i++) {
				//System.out.println("Enter " + (i+1)+ "th child of " +front.data);
				int child = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
				front.children.add(childNode);
				q.add(childNode);
				//s.close();
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeInputLevelwise(s);
		preOrder(root);
		postOrder(root);

	}

}
