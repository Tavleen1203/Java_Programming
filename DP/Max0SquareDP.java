package dpQues;

public class Max0SquareDP {
	public static int maxSqaureZero(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		
		int[][] dp = new int[m][n];
		int max=0;
		
		if(n ==0 || m==0) {
			return 0;
		}
		for(int i =0; i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
					if(i==0 ||  j==0) {
						dp[i][j]=1;
					}
					else {
						dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
					}
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] test = {{0,0,0},{0,0,0},{0,0,1}};
		System.out.println(maxSqaureZero(test));

	}

}
