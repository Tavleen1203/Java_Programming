package dp_2;

public class MCP_Recursive {
	
	public static int minCostR(int[][] arr) {
		return helperR(arr, 0, 0);
	}
	
	private static int helperR(int[][] arr, int i, int j) {
		int m = arr.length;
		int n = arr[0].length;
		
		if(i==m-1 && j==n-1) {
			return arr[i][j];
		}
		if(i>=m || j >=n) {
			return Integer.MAX_VALUE;
		}
		
		int op1 = helperR(arr,i+1,j);
		int op2 = helperR(arr,i,j+1);
		int op3 = helperR(arr,i+1,j+1);
		
		return arr[i][j]+ Math.min(op1, Math.min(op2,op3));
	}

	public static void main(String[] args) {
		int[][] test = {{1,2,4,8},{9,5,1,6},{3,2,4,5}};
		System.out.println(minCostR(test));
		
	}

}
