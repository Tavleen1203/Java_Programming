package ll_1;

import java.util.ArrayList;

public class RemoveDups {
	public static ArrayList<Integer> remove(int[] arr){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(arr[0]);
		for(int i =1; i< arr.length; i++) {
			if(arr[i]!=arr[i-1]) {
				ans.add(arr[i]);
			}
		}
		return ans;
	}
}
