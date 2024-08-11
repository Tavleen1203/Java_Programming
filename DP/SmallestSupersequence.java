package dpQues;

public class SmallestSupersequence {
	public static int smallestSSR(String s, String t) {
		
		if(s.length()==0) {
			return t.length();
		}
		if(t.length()==0) {
			return s.length();
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return 1 + smallestSSR(s.substring(1),t.substring(1));
		}else {
			int op1 = smallestSSR(s.substring(1), t);
			int op2 = smallestSSR(s, t.substring(1));
			return 1 + Math.min(op1,op2);
		}
	}
	
	public static int smallestSSM(String s, String t) {
		int m = s.length();
		int n =	t.length();
		
		int[][] dp = new int[m+1][n+1];
		
		return smallestMHelper(s,t,dp);
	}

	private static int smallestMHelper(String s, String t, int[][] dp) {
		int m = s.length();
		int n =	t.length();
		
		if(m==0) {
			 dp[m][n] = n;
		}
		if(n==0) {
			 dp[m][n] = m;
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			dp[m][n]= 1 + smallestSSR(s.substring(1),t.substring(1));
			return dp[m][n];
			
		}else {
			int op1 = smallestSSR(s.substring(1), t);
			int op2 = smallestSSR(s, t.substring(1));
			dp[m][n]= 1 + Math.min(op1,op2);
			return dp[m][n];
		}
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		
		System.out.println(smallestSSM(s1, s2));
	}
}
