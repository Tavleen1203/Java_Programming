package dpQues;

public class SubsetSumDP {
	public static boolean isSubsetDP(int[] nums, int target) {
		int n = nums.length;
		
		boolean[][] dp = new boolean[n+1][target+1];
		
		for(int i =0; i<=n; i++) {
			dp[i][0]=true;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j =1;j<=target;j++) {
				if(j<nums[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
				}
			}
		}
		return dp[n][target];
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(isSubsetDP(nums, 9));

	}

}
