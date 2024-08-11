package dp_2;

public class Knapsack01_Recursive {
	
	public static int knapsackR(int[] weights, int[] values, int maxWeight) {
		return knapsackHelper(weights, values, maxWeight, 0);
	}
	

	private static int knapsackHelper(int[] weights, int[] values, int maxWeight, int i) {
		
		if(i==weights.length || maxWeight==0) {
			return 0;
		}
		if(weights[i]>maxWeight) {
			return knapsackHelper(weights, values, maxWeight, i+1);
		}
		else {
			int includefirst = values[i] + knapsackHelper(weights, values, maxWeight-weights[i], i+1);
			int notInclude = knapsackHelper(weights, values, maxWeight, i+1);
			
			return Math.max(includefirst, notInclude);
		}
	}

	public static void main(String[] args) {
		int[] w = {6,1,2,4,5};
		int[] v = {10,5,4,8,6};
		
		System.out.println(knapsackR(w, v,5));
	}

}
