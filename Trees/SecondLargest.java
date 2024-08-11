package trees_ques;

public class SecondLargest {
	static TreeNode<Integer> largest;
	static TreeNode<Integer> second;
	
	public static TreeNode<Integer> secondLargest(TreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		if(largest==null || root.data > largest.data) {
			second=largest;
			largest=root;
		}else if(root.data<largest.data && (second==null || root.data>second.data)) {
			second = root;
		}
		
		for(TreeNode<Integer> child: root.children) {
			secondLargest(child);
		}
		return second;
		
	}
}
