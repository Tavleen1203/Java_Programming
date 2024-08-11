package graphs_1;

import java.util.Scanner;

public class IsConnectedBFS {
	public static boolean isConnected(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		dfs(adjMatrix, 0, visited);
		for(int i=0;i<adjMatrix.length;i++) {
			if(visited[i]==false) {
				return false;
			}
		}
		return true;
	}
	
	private static void dfs(int[][] adjMatrix, int src, boolean[] visited) {
		visited[src]=true;
		
		for(int i=0;i<adjMatrix.length;i++) {
			if(adjMatrix[src][i]==1 && visited[i]==false){
				visited[i]=true;
				dfs(adjMatrix,i,visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int adjMatrix[][] = new int[n][n];
		int e=s.nextInt();
		for(int i=0;i<e;i++){
			int first=s.nextInt();
			int second=s.nextInt();
			adjMatrix[first][second]=1;
			adjMatrix[second][first]=1;
			s.close();
		}
		
		System.out.println(isConnected(adjMatrix));

	}

}
