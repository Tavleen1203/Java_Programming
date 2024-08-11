package bt_ques;

import bt_2.BinaryTreeNode;

class Pair<T,U>{
	T min;
	U max;
	
	public Pair(T min, U max) {
		this.min = min;
		this.max = max;
	}
}
public class MinMax {
	public static Pair<Integer,Integer> minAndMax(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		
		int max = root.data;
		int min = root.data;
		
		Pair<Integer, Integer> leftMinMax = minAndMax(root.left);
		Pair<Integer, Integer> rightMinMax = minAndMax(root.right);
		
		if(leftMinMax != null) {
			min = Math.min(min,leftMinMax.min);
			max = Math.min(max,leftMinMax.max);
		}
		
		if(rightMinMax != null) {
			min = Math.min(min,rightMinMax.min);
			max = Math.min(max,rightMinMax.max);
		}
		
		return new Pair<>(min,max);
	}


}
