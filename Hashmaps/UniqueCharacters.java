package hasmaps_ques;

import java.util.HashMap;

public class UniqueCharacters {
	public static String unique(String s) {
		if(s.length()==0) {
			return "";
		}
		
		String ans = "";
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for(char c : s.toCharArray()) {
			if(map.containsKey(c)) {
				continue;
			}else {
				map.put(c, true);
				ans+=c;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s = "abacdebdcdcb";
		System.out.println(unique(s));
	}
}
