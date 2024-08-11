package graphsQues;

import java.util.Scanner;

public class Islands {
	public static int connectedIslands(int[][] islands) {
		boolean[] visited = new boolean[islands.length];
		
		int count =0;
		
		for(int i =0; i< islands.length; i++) {
			if(visited[i]==false) {
				dfs(islands, i, visited);
				count++;
			}
			
		}
		return count;
	}
	
	private static void dfs(int[][] islands, int src, boolean[] visited) {
		visited[src]= true;
		
		for(int i =0; i<islands.length; i++) {
			if(islands[src][i]==1 && !visited[i]) {
				visited[i]=true;
				dfs(islands,i,visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int[][] matrix = new int[n][n];
		
		for(int i =0; i<e; i++) {
			int src= s.nextInt();
			int dest = s.nextInt();
			
			matrix[src][dest]=1;
			matrix[dest][src]=1;
			s.close();
		}
		System.out.println(connectedIslands(matrix));
	}

}
