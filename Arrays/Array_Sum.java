package arrays;

public class Array_Sum {
	public static int arraySum(int[] arr) {
		int sum = 0;
		for(int num : arr) {
			sum+=num;
		}
		return sum;
	}
}
