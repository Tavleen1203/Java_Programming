package hashmaps;

import java.util.HashMap;

public class MaxFrequency {
	public static int maxFrequencyNum(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num:arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}
		int max=Integer.MIN_VALUE;
		int ans=Integer.MIN_VALUE;
		for(int num: arr) {
			if(map.get(num)>max) {
				max=map.get(num);
				ans = num;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {1,3,3,3,3,4,5,2,2,2,2};
		System.out.println(maxFrequencyNum(arr));
	}

}
