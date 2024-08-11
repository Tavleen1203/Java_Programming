package dp_2;

public class EditDist_Recursive {
	public static int edR(String s, String t) {
		
		if(s.length()==0) {
			return t.length();
		}
		else if(t.length()==0) {
			return s.length();
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return edR(s.substring(1),t.substring(1));
		}  
		else {
			int insert = edR(s,t.substring(1));
			int delete = edR (s.substring(1),t);
			int subs = edR(s.substring(1), t.substring(1));
			
			return 1 + Math.min(insert, Math.min(delete, subs));
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "bbcee";
		
		System.out.println(edR(s,t));
	}
}
