package dpQues;

public class SubsetSum {
	public static boolean isSubset(int[] nums, int target) {
		return subsetHelper(nums,target,0);
	}

	private static boolean subsetHelper(int[] nums, int target, int i) {
		if(target==0) {
			return true;
		}
		
		if(i==nums.length) {
			return false;
		}
		boolean op1 = subsetHelper(nums, target, i+1);
		boolean op2 = subsetHelper(nums, target - nums[i], i+1);
		
	   return op1|| op2;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(isSubset(nums, 34));

	}

}
