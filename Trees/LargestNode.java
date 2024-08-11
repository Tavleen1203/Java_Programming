package trees_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LargestNode {
	public static int largest(TreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int ans = root.data;
		
		for(int i=0;i<root.children.size();i++) {
			int largestChild = largest(root.children.get(i));
			if(largestChild>ans) {
				ans = largestChild;
			}
		}
		return ans;
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
	
	public static void printLevelwise(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int levelSize = q.size();
			for(int i=0;i<levelSize;i++) {
				TreeNode<Integer> curr = q.poll();
				System.out.print(curr.data + " ");
				for(int j=0;j<curr.children.size();j++) {
					q.add(curr.children.get(j));
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeInputLevelwise(s);
		printLevelwise(root);
		System.out.println(largest(root));

	}

}

