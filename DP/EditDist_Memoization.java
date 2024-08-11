package dp_2;

import java.util.Arrays;

public class EditDist_Memoization {
	public static int editM(String s, String t) {
		int m = s.length();
		int n = t.length();
		
		int[][] dp = new int[m+1][n+1];
		for(int rows[] : dp) {
			Arrays.fill(rows, -1);
		}
		
		return editHelper(s, t, dp);
	}

	private static int editHelper(String s, String t, int[][] dp) {
		int m = s.length();
		int n = t.length();
		
		if(s.length()==0) {
			dp[m][n]=t.length();
			return dp[m][n];
		}
		if(t.length()==0) {
			dp[m][n]=s.length();
			return dp[m][n];
		}
		
		if(dp[m][n]!=-1) {
			return dp[m][n];
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			dp[m][n]= editHelper(s.substring(1),t.substring(1),dp);
			return dp[m][n];
		}  
		else {
			int insert = editHelper(s,t.substring(1),dp);
			int delete = editHelper (s.substring(1),t,dp);
			int subs = editHelper(s.substring(1), t.substring(1),dp);
			
			dp[m][n] = 1 + Math.min(insert, Math.min(delete, subs));
			return dp[m][n];
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "bbcee";
		
		System.out.println(editM(s,t));

	}

}
