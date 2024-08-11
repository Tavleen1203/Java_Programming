package dp_2;

public class EditDist_DP {
	public static int editDP(String  s, String t) {
		
		int m = s.length();
	    int n = t.length();
	    
	    int[][] dp = new int[m+1][n+1];
	    
	    for(int j=0;j<=n;j++) {
	    	dp[0][j]=j;
	    }
	    for(int i=0;i<=m;i++) {
	    	dp[i][0]=i;
	    }
	    
	    for(int i =1; i<=m;i++) {
	    	for(int j=1; j<=n; j++) {
	    		if(s.charAt(m-i)==t.charAt(n-j)) {
	    			dp[i][j] = dp[i-1][j-1];
	    		}else {
	    			dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
	    		}
	    	}
	    }
	    return dp[m][n];  
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "bbcee";
		
		System.out.println(editDP(s,t));
	}

}
