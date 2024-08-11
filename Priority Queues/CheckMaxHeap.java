package pq_assignment;

public class CheckMaxHeap {
	public static boolean checkHeap(int[] arr) {
		int n = arr.length;
		for(int i=0;i<=n/2-1;i++) {
			int lc = 2*i+1;
			int rc = lc+1;
			if(arr[i]<arr[lc]) {
				return false;
			}
			else if(rc<n && arr[i]<arr[rc]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = {10,5,8,3,2,6,9};
		System.out.println(checkHeap(arr));
	}
}
