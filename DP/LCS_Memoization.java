package dp_2;

import java.util.Arrays;

public class LCS_Memoization {
	public static int lcsM(String s, String t) {
		int m = s.length();
		int n = t.length();
		
		int dpM[][] = new int[m+1][n+1];
		
		for(int[] row : dpM) {
			Arrays.fill(row,-1);
		}
		
		return lcsHelper(s,t,dpM);
	}
	

	private static int lcsHelper(String s, String t, int[][] dpM) {
		int m = s.length();
		int n = t.length();
		
		if(s.length() == 0  || t.length()==0) {
			dpM[m][n]=0;
			return dpM[m][n];
		}
		
		if(dpM[m][n]!=-1) {
			return dpM[m][n];
		}
		if(s.charAt(0)==t.charAt(0)) {
			dpM[m][n] =  1 + lcsHelper(s.substring(1),t.substring(1), dpM);
			return dpM[m][n];
			
		}else {
			int op1 = lcsHelper(s.substring(1),t.substring(1), dpM);
			int op2 = lcsHelper(s,t.substring(1), dpM);
			int op3 = lcsHelper(s.substring(1),t, dpM);
			
			dpM[m][n] = Math.max(op1,Math.max(op2, op3));
			return dpM[m][n];
		}		
	}


	public static void main(String[] args) {
		String s1 = "abcdegf";
		String s2 = "adnoegf";
		System.out.println(lcsM(s1,s2));
	}
	
}
