package bt_2;

class Pair {
	int diameter;
	int height;
	
	public Pair(int diameter, int height) {
		this.diameter = diameter;
		this.height = height;
	}
}

public class DiameterImproved {
	
	public static Pair diameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			Pair p = new Pair(0,0);
			return p;
		}
		
		Pair leftP = diameter(root.left);
		Pair rightP = diameter(root.right);
		
		int leftD = leftP.diameter;
		int rightD = rightP.diameter;
		
		int distance = leftP.height + rightP.height +1;
		
		int diameter = Math.max(distance, Math.max(leftD, rightD));
		int height = Math.max(leftP.height, rightP.height) + 1;
		
		return(new Pair(diameter,height));
	}	

}
