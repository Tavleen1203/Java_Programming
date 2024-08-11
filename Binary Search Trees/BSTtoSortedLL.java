package bst_1;

class Node<T>{
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
}
class NodePair{
	Node<Integer> head;
	Node<Integer> tail;
}

public class BSTtoSortedLL {
	public static Node<Integer> bstToLL(BinaryTreeNode<Integer> root){
		return helper(root).head;
	}

	private static NodePair helper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			NodePair ans = new NodePair();
			return ans;
		}
		
		Node<Integer> rootNode = new Node<>(root.data);
		NodePair leftAns = helper(root.left);
		NodePair rightAns = helper(root.right);
		
		NodePair ans = new NodePair();
		
		if(leftAns.tail != null) {
			leftAns.tail.next = rootNode;
		}
		rootNode.next = rightAns.head;
		
		if(leftAns.head !=null) {
			ans.head = leftAns.head;
		}else {
			ans.head = rootNode;
		}
		
		if(rightAns.tail!=null) {
			ans.tail=rightAns.tail;
		}else {
			ans.tail=rootNode;
		}
		return ans;
	}
}



