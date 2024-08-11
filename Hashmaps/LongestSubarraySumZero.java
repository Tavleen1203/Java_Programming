package hasmaps_ques;

import java.util.HashMap;

public class LongestSubarraySumZero {
	public static int lengthLongestZeroSum(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int maxLen = 0;
		
		for(int i=0; i<arr.length;i++) {
			sum+=arr[i];
			if(sum==0) {
				maxLen=i+1;
			}
			if(map.containsKey(sum)) {
				int prev = map.get(sum);
				int currLen = i - prev;
				if(currLen>maxLen) {
					maxLen = currLen;
				}
			}else {
				map.put(sum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[]  = {1,2,3,-1,-2,-3,4,5,6,};
		System.out.println(lengthLongestZeroSum(arr));

	}

}
