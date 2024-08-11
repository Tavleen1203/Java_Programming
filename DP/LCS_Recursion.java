package dp_2;

public class LCS_Recursion {
	
	public static int lcsR(String s, String t) {
		
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		if(s.charAt(0)==t.charAt(0)) {
			return 1 + lcsR(s.substring(1),t.substring(1));
		}else {
			int op1 = lcsR(s.substring(1),t.substring(1));
			int op2 = lcsR(s,t.substring(1));
			int op3 = lcsR(s.substring(1),t);
			
			return Math.max(op1,Math.max(op2, op3));
		}		
	}

	public static void main(String[] args) {
		String s1 = "abcdegf";
		String s2 = "adnoegf";
		System.out.println(lcsR(s1,s2));
	}
}
