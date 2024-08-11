package trees_ques;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxSumNodes {
	public static TreeNode<Integer> ans;
	public static int maxSum;
	
	
	public static TreeNode<Integer> maxFamilySum(TreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		
		int currentSum = root.data;
		for(TreeNode<Integer> child : root.children) {
			currentSum+=child.data;
		}
		
		if(currentSum>maxSum) {
			maxSum=currentSum;
			ans=root;
		}
		
		for(TreeNode<Integer> child : root.children) {
			maxFamilySum(child);
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
		TreeNode<Integer> ans = maxFamilySum(root);
		System.out.println(ans.data);
	}
}

