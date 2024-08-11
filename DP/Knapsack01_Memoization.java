package dp_2;

import java.util.Arrays;

public class Knapsack01_Memoization {
	public static int knapsackM(int[] weights, int[] values, int maxWeight) {
		
		int[][] dp = new int[weights.length][maxWeight+1];
		
		for(int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		
		return knapHelper(weights, values, maxWeight, 0, dp);
		
	}

	private static int knapHelper(int[] weights, int[] values, int maxWeight, int i, int[][] dp) {
		
		if(i==weights.length || maxWeight==0) {
			return 0;
		}
		if(dp[i][maxWeight]!=-1) {
			return dp[i][maxWeight];
		}
		
		if(weights[i]>maxWeight) {
			dp[i][maxWeight]= knapHelper(weights, values, maxWeight, i+1, dp);
			return dp[i][maxWeight];
		}
		else {
			int includefirst = values[i] + knapHelper(weights, values, maxWeight-weights[i], i+1, dp);
			int notInclude = knapHelper(weights, values, maxWeight, i+1, dp);
			
			dp[i][maxWeight]=Math.max(includefirst, notInclude);
			return dp[i][maxWeight];
		}
	}
	
	public static void main(String[] args) {
		int[] w = {6,1,2,4,5};
		int[] v = {10,5,4,8,6};
		
		System.out.println(knapsackM(w, v,5));
	}
}
