package trees_ques;

public class CountLeafs {
	public static int countLeafs(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count =0;
		
		if(root.children.isEmpty()) {
			return 1;
		}
		
		for(TreeNode<Integer> child : root.children) {
			count+=countLeafs(child);
		}
		
		return count;
	}

}
