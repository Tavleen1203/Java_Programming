package arrays_ques;
import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
	public static ArrayList<Integer> inters(int[] a1, int[] a2){
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int i=0, j=0;
		
		while(i<a1.length && j<a2.length) {
			if(a1[i]==a2[j]) {
				ans.add(a1[i]);
				i++;
				j++;
			}
			else if(a1[i]<a2[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		return ans;
	}
}
