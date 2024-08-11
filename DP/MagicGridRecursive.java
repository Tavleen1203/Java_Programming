package dpQues;

public class MagicGridRecursive {
	public static int minHealthR(int[][] health) {
		return minHelper(health, 0, 0);
	}

	private static int minHelper(int[][] health, int i, int j) {
		int m = health.length;
		int n = health[0].length;
		
		if( i==m-1 && j==n-1) {
			//if destination cost is given 0
			return 1;
			//if destination cost is not given 0
			//return Math.max(1, 1-health[i][j]);
		}
		
		if(i>=m || j>=n) {
			return Integer.MAX_VALUE;
		}
		
		int goRight = minHelper(health, i, j+1);
		int goDown = minHelper(health, i+1, j);
		
		int healthNeeded = Math.max(1, Math.min(goRight, goDown)- health[i][j]);
		
		return healthNeeded;
	}

	public static void main(String[] args) {
		int[][] test = {
	            {-2, -3, 3},
	            {-5, -10, 1},
	            {10, 30, -5}
	        };
		System.out.println(minHealthR(test));

	}

}
