package dpQues;

public class CoinChangeDP {
	public static int countWaysDP(int[] coins, int value) {
		int n = coins.length;
		int[][] dp = new int[n+1][value+1];
		
		for(int i =0; i<=n; i++) {
			dp[i][0] = 1;
		}
		
		for(int i=n-1;i>=0;i--) {
			for(int j=1;j<=value;j++) {
				int op1 = dp[i+1][j];
				int op2 = (j>=coins[i] ? dp[i][j-coins[i]]:0);
				dp[i][j]=op1+op2;
			}
		}
		return dp[0][value];	
	}

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		System.out.println(countWaysDP(coins,5));	
	}

}
