package dp_1;

import java.util.Arrays;

public class BalancedTreeMem {
	
	public static long findBalancedTM(int h) {
		
		long[] dp = new long[h+1];
		Arrays.fill(dp,-1);
		
		return findBalancedTMHelper(h,dp);
		
	}
	
	private static long findBalancedTMHelper(int h, long[] dp) {
		if(h==0 || h==1){
			dp[h]=1;
			return dp[h];
		}
		if(dp[h]!=-1) {
			return dp[h];
		}else {
			long x = findBalancedTMHelper(h-1,dp);
			long y = findBalancedTMHelper(h-2,dp);
			dp[h]= (x*x)+ (2*x*y);
		}	
		return dp[h];
	}

	
	public static void main(String[] args) {
		System.out.println(findBalancedTM(5));
     }

}
