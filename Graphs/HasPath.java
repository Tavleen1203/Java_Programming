package graphs_1;

import java.util.Scanner;

public class HasPath {
	public static boolean hasPath(int[][] adjMatrix, int src, int dest) {
		if(src>adjMatrix.length-1|| dest>adjMatrix.length-1) {
			return false;
		}	
		boolean[] visited=new boolean[adjMatrix.length];
		return hasPathHelper(adjMatrix,src,dest,visited);

	}
	
	private static boolean hasPathHelper(int[][] adjMatrix, int src, int dest, boolean[] visited) {
		if(src==dest) {
			return true;
		}
		visited[src]=true;
		
		for(int i=0;i<adjMatrix.length;i++) {
			if(adjMatrix[src][i]==1 && visited[i]==false) {
				if(hasPathHelper(adjMatrix,i,dest,visited)) {
					return true;
				}
			}
		}
		return false;
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
		
		System.out.println(hasPath(adjMatrix,1,3));

	}

}
