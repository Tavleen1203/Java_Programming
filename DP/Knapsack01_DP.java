package dp_2;

public class Knapsack01_DP {
	
	public static int knapsackDP(int[] weights, int[] values, int maxWeight) {
		
		int[][] dp = new int[weights.length+1][maxWeight+1];
		
		for(int i = weights.length-1 ;i>=0;i--) {
			for(int j=0; j<=maxWeight;j++) {
				int ans;
				if(weights[i]<=j) {
					int include = values[i] + dp[i+1][j-weights[i]];
					int exclude = dp[i+1][j];
					ans = Math.max(include, exclude);
				}else {
					ans = dp[i+1][j];
				}
				dp[i][j]=ans;
			}			
		}
		
		return dp[0][maxWeight];
	}

	public static void main(String[] args) {
		int[] w = {6,1,2,4,5};
		int[] v = {10,5,4,8,6};
		
		System.out.println(knapsackDP(w, v,5));

	}

}
