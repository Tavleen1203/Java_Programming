package dp_2;

public class MCP_DP {
	public static int minCostDP(int[][] arr) {
		int m=arr.length;
		int n=arr[0].length;
		
		int[][] dp = new int[m][n];
		
		dp[m-1][n-1] = arr[m-1][n-1];
		
		//Last Row
		for(int j=n-2;j>=0;j--) {
			dp[m-1][j] = dp[m-1][j+1] + arr[m-1][j];
		}
		
		//Last Row
		for(int i=m-2;i>=0;i--) {
			dp[i][n-1] = dp[i+1][n-1] + arr[i][n-1];
		}
		
		for(int i = m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				dp[i][j] = arr[i][j]+ Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
			}
		}
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] test = {{1,2,4,8},{9,5,1,6},{3,2,4,5}};
		System.out.println(minCostDP(test));
	}
}
