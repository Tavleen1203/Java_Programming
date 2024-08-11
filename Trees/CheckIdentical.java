package trees_ques;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckIdentical {
	
	public static boolean check(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		
		if(!root1.data.equals(root2.data)) {
			return false;
		}
		
		if(root1.children.size() != root2.children.size()) {
			return false;
		}
		
		for(int i=0;i<root1.children.size(); i++) {
			if(!check(root1.children.get(i),root2.children.get(i))) {
				return false;
			}
		}
		return true;
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
		
		TreeNode<Integer> root1 = takeInputLevelwise(s);
		TreeNode<Integer> root2 = takeInputLevelwise(s);
		printLevelwise(root1);
		printLevelwise(root2);
		System.out.println(check(root1, root2));

	}
}


