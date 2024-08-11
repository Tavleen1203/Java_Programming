package bt_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DepthAtK {
	public static void depth(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return;
		}
		
		if(k==0) {
			System.out.print(root.data + " ");
			return;
		}
		
		depth(root.left, k-1);
		depth(root.right, k-1);
	}

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
	
	
	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> currentNode = queue.poll();
	        int data = currentNode.data;
	        int leftChildData = (currentNode.left != null) ? currentNode.left.data : -1;
	        int rightChildData = (currentNode.right != null) ? currentNode.right.data : -1;
	
	        // Print the node's information in the specified format.
	        System.out.print(data + ":L:" + leftChildData + ",R:" + rightChildData);
	
	        // Add the left and right children to the queue if they exist.
	        if (currentNode.left != null) {
	            queue.add(currentNode.left);
	        }
	        if (currentNode.right != null) {
	            queue.add(currentNode.right);
	        }
	
	        // Print a newline after each node.
	        System.out.println();
		}
	  }
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = inputIterative();
		print(root);
		depth(root, 1);
	}
}
	
