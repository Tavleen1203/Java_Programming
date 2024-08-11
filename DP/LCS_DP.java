package dp_2;

public class LCS_DP {
	public static int lcsDP(String s, String t) {
		int m = s.length();
		int n = t.length();
		
		int[][] dp = new int[m+1][n+1];
		
		//dp[0][0] = 0;
		
		for(int i =0; i<=m; i++) {
			dp[i][0] = 0;
		}
		for(int j =0;j<=n;j++) {
			dp[0][j] =0;
		}
		
		for(int i =1; i<=m; i++) {
			for(int j =1; j<=n;j++) {
				if(s.charAt(m-i)==t.charAt(n-j)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "abcdegf";
		String s2 = "adnoegf";
		System.out.println(lcsDP(s1,s2));

	}
}
