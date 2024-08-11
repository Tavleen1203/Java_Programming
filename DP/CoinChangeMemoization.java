package dpQues;

import java.util.Arrays;

public class CoinChangeMemoization {
	public static int changeM(int[] coins, int value) {
		int[][] dp = new int[coins.length+1][value+1];
		for(int rows[]:dp) {
			Arrays.fill(rows, -1);
		}
		
		return changeMHelper(coins, value, 0, dp);
	}

	private static int changeMHelper(int[] coins, int value, int i, int[][] dp) {
		
		if(value==0) {
			return 1;
		}
		
		if(i>=coins.length || value<0) {
			return 0;
		}
		
		if(dp[i][value]!=-1) {
			return dp[i][value];
		}else {
			int op1 = changeMHelper(coins, value - coins[i], i, dp);
			int op2 = changeMHelper(coins, value, i+1, dp);
			
			dp[i][value] = op1 + op2;
			return dp[i][value];
		}	
	}

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		System.out.println(changeM(coins,5));	
	}

}
