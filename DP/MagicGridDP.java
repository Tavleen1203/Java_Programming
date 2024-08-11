package dpQues;

public class MagicGridDP {
	public static int minStrength(int[][] health) {
		int m = health.length;
		int n = health[0].length;
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0; j<=n;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		dp[m][n-1]=1;
		dp[m-1][n]=1;
		
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1; j>=0; j--) {
				int min = Math.min(dp[i+1][j], dp[i][j+1]) - health[i][j];
				dp[i][j] = Math.max(1, min);
			}
		}
		return dp[0][0];	
	}

	public static void main(String[] args) {
		int[][] test = {{0,-2,-3,1},{-1,4,0,-2},{1,-2,-3,0}};
		System.out.println(minStrength(test));
	}

}
