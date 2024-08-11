package dp_1;

public class BalancedTreeDP {
	public static int balancedTreesDP(int h) {
		int[] dp = new int[h+1];
		dp[0]=1;
		dp[1]=1;
		
		for(int i =2;i<=h;i++) {
			dp[i]= (dp[i-1]*dp[i-1])+ (2*dp[i-1]*dp[i-2]);
		}
		return dp[h];
	}

	public static void main(String[] args) {
		System.out.println(balancedTreesDP(3));
	}
}
