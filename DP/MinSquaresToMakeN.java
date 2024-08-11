package dp_1;

import java.util.Arrays;

public class MinSquaresToMakeN {
	public static int minSquaresR(int n) {
		if(n==0) {
			return 0;
		}	
		int min=Integer.MAX_VALUE;
		
		for(int i =1;i*i<=n;i++) {
			int curr = minSquaresR(n-(i*i));
			if(min>curr) {
				min=curr;
			}
		}
		return min+1;
	}
	
	public static int minSquaresM(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);	
		return minHelper(n,dp);
	}
	
	private static int minHelper(int n, int[] dp) {
		if(n==0) {
			return 0;
		}
		
        int min = Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int curr;
			if(dp[n-(i*i)]==-1) {
				curr= minHelper(n-(i*i),dp);
			}else {
				curr= dp[n-(i*i)];
			}
			if(min>curr) {
				min=curr;
			}
		}
		return 1+ min;
    }


	public static void main(String[] args) {
		int n=41;
		System.out.println(minSquaresM(n));
	}
}
