package bt_2;

public class BuildTree_1 {
	public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]){
		return buildHelper(in,pre,0,in.length-1,0,pre.length-1);
	}

	private static BinaryTreeNode<Integer> buildHelper(int[] in, int[] pre, int inStart, int inEnd, int preStart, int preEnd) {
		if(inEnd<inStart) {
			return null;
		}
		
		int rootData = pre[preStart];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootIndex = -1;
		for(int i = inStart; i<=inEnd; i++) {
			if(in[i]==root.data) {
				rootIndex = i;
				break;
			}
		}
		
		int leftInS = inStart;
		int leftInE = rootIndex-1;
		int leftPreS = preStart +1;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightInS = rootIndex+1;
		int rightInE = inEnd;
		int rightPreS = leftPreE +1;
		int rightPreE = preEnd;
		
		root.left = buildHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = buildHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		
		return root;
		
	}
}
