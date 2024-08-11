package hashmaps;

import java.util.*;

public class RemoveDups {
	public static ArrayList<Integer> remove(int arr[]){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for(int i =0;i<arr.length;i++) {
			if(visited.containsKey(arr[i])) {
				continue;
			}
			ans.add(arr[i]);
			visited.put(arr[i], true);
		}
		return ans;		
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,34,5,55,5,6,7,2,2,3,4,10,4,4,4};
		ArrayList<Integer> ans = remove(a);
		for(int num : ans) {
			System.out.print(num+" ");
		}
	}
}
