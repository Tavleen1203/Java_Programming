package arrays;

public class LargestNum {
	public static int lagest(int[] arr) {
		int maxNum = Integer.MIN_VALUE;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>maxNum) {
				maxNum=arr[i];
			}
		}
		return maxNum;
	}
}
