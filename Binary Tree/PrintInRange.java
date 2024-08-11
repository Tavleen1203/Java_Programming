package bt_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintInRange {
	public static void print(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root==null) {
			return;
		}
		if(k2<root.data) {
			print(root.left,k1,k2);
		}
		if(k1<root.data && k2>=root.data) {
			System.out.println(root.data+" ");
		}
		if(k1>root.data) {
			print(root.right,k1,k2);
		}
	}
	
	public class Input_Levelwise {
		public static BinaryTreeNode<Integer> inputIterative(){
			Scanner s = new Scanner(System.in);
			s.close();
			Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
			int rootData= s.nextInt();
			if(rootData==-1) {
				return null;
				
			}
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
			q.add(root);
			
			
			while(!q.isEmpty()) {
				BinaryTreeNode<Integer> front = q.poll();
				System.out.println("Enter left child of "+ front.data);
				int leftChild = s.nextInt();
				if(leftChild!=-1) {
					BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
					q.add(child);
					front.left = child;
					
				}
				
				System.out.println("Enter right child of "+ front.data);
				int rightChild = s.nextInt();
				if(rightChild!=-1) {
					BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
					q.add(child);
					front.right = child;
				}
			}
			
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
			BinaryTreeNode<Integer> root = inputIterative();
			printTree(root);
			print(root,20,50);
		}
	}
}
