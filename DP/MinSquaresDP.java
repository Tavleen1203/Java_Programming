package dp_1;

import java.util.Arrays;

public class MinSquaresDP {
	
	public static int minSquaresDp(int n) {
		
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		//dp[1]=1;
		
		for(int i = 1;i<=n;i++) {
			for(int j=1;j*j<=i;j++) {
				dp[i]=Math.min(dp[i-(j*j)]+1, dp[i]);
			}
		}
		return dp[n];	
	}

	public static void main(String[] args) {
		int n=108;
		System.out.println(minSquaresDp(n));

	}

}
