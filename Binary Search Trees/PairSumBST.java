package bst_ques;
import java.util.Stack;

import bst_2.BinaryTreeNode;

public class PairSumBST {
	public static int numberOfNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		return numberOfNodes(root.left) + numberOfNodes(root.right) + 1;
	}
	
	public static void printPairs(BinaryTreeNode<Integer> root, int target) {
		if(root==null) {
			return;
		}
		int n = numberOfNodes(root);
		int count=0;
		Stack<BinaryTreeNode<Integer>> inorder = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> revInorder = new Stack<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> temp = root;
        while(temp!=null) {
        	inorder.push(temp);
        	temp=temp.left;
        }
        temp=root;
        while(temp!=null) {
        	revInorder.push(temp);
        	temp=temp.right;
        }
        
        while(count<n-1) {
        	BinaryTreeNode<Integer> top1 = inorder.peek();
        	BinaryTreeNode<Integer> top2 = revInorder.peek();
        	if(top1.data + top2.data ==target) {
        		System.out.println(top1.data +" "+ top2.data);
        		
        		BinaryTreeNode<Integer> top = top1;
        		inorder.pop();
        		count++;
        		
        		if(top.right!=null) {
        			top=top.right;
        			while(top!=null) {
        				inorder.push(top);
        				top=top.left;
        			}
        		}
        		top=top2;
        		revInorder.pop();
        		count++;
        		if(top.left!=null) {
        			top=top.left;
        			while(top!=null) {
        				revInorder.push(top);
        				top=top.right;
        			}
        		}
        	}
        	else if( top1.data + top2.data> target) {
        		BinaryTreeNode<Integer> top = top2;
        		revInorder.pop();
        		count++;
        		if(top.left!=null) {
        			top=top.left;
        			while(top!=null) {
        				revInorder.push(top);
        				top=top.right;
        			}
        		}
        	}
        	else {
        		BinaryTreeNode<Integer> top = top1;
        		inorder.pop();
        		count++;
        		
        		if(top.right!=null) {
        			top=top.right;
        			while(top!=null) {
        				inorder.push(top);
        				top=top.left;
        			}
        		}
        	}       	  	
        }   
	}
}




