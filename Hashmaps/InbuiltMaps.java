package hashmaps;

import java.util.HashMap;
import java.util.Set;

public class InbuiltMaps {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("abc", 1);
		map.put("def", 2);
		
		if(map.containsKey("abc")) {
			System.out.println("Yes! abc found.");
		}
		
		if(map.containsKey("abcd")) {
			System.out.println("Yes! abcd found.");
		}else {
			System.out.println("Not Found!");
		}
		
		int val = map.get("abc");
		System.out.println(val);
		
		//ABCD IS NOT IN MAP, SO ITS VALUE WOULD BE NULL
		//NOW IF WE TRY TO ASSIGN THIS TO INT VAL. THAT WOULD RAISE A NULL POINTER EXCEPTION
		
		//int val2 = map.get("abcd"); ----> MIGHT GIVE ERROT
		
		int val2=0;
		if(map.containsKey("abcd")) {
			val2 = map.get("abcd");
			System.out.println(val2);
		}else {
			System.out.println("Key not present");
		}
		
		int val3 = map.remove("abc");
		System.out.println(val3);
		
		System.out.println(map.containsValue(2));
		
		System.out.println(map.size());
		
		Set<String> keys = map.keySet();
		for(String s : keys) {
			System.out.println(s);
		}
	}

}
