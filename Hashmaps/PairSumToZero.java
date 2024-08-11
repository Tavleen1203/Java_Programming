package hashmaps;

import java.util.HashMap;

public class PairSumToZero {
	public static void pairCount(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int num : arr) {
			int pairNum = -num;
			if(map.containsKey(pairNum)) {
				int count = map.get(pairNum);
				for(int i=0;i<count;i++) {
					System.out.println("("+pairNum+","+num+")");
				}
			}
			map.put(num, map.getOrDefault(num, 0)+1);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,-1,-2,-5,5};
		pairCount(arr);
	}

}
