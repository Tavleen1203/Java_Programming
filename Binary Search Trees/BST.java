package bst_2;

class BSTDeletePair{
	BinaryTreeNode<Integer> root;
	boolean isDeleted;
	
	public BSTDeletePair(BinaryTreeNode<Integer> root, boolean isDeleted) {
		this.root = root;
		this.isDeleted = isDeleted;
	}
}

public class BST {
	
	private BinaryTreeNode<Integer> root;
	private int size;
	
	public boolean isPresent(int x) {
		return search(root,x);
	}
	
	private static boolean search(BinaryTreeNode<Integer> root, int s) {
		if(root==null) {
			return false;
		}
		if(root.data==s) {
			return true;
		}
		
		else if(s<root.data) {
			return search(root.left, s);
		
		}else {
			return search(root.right, s);
		}
	}
	
	public void insert(int x) {
		root = insert(root,x);
		size++;
	}
	
	private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x){
		if(node==null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
			return newRoot;
		}
		if(x>=node.data) {
			node.right = insert(node.right,x);
		}else {
			node.left = insert(node.left,x);
		}
		return node;
	}
	
	public boolean deleteData(int x) {
		BSTDeletePair ans = deleteHelper(root, x);
		if(ans.isDeleted) {
			size--;
		}
		return ans.isDeleted;
	}
	
	private static BSTDeletePair deleteHelper(BinaryTreeNode<Integer> root, int x) {
		if(root==null) {
			return new BSTDeletePair(null, false);
		}
		
		if(root.data<x) {
			BSTDeletePair rightAns = deleteHelper(root.right, x);
			rightAns.root = root;
			return  rightAns;
		}
		
		if(root.data>x) {
			BSTDeletePair leftAns = deleteHelper(root.left, x);
			leftAns.root = root;
			return  leftAns;
		}
		//0 CHILDREN
		if(root.left==null && root.right==null) {
			return new BSTDeletePair(null, true);
		}
		
		if(root.left!=null && root.right==null) {
			return new BSTDeletePair(root.left, true);
		}
		if(root.right!=null && root.right==null) {
			return new BSTDeletePair(root.right, true);
		}
		int rightMax=largest(root.right);
		root.data = rightMax;
		BSTDeletePair ans = deleteHelper(root.right, rightMax);
		root.right = ans.root;
		return new BSTDeletePair(root, true);		
	}
	
	private static int largest(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return -1;
		}
		int largestL = largest(root.left);
		int largestR = largest(root.right);
		
		return Math.max(root.data,Math.max(largestL, largestR));
	}

	public void printTree() {
		printHelp(root);
	}

	private void printHelp(BinaryTreeNode<Integer> root2) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data+" ");
		if(root.left!=null) {
			System.out.print("L:" + root.left.data + " ");
		}
		if(root.right!=null) {
			System.out.print("R:" + root.right.data + " ");
		}
		System.out.println();
		
		printHelp(root.left);
		printHelp(root.right);
	}
	
	public int size() {
		return size;
	}
}


