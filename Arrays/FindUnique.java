package arrays_ques;

public class FindUnique {
	public static int unique(int[] arr) {
		int ans =0;
		for(int num : arr) {
			ans^=num;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,3,5,4,2};
		System.out.println(unique(arr));
	}
}
