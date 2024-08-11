package bt_2;

public class BuildTree_2 {
	public static BinaryTreeNode<Integer> buildPostIn(int[] in, int[] post){
		if(post.length==0 || in.length==0) {
			return null;
		}
		return buildHelper(in, post, 0, in.length-1, 0, post.length-1);
	}

	private static BinaryTreeNode<Integer> buildHelper(int[] post, int[] in, int inS, int inE, int postS, int postE) {
		if(inS>inE || postS>postE) {
			return null;
		}
		
		int rootData = post[postE];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		int rootIndex =-1;
		for(int i =inS; i <= inE; i++) {
			if(in[i]==rootData) {
				rootIndex =i;
				break;
			}
		}
		
		int LinS = inS;
		int LinE = rootIndex -1;
		int LpostS = postS;
		int LpostE = postE - inE + rootIndex;
		int RinS = rootIndex +1;
		int RinE = inE;
		int RpostS = postE - inE + rootIndex+1;
		int RpostE = postE -1;
		
		
		root.left = buildHelper(in, post, LinS, LinE, LpostS, LpostE);
		root.right = buildHelper(in, post, RinS, RinE, RpostS, RpostE);
		return root;
	}
}
