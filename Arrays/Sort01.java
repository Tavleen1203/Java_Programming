package arrays_ques;

public class Sort01 {
	public static void sort01(int[] arr) {
		int low=0;
		int curr=0;
		
		while(curr<arr.length) {
			if(arr[curr]==0) {
				int temp= arr[curr];
				arr[curr]=arr[low];
				arr[low]=temp;
				curr++;
				low++;
			}else {
				curr++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] ans = {1,0,0,1,1,1,1,0,1,0};
		sort01(ans);
		for(int num : ans) {
			System.out.print(num+" ");
		}
	}
}
