package dp_2;

import java.util.Arrays;

public class MCP_Memoization {
	
	public static int minCostM(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int[][] storage = new int[m][n];
		
		for(int[] row : storage) {
			Arrays.fill(row, -1);
		}
		
		return helperM(arr, 0, 0, storage);
	}
	
	private static int helperM(int[][] arr, int i, int j, int[][] storage) {
		int m = arr.length;
		int n = arr[0].length;
		
		if(i==m-1 && j==n-1) {
			storage[i][j]=arr[i][j];
			return storage[i][j];
		}
		if(i>=m || j >=n) {
			return Integer.MAX_VALUE;
		}
		
		int op1 = helperM(arr,i+1,j, storage);
		int op2 = helperM(arr,i,j+1, storage);
		int op3 = helperM(arr,i+1,j+1, storage);
		
		storage[i][j] = arr[i][j]+ Math.min(op1, Math.min(op2,op3));
		
		return storage[i][j];
	}

	public static void main(String[] args) {
		int[][] test = {{1,2,4,8},{9,5,1,6},{3,2,4,5}};
		System.out.println(minCostM(test));
		
	}

}
