package dpQues;

public class SmallestSuperseqDP {
	public static int smallestSuperSeqDP(String s, String t) {
		int m = s.length();
		int n = t.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i==0) {
					dp[i][j]=j;
				}
				else if(j==0) {
					dp[i][j]=i;
				}
				else if(s.charAt(0)==t.charAt(0)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j]= 1 + Math.min(dp[i-1][j], dp[i][j-1]);
				}
			}		
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		
		System.out.println(smallestSuperSeqDP(s1, s2));
	}
}
