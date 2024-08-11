package arrays;

public class ArrangeNums {
	public static void arrange(int[] arr, int n) {
		int mid = (n-1)/2;
		int start=1;
		for(int i=0; i<=mid;i++) {
			arr[i]=start;
			start+=2;
		}
		start=1;
		for(int i=mid+1;i<n;i++) {
			arr[i]=start+1;
			start+=2;
		}
	}
	
	public static void main(String[] args) {
		int n=5;
		int[] arr = new int[n];
		arrange(arr, 5);
		for(int num: arr) {
			System.out.print(num+" ");
		}
	}
}
